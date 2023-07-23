package com.example.animehub.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.widget.Toast

class NetworkManager: ConnectivityManager.NetworkCallback() {
    override fun onAvailable(network: Network) {
        // Network is available
    }

    override fun onLost(network: Network) {
        // Network is lost
    }
}