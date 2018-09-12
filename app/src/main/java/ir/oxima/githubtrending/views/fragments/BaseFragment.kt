package ir.oxima.githubtrending.views.fragments

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import ir.oxima.githubtrending.NavigationManager
import ir.oxima.githubtrending.other.utilities.ConnectivityBroadcastReceiver
import ir.oxima.githubtrending.views.activities.BaseActivity

open class BaseFragment : Fragment() ,
                     ConnectivityBroadcastReceiver.OnConnectivityListener{

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBaseActivity().setOnConnectivityListener(this)
    }

    fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onConnectivityChange(isConnectedOrConnecting: Boolean) {

    }

}