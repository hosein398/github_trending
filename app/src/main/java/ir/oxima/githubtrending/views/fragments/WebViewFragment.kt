package ir.oxima.githubtrending.views.fragments

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import ir.oxima.githubtrending.R

class WebViewFragment : BaseFragment(){


    private var mRootView: View? = null
    private var container_web_view: ViewGroup? = null
    private var prg_loading: ProgressBar? = null
    private var webView: WebView? = null
    private var url: String? = null

    override fun onPause() {
        super.onPause()
    }

    companion object {
        @Synchronized
        fun instance(url : String?): WebViewFragment {
            var fragment = WebViewFragment()
            fragment.url = url
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.fragment_web_view, null)
        }
        initViews()
        setupWebView()
        return mRootView
    }

    private fun initViews() {
        prg_loading = mRootView!!.findViewById(R.id.prg_loading)
        container_web_view = mRootView!!.findViewById(R.id.container_web_view)
        webView = WebView(context)
        container_web_view!!.addView(webView)
    }

    private fun setupWebView() {
        webView!!.loadUrl(url)
        webView!!.getSettings().javaScriptEnabled = true

        webView!!.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                prg_loading!!.setVisibility(View.GONE)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                prg_loading!!.setVisibility(View.VISIBLE)
            }
        }


        webView!!.webChromeClient = object : WebChromeClient() {

            override fun onProgressChanged(view: WebView, newProgress: Int) {
                super.onProgressChanged(view, newProgress)
                prg_loading!!.setProgress(newProgress)
            }

        }
    }

}