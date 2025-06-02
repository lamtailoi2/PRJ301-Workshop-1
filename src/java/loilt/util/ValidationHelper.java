package loilt.util;

public class ValidationHelper {

    public final static String VALID_MOBILE_NAME = "^.{3,20}$";
    public final static String VALID_DESCRIPTION = "^.{5,250}$";
    public final static String VALID_MOBILE_ID = "^.{3,20}";

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isPositiveFloat(String value) {
        if (value == null) {
            return false;
        }

        try {
            float f = Float.parseFloat(value);
            return f > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositiveInt(String value) {
        if (value == null) {
            return false;
        }
        try {
            int n = Integer.parseInt(value);
            return n > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean matchWithPattern(String value, String pattern) {

        if (value.matches(pattern)) {
            return true;
        }
        return false;
    }
}
