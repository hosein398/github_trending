package ir.oxima.githubtrending.other.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import ir.oxima.githubtrending.R;
import ir.oxima.githubtrending.other.components.toasty.Toasty;
import ir.oxima.githubtrending.other.utilities.AndroidUtilities;
import ir.oxima.githubtrending.other.utilities.Theme;
import ir.oxima.githubtrending.other.utilities.ViewAnimUtils;

/**
 * Created by hoseinraeisi on 5/16/18.
 */

public class MaterialEditText extends LinearLayout {


    private Context context;
    private TextInputLayout text_input_layout;
    private EditText editText;
    private TextView txt_message;
    private TextView txt_error;
    private int messageColor;
    private String mMessage;
    private String text;
    private String hint;
    private int inputType;
    private OnTextChangeListener onTextChangeListener;
    private int maxLines;
    private boolean singleLine;

    public interface OnTextChangeListener {
        void beforeTextChanged(CharSequence s, int start, int count, int after);

        void onTextChanged(CharSequence s, int start, int before, int count);

        void afterTextChanged(Editable s);
    }

    public MaterialEditText(Context context) {
        super(context);
        build(context, null);
    }

    public MaterialEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        build(context, attrs);
    }


    public MaterialEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        build(context, attrs);
    }

    private void build(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.material_edit_text, this);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(layoutParams);
        this.context = context;
        initViews();
        initAttributes(context, attrs);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                if (onTextChangeListener != null) {
                    onTextChangeListener.beforeTextChanged(s, start, count, after);
                }
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                setError(null, false,false);
                if (onTextChangeListener != null) {
                    onTextChangeListener.onTextChanged(s, start, before, count);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (onTextChangeListener != null) {
                    onTextChangeListener.afterTextChanged(s);
                }
            }
        });
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray attr = getTypedArray(context, attributeSet, R.styleable.MaterialEditText);
        if (attr == null) {
            return;
        }
        try {
            inputType = attr.getInt(R.styleable.MaterialEditText_android_inputType, EditorInfo.TYPE_NULL);
            text = attr.getString(R.styleable.MaterialEditText_medt_text);
            maxLines = attr.getInt(R.styleable.MaterialEditText_medt_maxlines, Integer.MAX_VALUE);
            hint = attr.getString(R.styleable.MaterialEditText_medt_hint);
            singleLine = attr.getBoolean(R.styleable.MaterialEditText_medt_singleline, false);
            mMessage = attr.getString(R.styleable.MaterialEditText_medt_message);
            messageColor = attr.getColor(R.styleable.MaterialEditText_medt_message_color, Theme.getColor(context, R.color.grey_light));

            if (inputType != EditorInfo.TYPE_NULL) {
               setInputType(inputType);
            }
            setText(text);
            setHint(hint);
            setMaxLines(maxLines);
            setSingleLine(singleLine);
            setMessage(mMessage, messageColor, false);
            setError(null, false,false);
        } finally {
            attr.recycle();
        }
    }


    protected TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

    private void initViews() {
        editText = findViewById(R.id.edt);
        txt_message = findViewById(R.id.txt_message);
        txt_error = findViewById(R.id.txt_error);
        text_input_layout = findViewById(R.id.text_input_layout);
        setError(null, false,false);
        setMessage(null, false);
    }

    public void setOnTextChangeListener(OnTextChangeListener onTextChangeListener) {
        this.onTextChangeListener = onTextChangeListener;
    }

    public void setText(CharSequence text) {
        editText.setText(text);
    }

    public void setHint(CharSequence hint) {
        text_input_layout.setHint(hint);
    }

    public void setError(CharSequence error, boolean isVibrator,boolean showToasty) {

        txt_error.setTextColor(Theme.getColor(context, R.color.material_red500));
        if (error == null) {
            txt_error.setVisibility(INVISIBLE);
            return;
        }
        ViewAnimUtils.visibleView(getContext(), txt_error, R.anim.fade_in);
        txt_error.setText(error);
        if (isVibrator) {
            Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            if (v != null) {
                v.vibrate(200);
                AndroidUtilities.shakeView(this, 5, 0);
            }
        }

        if(showToasty){
            Toasty.error(getContext(),error, Toast.LENGTH_SHORT).show();
        }
    }

    public void setMessage(CharSequence message, boolean isVibrator) {

        txt_message.setTextColor(Theme.getColor(context, R.color.grey_light));
        if (message == null) {
            txt_message.setVisibility(GONE);
            return;
        }

        ViewAnimUtils.visibleView(getContext(), txt_message, R.anim.fade_in);
        txt_message.setText(message);
        if (isVibrator) {
            Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            if (v != null) {
                v.vibrate(200);
                AndroidUtilities.shakeView(this, 5, 0);
            }
        }
    }

    public void setMessage(CharSequence message, int color, boolean isVibrator) {
        txt_message.setTextColor(color);
        if (message == null) {
            txt_message.setVisibility(GONE);
            return;
        }
        ViewAnimUtils.visibleView(getContext(), txt_message, R.anim.fade_in);
        txt_message.setText(message);
        if (isVibrator) {
            Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            if (v != null) {
                v.vibrate(200);
                AndroidUtilities.shakeView(this, 5, 0);
            }
        }
    }

    public void setInputType(int type) {
        editText.setInputType(type);
        invalidate();
    }


    public void setMaxLines(int maxLines) {
        editText.setMaxLines(maxLines);
    }

    public void setSingleLine(boolean singleLine) {
        editText.setSingleLine(singleLine);
    }

    public int length() {
        return editText.length();
    }

    public Editable getText() {
        return editText.getText();
    }

    public EditText getEditText(){
        return editText;
    }
}
