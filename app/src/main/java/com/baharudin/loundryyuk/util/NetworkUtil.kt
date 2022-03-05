package com.baharudin.loundryyuk.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities

fun isNetworkIsConnected(context: Context) : Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetwork
    val networkCapability = connectivityManager.getNetworkCapabilities(activeNetwork)
    return networkCapability != null &&
            networkCapability.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)

}