package ir.oxima.githubtrending.other.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

import ir.oxima.githubtrending.R;
import ir.oxima.githubtrending.other.utilities.AndroidUtilities;
import ir.oxima.githubtrending.other.utilities.ValidationTools;


/**
 * Created by hoseinraeisi on 9/11/17.
 */

public class ButtonCell extends AppCompatButton {

    private String fontName;

    public ButtonCell(Context context) {
        super(context);
        init(context,null);
    }

    public ButtonCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public ButtonCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initAttributes(context,attrs);
        if(!ValidationTools.isEmptyOrNull(fontName)){
            this.setTypeface(AndroidUtilities.getTypeface("fonts/" + fontName + ".ttf"));
        }
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        TypedArray attr = getTypedArray(context, attributeSet, R.styleable.ViewCell);
        if (attr == null) {
            return;
        }
        try {
            fontName = attr.getString(R.styleable.ViewCell_vc_font);
            if(ValidationTools.isEmptyOrNull(fontName)){
                fontName = "irsans_n";
            }
        } finally {
            attr.recycle();
        }
    }

    public void setFont(String fontName) {
        if(ValidationTools.isEmptyOrNull(fontName)){
            this.fontName = "irsans_n";
            return;
        }
        this.fontName = fontName;
    }

    protected int getColor(int id) {
        return getResources().getColor(id);
    }

    protected TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }
}
