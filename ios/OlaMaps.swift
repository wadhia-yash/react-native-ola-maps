import Foundation
import OlaMapCore

@objc(OlaMapViewManager)
class OlaMapViewManager: RCTViewManager {
    override func view() -> UIView! {
        return OlaMapView()
    }
    
    override class func requiresMainQueueSetup() -> Bool {
        return true
    }
    
    @objc
    func setIsMapReady(_ view: OlaMapView, onMapReady: @escaping RCTBubblingEventBlock) {
        view.onMapReady = onMapReady
    }
}

@objc(OlaMapView)
class OlaMapView: UIView, OlaMapServiceDelegate {
    private var olaMap: OlaMapService?
    
    @objc var initialRegion: NSDictionary? {
        didSet {
            NSLog("initialRegion set: \(String(describing: initialRegion))")
            initializeMap()
        }
    }
    
    @objc var onMapReady: RCTBubblingEventBlock?
    @objc var tileUrl: NSString?
    
    override init(frame: CGRect) {
        super.init(frame: frame)
        NSLog("Map initialized")
        initializeMap()
    }
    
    required init?(coder: NSCoder) {
        super.init(coder: coder)
        NSLog("Map initialized")
        initializeMap()
    }
    
    @objc
    func initializeMap() {
        guard let _apiKey = Bundle.main.object(forInfoDictionaryKey: "OlaMapAPIKey") as? String else {
            NSLog("API Key not found in Info.plist")
            return
        }
        guard let _projectId = Bundle.main.object(forInfoDictionaryKey: "OlaMapProjectId") as? String else {
            NSLog("Project Id not found in Info.plist")
            return
        }
        
        let projectId = _projectId;
        NSLog("Tile URL: \(tileUrl)")
        let tileUrlString = (tileUrl as String?) ?? "https://api.olamaps.io/tiles/vector/v1/styles/default-light-standard/style.json?key=0.4.0"
        guard let url = URL(string: tileUrlString) else { return }
        olaMap = OlaMapService(auth: .apiKey(key: _apiKey), tileURL: url, projectId: projectId)
        olaMap?.delegate = self
        
        if let olaMap = olaMap, let initialRegion = initialRegion {
            NSLog("initial region \(initialRegion)")
            if let latitude = initialRegion["latitude"] as? Double,
               let longitude = initialRegion["longitude"] as? Double,
               let altitude = initialRegion["altitude"] as? Double,
               let zoomLevel = initialRegion["zoomLevel"] as? Double {
                let coordinate = OlaCoordinate(latitude: latitude, longitude: longitude)
                olaMap.loadMap(onView: self, coordinate: coordinate, showCurrentLocationIcon: false)
                olaMap.setCamera(at: coordinate, zoomLevel: zoomLevel)
                olaMap.setDebugLogs(true)
                if let onMapReady = onMapReady {
                    onMapReady([:])
                }
            }
        }
    }
    
    
    func didChangeCamera() {
        NSLog("Map changed camera")
    }
    
    func regionIsChanging(_ gesture: OlaMapCore.OlaMapGesture) {
        NSLog("Map region changed")
    }
    
    func mapFailedToLoad(_ error: Error) {
        NSLog("Map failed to load: \(error)")
    }
}
