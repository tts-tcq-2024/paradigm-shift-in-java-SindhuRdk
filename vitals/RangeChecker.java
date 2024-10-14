package vitals;

public class RangeChecker {

    public static boolean isWithinRange(float value, float min, float max, String message) {
        if (value < min || value > max) {
            System.out.println(LanguageSupport.getMessage(message));
            return false;
        }
        return true;
    }
}
