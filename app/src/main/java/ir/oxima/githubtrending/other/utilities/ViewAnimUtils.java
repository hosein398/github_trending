package ir.oxima.githubtrending.other.utilities;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by hosein on 5/3/2017.
 */

public class ViewAnimUtils {

    public static AnimatorSet createBlobject(final View view, int duration) {

        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(view, "ScaleX", 0f, 1.2f, 1f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(view, "ScaleY", 0f, 1.2f, 1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(duration);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator);

        return animatorSet;
    }

    public static Animator createCircularReveal(View view, int centerX, int centerY, float startRadius, float endRadius) {
        Animator anim = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius);
        }
        return anim;
    }

    public static Animation rotate(float fromDegrees, float toDefrees, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        RotateAnimation rotateAnimation = new RotateAnimation(fromDegrees, toDefrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animationSet.addAnimation(rotateAnimation);

        return animationSet;
    }

    public static Animation zoom(float fromScaleX, float toScaleX, float fromScaleY, float toScaleY, long duration) {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        ScaleAnimation scaleAnimation = new ScaleAnimation(fromScaleX, toScaleX, fromScaleY, toScaleY, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        animationSet.addAnimation(scaleAnimation);

        return animationSet;
    }

    public static Animation fade(float fromAlpha, float toAlpha, long duration) {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        AlphaAnimation alphaAnimation = new AlphaAnimation(fromAlpha, toAlpha);
        animationSet.addAnimation(alphaAnimation);

        return animationSet;

    }

    public static Animation slideOutRight(View view, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, ((View) view.getParent()).getWidth(), 0, 0);
        animationSet.addAnimation(translateAnimation);

        return animationSet;

    }

    public static Animation slideOutLeft(View view, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, -((View) view.getParent()).getWidth(), 0, 0);
        animationSet.addAnimation(translateAnimation);

        return animationSet;

    }

    public static Animation slideOutBottom(View view, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, ((View) view.getParent()).getHeight());
        animationSet.addAnimation(translateAnimation);

        return animationSet;

    }

    public static Animation slideOutTop(View view, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, -((View) view.getParent()).getHeight());
        animationSet.addAnimation(translateAnimation);

        return animationSet;
    }

    public static Animation slideInRight(View view, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(((View) view.getParent()).getWidth(), 0, 0, 0);
        animationSet.addAnimation(translateAnimation);

        return animationSet;

    }

    public static Animation slideInLeft(View view, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(-((View) view.getParent()).getWidth(), 0, 0, 0);
        animationSet.addAnimation(translateAnimation);

        return animationSet;
    }

    public static Animation slideInBottom(View view, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, ((View) view.getParent()).getHeight(), 0);
        animationSet.addAnimation(translateAnimation);

        return animationSet;
    }

    public static Animation slideInTop(View view, long duration) {

        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setDuration(duration);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, -((View) view.getParent()).getHeight(), 0);
        animationSet.addAnimation(translateAnimation);

        return animationSet;
    }

    public static void startAnimation(Context context, View view, int animId) {
        if (context == null || view == null) {
            return;
        }
        Animation anim = AnimationUtils.loadAnimation(context, animId);
        view.startAnimation(anim);
    }

    public static void visibleView(Context context, View view, int animId) {
        if (context == null || view == null) {
            return;
        }

        if (view.getVisibility() == View.VISIBLE) {
            return;
        }

        startAnimation(context, view, animId);
        view.setVisibility(View.VISIBLE);
    }

    public static void goneView(Context context, View view, int animId) {
        if (context == null || view == null) {
            return;
        }

        if (view.getVisibility() == View.GONE) {
            return;
        }

        startAnimation(context, view, animId);
        view.setVisibility(View.GONE);
    }

    public static void visibleView(Context context, View view, Animation animation) {
        if (context == null || view == null) {
            return;
        }

        if (view.getVisibility() == View.VISIBLE) {
            return;
        }

        view.startAnimation(animation);
        view.setVisibility(View.VISIBLE);
    }

    public static void goneView(Context context, View view, Animation animation) {
        if (context == null || view == null) {
            return;
        }

        if (view.getVisibility() == View.GONE) {
            return;
        }

        view.startAnimation(animation);
        view.setVisibility(View.GONE);
    }
}
