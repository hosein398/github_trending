package ir.oxima.githubtrending.views

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Build
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetDialog
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import ir.oxima.githubtrending.R
import ir.oxima.githubtrending.other.utilities.AndroidUtilities

class DialogBuilder {

    private lateinit var context: Context

    private var isAlertDailog: Boolean = false
    private var txt_title: TextView? = null
    private var txt_message: TextView? = null
    private var dialog: Dialog? = null
    private var btn_ok: Button? = null
    private var btn_cancel: Button? = null
    private var container_custom_view: ViewGroup? = null
    private var onClickListener: OnClickListener? = null

    interface OnClickListener {
        fun onClick(dialog: Dialog?)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

    constructor(context: Context?){
        if (context == null) {
            return
        }
        this.context = context
    }


    fun asBottomSheetDialog(canelable: Boolean): DialogBuilder {
        isAlertDailog = false
        if (context == null) {
            return this
        }
        dialog = BottomSheetDialog(context)
        if (context == null || dialog == null) {
            return this
        }
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.view_dialog_builder, null)
        dialog!!.setContentView(view)
        val bottomSheetBehavior = BottomSheetBehavior.from(view.getParent() as View)
        bottomSheetBehavior.peekHeight = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300f, context.resources.displayMetrics).toInt()
        dialog!!.setCancelable(canelable)
        initViews(view)
        return this
    }

    fun asAlertDialog(canelable: Boolean): DialogBuilder {
        isAlertDailog = true
        if (context == null) {
            return this
        }
        val mAlertDialog = AlertDialog.Builder(context)
        if (context == null || mAlertDialog == null) {
            return this
        }
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.view_dialog_builder, null)
        mAlertDialog.setView(view)
        mAlertDialog.setCancelable(canelable)
        dialog = mAlertDialog.create()
        initViews(view)
        return this
    }

    private fun initViews(view: View) {
        txt_title = view.findViewById(R.id.txt_title)
        txt_message = view.findViewById(R.id.txt_message)
        container_custom_view = view.findViewById(R.id.container_custom_view)
        btn_cancel = view.findViewById(R.id.btn_cancel)
        btn_ok = view.findViewById(R.id.btn_ok)
        btn_cancel!!.visibility = View.GONE
        btn_ok!!.visibility = View.GONE
    }

    fun show(): DialogBuilder {
        if (dialog == null || dialog!!.isShowing) {
            return this
        }

        if (Build.VERSION.SDK_INT >= 21 && isAlertDailog) {
            dialog!!.window!!.setBackgroundDrawable(ContextCompat.getDrawable(context!!, R.drawable.popup_fixed_alert))
        }

        dialog!!.show()
        return this
    }

    fun dismiss(): DialogBuilder {
        if (dialog == null || !dialog!!.isShowing) {
            return this
        }
        dialog!!.dismiss()
        return this
    }


    fun isShowing(): Boolean {
        return if (dialog == null) {
            false
        } else dialog!!.isShowing
    }

    fun setTitle(title: CharSequence?): DialogBuilder {
        if (title == null) {
            txt_title!!.visibility = View.GONE
            return this
        }
        txt_title!!.visibility = View.VISIBLE
        txt_title!!.text = title
        return this
    }

    fun setMessage(msg: CharSequence?): DialogBuilder {
        if (msg == null) {
            txt_message!!.visibility = View.GONE
            return this
        }
        txt_message!!.visibility = View.VISIBLE
        txt_message!!.setPadding(AndroidUtilities.dp(10f), AndroidUtilities.dp(10f), AndroidUtilities.dp(10f), AndroidUtilities.dp(10f))
        txt_message!!.text = msg
        return this
    }

    fun setMessageGravity(gravity: Int): DialogBuilder {
        txt_message!!.gravity = gravity
        return this
    }

    fun setCustomView(view: View): DialogBuilder {
        container_custom_view!!.addView(view)
        return this
    }

    fun setCustomView(view: View, layoutParams: ViewGroup.LayoutParams): DialogBuilder {
        container_custom_view!!.addView(view, layoutParams)
        return this
    }

    fun setTitleColor(color: Int): DialogBuilder {
        txt_title!!.setTextColor(color)
        return this
    }

    fun setPositiveButton(text: CharSequence?, onClickListener: OnClickListener?) {
        if (text != null) {
            btn_ok!!.visibility = View.VISIBLE
            btn_ok!!.text = text

            btn_ok!!.setOnClickListener(View.OnClickListener {
                if (onClickListener != null) {
                    onClickListener.onClick(dialog)
                }
            })
        } else {
            btn_ok!!.visibility = View.GONE
        }
    }

    fun setNegativeButton(text: CharSequence?, onClickListener: OnClickListener?) {
        if (text != null) {
            btn_cancel!!.visibility = View.VISIBLE
            btn_cancel!!.text = text
            btn_cancel!!.setOnClickListener(View.OnClickListener {
                if (onClickListener != null) {
                    onClickListener.onClick(dialog)
                }
            })
            return
        }
        btn_cancel!!.visibility = View.GONE
    }

}