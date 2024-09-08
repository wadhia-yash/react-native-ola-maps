package com.olamaps

import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.view.View
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.ola.mapsdk.interfaces.OlaMapCallback
import com.ola.mapsdk.view.OlaMap
import com.ola.mapsdk.view.OlaMapView

class OlaMapManager(reactContext: ReactApplicationContext): SimpleViewManager<OlaMapView>() {
  override fun getName(): String {
    return "MapView"
  }

  override fun createViewInstance(reactContext: ThemedReactContext): OlaMapView {
    val mapView = OlaMapView(reactContext)

    val apiKey = getApiKey(reactContext)

    mapView.addOnLayoutChangeListener { v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom ->
      onLayoutChange(v, left, top, right, bottom, oldLeft, oldTop, oldRight, oldBottom)
    }

    Log.d("OlaMap API Key", "$apiKey")
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

  override fun onLayoutChange(
    v: View?,
    left: Int,
    top: Int,
    right: Int,
    bottom: Int,
    oldLeft: Int,
    oldTop: Int,
    oldRight: Int,
    oldBottom: Int
  ) {
    // Check if the layout has actually changed
    if (left != oldLeft || top != oldTop || right != oldRight || bottom != oldBottom) {
      // Update the map view's layout or other properties as needed
      v?.apply {
        // This could involve adjusting the size or repositioning the view
        layout(left, top, right, bottom)

        // If necessary, request a layout update
        requestLayout()

        // If you want to perform additional operations when layout changes, add them here
        // For example, re-centering the map, adjusting markers, etc.
      }

      // Log the layout change for debugging purposes
      Log.d("OlaMapManager", "Map layout changed: left=$left, top=$top, right=$right, bottom=$bottom")
    }
  }
}
