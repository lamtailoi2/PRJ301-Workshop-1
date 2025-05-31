package loilt.util;

public class ValidationHelper {

    public static boolean isEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    public static boolean isPositiveFloat(String value) {
        try {
            float f = Float.parseFloat(value);
            return f > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    public static boolean isPositiveInt(String value) {
        try {
            int n = Integer.parseInt(value);
            return n > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
