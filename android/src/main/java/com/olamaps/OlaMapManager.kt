package com.olamaps

import android.content.Context
import android.content.pm.PackageManager
import android.view.View
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.WritableMap
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.events.RCTEventEmitter

class OlaMapManager(reactContext: ReactApplicationContext): SimpleViewManager<MapView>() {
  private val REACT_CLASS: String = "CliqueMap"

  override fun getName(): String {
    return REACT_CLASS
  }

  override fun createViewInstance(context: ThemedReactContext): MapView {
    val apiKey = getApiKey(context)

    if (apiKey.isNullOrEmpty()) {
      throw IllegalStateException("API key is missing. Please provide a valid API key.")
    }

    return MapView(context, apiKey = apiKey, this)
  }

  private fun getApiKey(context: Context): String? {
    val appInfo = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
    return appInfo.metaData?.getString("com.ola.mapsdk.API_KEY")
  }

  @ReactProp(name = "initialRegion")
  fun setInitialRegion(mapView: MapView, initialRegion: ReadableMap) {
    mapView.setInitialRegion(initialRegion)
  }

  override fun getExportedCustomDirectEventTypeConstants(): MutableMap<String, Map<String, String>>? {
    val map = mutableMapOf(
      "onMapReady" to mapOf("registrationName" to "onMapReady"),
    )

    return map
  }

  fun pushEvent(context: ThemedReactContext, view: View, name: String, data: WritableMap) {
    context.getJSModule(RCTEventEmitter::class.java).receiveEvent(view.id, name, data)
  }
}
