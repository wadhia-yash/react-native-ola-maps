package com.olamaps

import android.content.Context
import android.content.pm.PackageManager
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext

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

    return MapView(context, apiKey = apiKey)
  }

  private fun getApiKey(context: Context): String? {
    val appInfo = context.packageManager.getApplicationInfo(context.packageName, PackageManager.GET_META_DATA)
    return appInfo.metaData?.getString("com.ola.mapsdk.API_KEY")
  }
}
