package com.olamaps

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.ola.mapsdk.interfaces.OlaMapCallback
import com.ola.mapsdk.view.OlaMap
import com.ola.mapsdk.view.OlaMapView

class OlaMapManager(reactContext: ReactApplicationContext): SimpleViewManager<OlaMapView>() {
  override fun getName(): String {
    return "OlaMapView"
  }

  override fun createViewInstance(reactContext: ThemedReactContext): OlaMapView {
    val mapView = OlaMapView(reactContext)

    val apiKey = getApiKey(reactContext)

    if (apiKey != null) {
      mapView.getMap(apiKey = apiKey, olaMapCallback = object : OlaMapCallback {
        override fun onMapReady(olaMap: OlaMap) {
          Log.d("OlaMap", "Map is ready")
        }

        override fun onMapError(error: String) {
          Log.e("OlaMap", "Error loading map: $error")
        }
      })
    }

    return mapView
  }

  private fun getApiKey(context: Context): String? {
    val appInfo = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
    return appInfo.metaData?.getString("com.ola.mapsdk.API_KEY")
  }
}
