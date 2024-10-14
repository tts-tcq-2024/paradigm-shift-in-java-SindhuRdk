package vitals;

public class WarningChecker {

    public static void checkWarning(float value, float min, float max, String warningMessage) {
        float warningLowerLimit = min + 0.05f * (max - min);
        float warningUpperLimit = max - 0.05f * (max - min);
        if (value < warningLowerLimit) {
            System.out.println(LanguageSupport.getMessage("Warning: " + warningMessage + " approaching discharge"));
        } else if (value > warningUpperLimit) {
            System.out.println(LanguageSupport.getMessage("Warning: " + warningMessage + " approaching charge-peak"));
        }
    }

    public static void checkTemperatureWarning(float temperature) {
        checkWarning(temperature, 0, 45, "Temperature");
    }

    public static void checkSocWarning(float soc) {
        checkWarning(soc, 20, 80, "State of Charge");
    }

    public static void checkChargeRateWarning(float chargeRate) {
        checkWarning(chargeRate, 0, 0.8f, "Charge Rate");
    }
}
