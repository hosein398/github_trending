package ir.oxima.githubtrending.other.utilities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class ConnectivityBroadcastReceiver : BroadcastReceiver() {


    private var onConnectivityListener: OnConnectivityListener? = null

    fun setOnConnectivityListener(onConnectivityListener: OnConnectivityListener) {
        this.onConnectivityListener = onConnectivityListener
    }

    override fun onReceive(context: Context, intent: Intent) {
        if (onConnectivityListener != null) {
            onConnectivityListener!!.onConnectivityChange(isConnectedOrConnecting(context))
            return
        }

    }

    private fun isConnectedOrConnecting(context: Context): Boolean {

        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo

        return networkInfo?.isConnectedOrConnecting ?: false
    }

    interface OnConnectivityListener {
        fun onConnectivityChange(isConnectedOrConnecting: Boolean)
    }
}