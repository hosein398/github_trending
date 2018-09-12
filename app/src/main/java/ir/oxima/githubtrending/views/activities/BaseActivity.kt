package ir.oxima.githubtrending.views.activities

import android.app.Dialog
import android.content.ComponentName
import android.content.DialogInterface
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.support.customtabs.CustomTabsClient
import android.support.customtabs.CustomTabsIntent
import android.support.customtabs.CustomTabsServiceConnection
import android.support.customtabs.CustomTabsSession
import android.support.design.widget.Snackbar
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import ir.oxima.githubtrending.NavigationManager
import ir.oxima.githubtrending.R
import ir.oxima.githubtrending.other.components.TextViewCell
import ir.oxima.githubtrending.other.components.toasty.Toasty
import ir.oxima.githubtrending.other.constant.C
import ir.oxima.githubtrending.other.utilities.*
import ir.oxima.githubtrending.views.DialogBuilder

open class BaseActivity : AppCompatActivity(),
        ConnectivityBroadcastReceiver.OnConnectivityListener{

    private val CUSTOM_TAB_PACKAGE_NAME = "com.android.chrome"
    private var mClient: CustomTabsClient? = null
    private var mCustomTabsSession: CustomTabsSession? = null
    private var mCustomTabsServiceConnection: CustomTabsServiceConnection? = null
    private var customTabsIntent: CustomTabsIntent? = null
    protected var mProgressDialog: DialogBuilder? = null
    protected var dialogBuilder: DialogBuilder? = null

    private var connectionBroadcast: ConnectivityBroadcastReceiver? = null
    private var onConnectivityListener: ConnectivityBroadcastReceiver.OnConnectivityListener? = null


    fun setOnConnectivityListener(onConnectivityListener: ConnectivityBroadcastReceiver.OnConnectivityListener) {
        this.onConnectivityListener = onConnectivityListener
    }


    override fun onStart() {
        super.onStart()
        connectionBroadcast = ConnectivityBroadcastReceiver()
        connectionBroadcast!!.setOnConnectivityListener(this)
        registerReceiver(connectionBroadcast, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onStop() {
        super.onStop()
        if (connectionBroadcast != null) {
            unregisterReceiver(connectionBroadcast)
        }
        needHideProgressDialog()
    }

    override fun onResume() {
        super.onResume()
        if (connectionBroadcast == null) {
            connectionBroadcast = ConnectivityBroadcastReceiver()
            connectionBroadcast!!.setOnConnectivityListener(this)
        }
        registerReceiver(connectionBroadcast, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }


    override fun onConnectivityChange(isConnectedOrConnecting: Boolean) {
        if (onConnectivityListener != null) {
            onConnectivityListener!!.onConnectivityChange(isConnectedOrConnecting)
            return
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        NavigationManager.getInstance().init(getSupportFragmentManager())

    }


    fun setupCustomTabs(url: String) {
        mCustomTabsServiceConnection = object : CustomTabsServiceConnection() {
            override fun onCustomTabsServiceConnected(componentName: ComponentName, customTabsClient: CustomTabsClient) {
                mClient = customTabsClient
                mClient!!.warmup(0L)
                mCustomTabsSession = mClient!!.newSession(null)
            }

            override fun onServiceDisconnected(name: ComponentName) {
                mClient = null
            }
        }

        CustomTabsClient.bindCustomTabsService(this@BaseActivity, CUSTOM_TAB_PACKAGE_NAME, mCustomTabsServiceConnection)

        customTabsIntent = CustomTabsIntent.Builder(mCustomTabsSession)
                .setToolbarColor(Theme.getColor(this, R.color.colorPrimary))
                .setStartAnimations(this, R.anim.slide_in_right, R.anim.no_animation)
                .setExitAnimations(this, R.anim.no_animation, R.anim.slide_out_right)
                .setShowTitle(true)
                .build()

        customTabsIntent!!.launchUrl(this@BaseActivity, Uri.parse(url))
    }


    fun needShowProgressDialog(canelable: Boolean) {
        needShowProgressDialog(LocaleController.getText(this, R.string.please_wait), canelable)
    }

    fun needShowProgressDialog(msg: String, canelable: Boolean) {
        if (mProgressDialog == null) {
            mProgressDialog = DialogBuilder(this).asAlertDialog(canelable)
        }
        mProgressDialog!!.setTitle(null)
        mProgressDialog!!.setMessage(null)

        val linearLayout = LinearLayout(this)
        linearLayout.orientation = LinearLayout.VERTICAL

        val progressBar = ProgressBar(this)
        linearLayout.addView(progressBar, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER, 0, AndroidUtilities.dp(7f), 0, AndroidUtilities.dp(7f)))

        val line = View(this)
        line.setBackgroundColor(Theme.getColor(this, R.color.material_grey200))
        linearLayout.addView(line, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, 1, Gravity.CENTER))

        val txt_sub_message = TextViewCell(this)
        txt_sub_message.setTextColor(Theme.getColor(this, R.color.colorPrimaryDark))
        txt_sub_message.setTypeface(AndroidUtilities.getTypeface(C.defaultMediumFont))
        txt_sub_message.setTextSize(13f)
        txt_sub_message.setGravity(Gravity.CENTER)
        txt_sub_message.setText(msg)
        txt_sub_message.setBackgroundColor(Theme.getColor(this, R.color.material_white))
        txt_sub_message.setPadding(AndroidUtilities.dp(10f), AndroidUtilities.dp(20f), AndroidUtilities.dp(10f), AndroidUtilities.dp(20f))
        linearLayout.addView(txt_sub_message, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER))

        mProgressDialog!!.setCustomView(linearLayout, LayoutHelper.createLinear(LayoutHelper.MATCH_PARENT, LayoutHelper.WRAP_CONTENT, Gravity.CENTER))
        mProgressDialog!!.show()
    }

    fun needHideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing()) {
            mProgressDialog!!.dismiss()
        }
    }

    fun needShowAlertDialog(message: String?, canelable: Boolean) {

        needHideAlertDialog()

        dialogBuilder = DialogBuilder(this).asAlertDialog(canelable)
        dialogBuilder!!.setTitle(LocaleController.getText(this, R.string.app_name))
        dialogBuilder!!.setMessage(message)
        dialogBuilder!!.setPositiveButton(LocaleController.getText(this, R.string.ok), object : DialogBuilder.OnClickListener {
            override fun onClick(dialog: Dialog?) {
                dialog!!.dismiss()
            }
        })
        dialogBuilder!!.show()

        val mAlertDialog = AlertDialog.Builder(this)
        mAlertDialog.setPositiveButton(LocaleController.getText(this, R.string.ok), DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() })
    }

    fun needHideAlertDialog() {
        if (dialogBuilder != null && dialogBuilder!!.isShowing()) {
            dialogBuilder!!.dismiss()
        }
    }

    fun needShowToast(message: String) {
        Toasty.normal(this, message, Toast.LENGTH_LONG).show()
    }

    fun needShowSnackbar(view: View, message: String) {
        Snackbar.make(view, AndroidUtilities.typeface(C.defaultNormalFont, message), Snackbar.LENGTH_LONG).show()
    }
}