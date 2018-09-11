package ir.oxima.githubtrending.other.components.toasty;

import android.content.Context;
import android.os.Build;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import ir.oxima.githubtrending.R;

/**
 * Created by hoseinraeisi on 2/2/18.
 */

public class Toasty {


    @CheckResult
    public static Toast normal(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return custom(context, message, null, R.drawable.bg_dark_grey_rounded_5sdp, duration);

    }

    @CheckResult
    public static Toast warning(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return custom(context, message, R.drawable.ic_error_outline_black_24dp, R.drawable.bg_orange_rounded_5sdp, duration);
    }


    @CheckResult
    public static Toast info(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return custom(context, message, R.drawable.ic_info_outline_black_24dp, R.drawable.bg_blue_rounded_5sdp, duration);

    }

    @CheckResult
    public static Toast success(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return custom(context, message, R.drawable.ic_check_black_24dp, R.drawable.bg_green_rounded_5sdp, duration);

    }


    @CheckResult
    public static Toast error(@NonNull Context context, @NonNull CharSequence message, int duration) {
        return custom(context, message, R.drawable.ic_close_black_24dp, R.drawable.bg_red_rounded_5sdp, duration);
    }


    @CheckResult
    public static Toast custom(@NonNull Context context, @NonNull CharSequence message, Integer icon,
                               int backgroundColor, int duration) {


        final Toast currentToast = Toast.makeText(context, null, duration);
        final View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.toast_layout, null);
        final ImageView toastIcon = toastLayout.findViewById(R.id.toast_icon);
        final TextView toastTextView = toastLayout.findViewById(R.id.toast_text);
        final ViewGroup toast_root = toastLayout.findViewById(R.id.toast_root);



       /* if (icon == null){
            toastIcon.setVisibility(View.GONE);
        }else{
            toastIcon.setVisibility(View.VISIBLE);
            toastIcon.setImageResource(icon);
        }*/

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            toast_root.setBackground(ContextCompat.getDrawable(context,backgroundColor));
        }else{
            toast_root.setBackgroundDrawable(ContextCompat.getDrawable(context,backgroundColor));
        }
        toastTextView.setText(message);
        currentToast.setView(toastLayout);
        return currentToast;
    }


}
