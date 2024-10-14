package vitals;

public class BatteryChecker {

    public static boolean checkTemperature(float temperature) {
        if (!RangeChecker.isWithinRange(temperature, 0, 45, "Temperature out of range!")) {
            return false;
        }
        WarningChecker.checkTemperatureWarning(temperature);
        return true;
    }

    public static boolean checkSoc(float soc) {
        if (!RangeChecker.isWithinRange(soc, 20, 80, "State of Charge out of range!")) {
            return false;
        }
        WarningChecker.checkSocWarning(soc);
        return true;
    }

    public static boolean checkChargeRate(float chargeRate) {
        if (!RangeChecker.isWithinRange(chargeRate, 0, 0.8f, "Charge Rate out of range!")) {
            return false;
        }
        WarningChecker.checkChargeRateWarning(chargeRate);
        return true;
    }

    public static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return checkTemperature(temperature) &&
               checkSoc(soc) &&
               checkChargeRate(chargeRate);
    }
}
