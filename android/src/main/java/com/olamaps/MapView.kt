package com.olamaps

import android.util.Log
import android.widget.FrameLayout
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.WritableNativeMap
import com.facebook.react.uimanager.ThemedReactContext
import com.ola.mapsdk.interfaces.OlaMapCallback
import com.ola.mapsdk.model.OlaLatLng
import com.ola.mapsdk.view.OlaMap
import com.ola.mapsdk.view.OlaMapView

class MapView(context: ThemedReactContext, apiKey: String, manager: OlaMapManager) : FrameLayout(context), OlaMapCallback {

  private lateinit var initialRegion: ReadableMap
  private var initialRegionSet: Boolean = false
  private var isMapLoaded: Boolean = false
  private lateinit var olaMap: OlaMap
  private var manager: OlaMapManager
  private var olaMapView: OlaMapView = OlaMapView(context)
  private var reactContext: ThemedReactContext

  init {
      initMap(apiKey)

    this.manager = manager
    this.reactContext = context
  }

  private fun initMap(apiKey: String) {
    addView(olaMapView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))

    olaMapView.getMap(apiKey = apiKey, olaMapCallback = this)
  }

  override fun onMapReady(olaMap: OlaMap) {
    Log.d("OlaMap", "Map is ready!")
    this.olaMap = olaMap
    isMapLoaded = true
    manager.pushEvent(context = this.reactContext, this, "onMapReady", WritableNativeMap())
    // If initial region has been set before the map was ready, move to it
    if (!initialRegionSet && ::initialRegion.isInitialized) {
      moveToRegion(initialRegion)
      initialRegionSet = true
    }
  }

  override fun onMapError(error: String) {
    Log.e("OlaMap", "Map initialization error: $error")
  }

  fun moveToRegion(region: ReadableMap) {
    if (region == null || !isMapLoaded) return
    val lng = region.getDouble("longitude")
    val lat = region.getDouble("latitude")
    val alt = region.getDouble("altitude")
    val maximumZ = region.getDouble("zoomLevel")

    olaMap.moveCameraToLatLong(OlaLatLng(latitude = lat, longitude = lng, altitude = alt), zoomLevel = maximumZ)
  }

  fun setInitialRegion(initialRegion: ReadableMap) {
    this.initialRegion = initialRegion
    if (!initialRegionSet && isMapLoaded) {
      moveToRegion(initialRegion)
      initialRegionSet = true
    }
  }
}
