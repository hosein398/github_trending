package ir.oxima.githubtrending.other.components.bottomnavigationbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import ir.oxima.githubtrending.R;
import static android.view.View.GONE;

import static ir.oxima.githubtrending.other.components.bottomnavigationbar.TabAnimator.animateTranslationY;

class Tab {
    private final BottomBarItem item;
    private final View root;
    private final TextView title;
    private final Context context;

    private final int activeTopMargin;
    private final int inactiveTopMargin;
    @ColorInt
    private final int activeColor;
    @ColorInt
    private final int inactiveColor;
    private final Drawable iconDrawable;

    Tab(@NonNull BottomBarItem item, @NonNull View root, @ColorInt int activeColor, @ColorInt int inactiveColor) {
        this.item = item;
        this.root = root;
        context = root.getContext();
        title =  root.findViewById(R.id.tab_title);
        ImageView icon = root.findViewById(R.id.tab_icon);

        activeTopMargin = getSizeInPx(R.dimen.bottom_bar_icon_top_margin_active);
        inactiveTopMargin = getSizeInPx(R.dimen.bottom_bar_icon_top_margin_inactive);
        this.activeColor = activeColor;
        this.inactiveColor = inactiveColor;
        iconDrawable = item.getIconDrawable(context);

        setupIcon(icon);
        setupTitle();
    }



    private void setupIcon(@NonNull ImageView icon) {
        DrawableCompat.setTint(iconDrawable, inactiveColor);
        icon.setImageDrawable(iconDrawable);
    }

    private int getSizeInPx(@DimenRes int res) {
        return context.getResources().getDimensionPixelSize(res);
    }

    void select(boolean animate) {
        title.setTextColor(activeColor);
        DrawableCompat.setTint(iconDrawable, activeColor);

        if (animate) {
            animateTranslationY(root, activeTopMargin);
        } else {
            root.setTranslationY(activeTopMargin);
        }
    }

    void deselect(boolean animate) {
        title.setTextColor(inactiveColor);
        DrawableCompat.setTint(iconDrawable, inactiveColor);

        if (animate) {
            animateTranslationY(root, inactiveTopMargin);
        } else {
            root.setTranslationY(inactiveTopMargin);
        }
    }

    private void setupTitle() {
        if (item.getTitle() == 0) {
            title.setVisibility(GONE);
        } else {
            title.setText(item.getTitle());
        }
        title.setTextColor(inactiveColor);
    }
}
