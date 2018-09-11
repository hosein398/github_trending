package ir.oxima.githubtrending.other.utilities;

import android.util.Log;

import ir.oxima.githubtrending.BuildConfig;


public class FileLog {

    private static final String TAG = "Github";

    public static void e(final String message, final Throwable exception) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.e(TAG, message, exception);
    }

    public static void e(final String message) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.e(TAG, message);
    }

    public static void e(final Throwable e) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        e.printStackTrace();
    }

    public static void d(final String message) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.d(TAG, message);
    }

    public static void w(final String message) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.w(TAG, message);
    }

    public static void i(final String message) {
        if (!BuildConfig.DEBUG) {
            return;
        }
        Log.i(TAG, message);
    }
}
