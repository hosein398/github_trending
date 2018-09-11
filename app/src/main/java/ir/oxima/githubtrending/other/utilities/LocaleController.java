package ir.oxima.githubtrending.other.utilities;

import android.content.Context;

/**
 * Created by hoseinraeisi on 1/10/18.
 */

public class LocaleController {

    public static boolean isRTL = false;

    public static String getText(Context context, int id){
        if(context == null){
            return "";
        }
        try{
            return (String) context.getResources().getText(id);

        }catch (NullPointerException e){
            e.printStackTrace();
            return "";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }
}
