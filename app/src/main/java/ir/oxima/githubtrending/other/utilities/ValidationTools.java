package ir.oxima.githubtrending.other.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hosein on 2/4/2017.
 */

public class ValidationTools {

    public static boolean isEmptyOrNull(String input){
        if(input == null  || input.isEmpty() || input.trim().equals("") || input.trim().toLowerCase().equals("null")){
           return true;
        }
        return false;
    }
    public static boolean isEmptyOrNull(List list){
        if(list == null || list.size() == 0){
            return true;
        }
        return false;
    }
    public static boolean isEmptyOrNull(ArrayList arrayList){
        if(arrayList == null || arrayList.size() == 0){
            return true;
        }
        return false;
    }
    public static boolean isEmailValid(String email) {
        if (ValidationTools.isEmptyOrNull(email)) {
            return false;
        }
        boolean isValid = true;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (!matcher.matches()) {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isMobileValid(String mobile, String countryCode) {
        if (ValidationTools.isEmptyOrNull(mobile)) {
            return false;
        }
        if (countryCode.trim().equals("98")) {

            String x = String.valueOf(mobile.charAt(0));
            String x1 = String.valueOf(mobile.charAt(1));
            String x2 = String.valueOf(mobile.charAt(2));
            String x3 = String.valueOf(mobile.charAt(3));

            if (x.trim().equals("" + 0)
                    && x1.trim().equals("" + 0)
                    && x2.trim().equals("" + 9)
                    && x3.trim().equals("" + 8)
                    && mobile.length() == 14){
                return  true;
            }

            if (x.trim().equals("" + 0)
                    && x1.trim().equals("" + 9)
                    && x2.trim().equals("" + 8)
                    && mobile.length() == 13){
                return  true;
            }

            if (x.trim().equals("" + 9)
                    && x1.trim().equals("" + 8)
                    && mobile.length() == 12){
                return  true;
            }

            if (x.trim().equals("" + "+")
                    && x1.trim().equals("" + 9)
                    && x2.trim().equals("" + 8)
                    && mobile.length() == 13){
                return  true;
            }

            if ((x.trim().equals("" + 9) && mobile.length() == 10) || (x.trim().equals("" + 0) && mobile.length() == 11)) {
                return true;
            }

            return false;
        } else {
            if (mobile.length() > 15 || mobile.length() < 5) {
                return false;
            }
            return true;
        }
    }

    public static boolean isEnglish(String value) {
        Pattern ps = Pattern.compile("^[a-zA-Z ]+$");
        Matcher ms = ps.matcher(value);
        return ms.matches();
    }

}
