package ir.oxima.githubtrending.other.components;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import ir.oxima.githubtrending.R;
import ir.oxima.githubtrending.other.utilities.ViewAnimUtils;


/**
 * Created by hoseinraeisi on 1/7/18.
 */

public class SimpleToolbar extends Toolbar implements View.OnClickListener {

    private Context context;
    private Toolbar tool_bar;
    private ImageView img_avatar;
    private ImageView icon_back;
    private ImageView icon3;
    private ImageView icon2;
    private ImageView icon1;
    private ViewGroup search_view;
    private EditText edt_search;
    private ImageView img_back_search;
    private ImageView img_clear;
    private TextView txt_title;
    private TextView txt_sub_title;
    private LinearLayout container_toolbar;
    private OnClickIconListener mOnClickIconListener;
    private SearchViewListener searchViewListener;
    private OnQueryTextListener onQueryTextListener;


    public interface OnClickIconListener {
        void onClickIcon(View view);
    }

    public interface OnQueryTextListener {
        void onQueryTextChange(String newText);
    }

    public interface SearchViewListener {
        void onSearchViewShown();
        void onSearchViewClosed();
        void onSearchViewBackPressed();
    }

    public SimpleToolbar(Context context) {
        super(context);
        build(context, null);
    }

    public SimpleToolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        build(context, attrs);
    }

    public SimpleToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        build(context, attrs);
    }

    private void build(Context context, @Nullable AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.toolbar_simple, this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        this.setLayoutParams(layoutParams);
        this.context = context;
        initViews();
    }

    private void initViews() {

        tool_bar = findViewById(R.id.tool_bar);
        container_toolbar = findViewById(R.id.container_toolbar);
        img_avatar = findViewById(R.id.tool_bar_img_avatar);
        search_view = findViewById(R.id.search_view);
        edt_search = findViewById(R.id.edt_search);
        img_back_search = findViewById(R.id.img_back_search);
        img_clear = findViewById(R.id.img_clear);
        icon_back = findViewById(R.id.icon_back);
        icon1 = findViewById(R.id.icon1);
        icon2 = findViewById(R.id.icon2);
        icon3 = findViewById(R.id.icon3);
        txt_title = findViewById(R.id.txt_title);
        txt_sub_title = findViewById(R.id.txt_sub_title);

        setDefault();


        img_back_search.setOnClickListener(this);
        img_clear.setOnClickListener(this);
        icon_back.setOnClickListener(this);
        icon1.setOnClickListener(this);
        icon2.setOnClickListener(this);
        icon3.setOnClickListener(this);

        edt_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (onQueryTextListener != null){
                    onQueryTextListener.onQueryTextChange(s.toString());
                    return;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void setDefault() {
        setTitle(null);
        setIcon1(null);
        setSubTitle(null);
        setIcon2(null);
        setIcon3(null);
        setAvatar(null);
        search_view.setVisibility(GONE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back_search:
                if (searchViewListener != null){
                    searchViewListener.onSearchViewBackPressed();
                }
                closeSearchView();
                return;

            case R.id.img_clear:
                edt_search.setText("");
                return;
        }

        if (mOnClickIconListener != null) {
            mOnClickIconListener.onClickIcon(view);
            return;
        }
    }

    public void setOnClickIconListener(OnClickIconListener onClickIconListener) {
        this.mOnClickIconListener = onClickIconListener;
    }

    public void setSearchViewListener(SearchViewListener searchViewListener) {
        this.searchViewListener = searchViewListener;
    }

    public void setOnQueryTextListener(OnQueryTextListener onQueryTextListener) {
        this.onQueryTextListener = onQueryTextListener;
    }

    public void setTitle(CharSequence title) {
        if (title == null) {
            txt_title.setVisibility(GONE);
            return;
        }
        txt_title.setVisibility(VISIBLE);
        txt_title.setText(title);
    }

    public void setSubTitle(CharSequence subTitle) {
        if (subTitle == null) {
            txt_sub_title.setVisibility(GONE);
            return;
        }
        txt_sub_title.setVisibility(VISIBLE);
        txt_sub_title.setText(subTitle);
    }


    public void addCustomView(View view, ViewGroup.LayoutParams layoutParams) {
        container_toolbar.addView(view, layoutParams);
    }

    public void setBackgroundColorToolbar(int color) {
        tool_bar.setBackgroundColor(color);
    }

    public void setTitleColor(int color) {
        txt_title.setTextColor(color);
    }

    public void setSubTitleColor(int color) {
        txt_sub_title.setTextColor(color);
    }

    public void setIconBack(Integer icon) {
        if (icon == null || icon == 0) {
            icon_back.setVisibility(GONE);
            return;
        }
        icon_back.setVisibility(VISIBLE);
        icon_back.setImageResource(icon);
    }

    public void setIcon1(Integer icon) {
        if (icon == null || icon == 0) {
            icon1.setVisibility(GONE);
            return;
        }
        icon1.setVisibility(VISIBLE);
        icon1.setImageResource(icon);
    }

    public void setIcon2(Integer icon) {
        if (icon == null || icon == 0) {
            icon2.setVisibility(GONE);
            return;
        }
        icon2.setVisibility(VISIBLE);
        icon2.setImageResource(icon);

    }

    public void setIcon3(Integer icon) {
        if (icon == null || icon == 0) {
            icon3.setVisibility(GONE);
            return;
        }
        icon3.setVisibility(VISIBLE);
        icon3.setImageResource(icon);
    }


    public void setAvatar(Integer avatar) {
        if (avatar == null || avatar == 0) {
            img_avatar.setVisibility(GONE);
            return;
        }
        img_avatar.setVisibility(VISIBLE);
        img_avatar.setImageResource(avatar);
    }

    public boolean isOpenSearchView(){
        return search_view.getVisibility() == VISIBLE;
    }

    public void openSearchView(){
        ViewAnimUtils.visibleView(getContext(),search_view,R.anim.fade_in);
        if (searchViewListener != null){
            searchViewListener.onSearchViewShown();
            return;
        }
    }

    public void closeSearchView(){
        ViewAnimUtils.goneView(getContext(),search_view,R.anim.fade_out);
        if (searchViewListener != null){
            searchViewListener.onSearchViewClosed();
            return;
        }
    }
}
