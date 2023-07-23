package com.example.animehub.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

class ConnectionManager {

    fun checkConnectivity(context: Context): Boolean{

        val connectionManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork: NetworkInfo? = connectionManager.activeNetworkInfo
        return if (activeNetwork?.isConnected != null){
            activeNetwork.isConnected
        } else{
            false
        }
    }
}

// Better approach -> Use network callbacks