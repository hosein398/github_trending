package ir.oxima.githubtrending

import android.app.Application
import android.content.Context
import android.os.Handler
import com.androidnetworking.AndroidNetworking

class ApplicationLoader : Application() {

    companion object {
        @Volatile
        lateinit var appContext: Context

        @Volatile
        lateinit var applicationHandler: Handler
    }

    override fun onCreate() {
        super.onCreate()

        appContext = getApplicationContext()
        applicationHandler = Handler(applicationContext.mainLooper)
        AndroidNetworking.initialize(appContext)

    }
}