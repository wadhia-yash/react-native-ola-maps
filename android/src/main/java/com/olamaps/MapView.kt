package com.olamaps

import android.content.Context
import android.util.Log
import android.widget.FrameLayout
import com.ola.mapsdk.interfaces.OlaMapCallback
import com.ola.mapsdk.view.OlaMap
import com.ola.mapsdk.view.OlaMapView

class MapView(context: Context, apiKey: String) : FrameLayout(context), OlaMapCallback {

  private var olaMapView: OlaMapView = OlaMapView(context)

  init {
      initMap(apiKey)
  }

  private fun initMap(apiKey: String) {
    addView(olaMapView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))

    olaMapView.getMap(apiKey = apiKey, olaMapCallback = this)
  }

  override fun onMapReady(olaMap: OlaMap) {
    Log.d("OlaMap", "Map is ready!")
  }

  override fun onMapError(error: String) {
    Log.e("OlaMap", "Map initialization error: $error")
  }
}
