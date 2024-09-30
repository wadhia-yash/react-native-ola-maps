#import <React/RCTViewManager.h>
#import <React/RCTEventEmitter.h>
#import <React/RCTBridge.h>

@interface RCT_EXTERN_MODULE(OlaMapViewManager, RCTViewManager)
RCT_EXPORT_VIEW_PROPERTY(onMapReady, RCTBubblingEventBlock)
RCT_EXPORT_VIEW_PROPERTY(initialRegion, NSDictionary)
RCT_EXPORT_VIEW_PROPERTY(tileUrl, NSString)
@end
