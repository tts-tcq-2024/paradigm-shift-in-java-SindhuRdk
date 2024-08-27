package vitals;

public class Main {
    
    static boolean isValueWithinRange(float value, float min, float max) {
        return value >= min && value <= max;
    }
    
    static String getStatus(String parameter, boolean isWithinRange, String lowMessage, String highMessage) {
        if (!isWithinRange) {
            return parameter + (value < min ? lowMessage : highMessage);
        }
        return parameter + " is within range.";
    }

    static String checkTemperature(float temperature) {
        return getStatus("Temperature", isValueWithinRange(temperature, 0, 45), " is too low!", " is too high!");
    }
    
    static String checkSOC(float soc) {
        return getStatus("State of Charge", isValueWithinRange(soc, 20, 80), " is too low!", " is too high!");
    }
    
    static String checkChargeRate(float chargeRate) {
        return getStatus("Charge Rate", isValueWithinRange(chargeRate, 0, 0.8f), "", " is too high!");
    }
    
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        boolean isBatteryOk = true;
        
        String tempStatus = checkTemperature(temperature);
        String socStatus = checkSOC(soc);
        String chargeRateStatus = checkChargeRate(chargeRate);
        
        if (!tempStatus.equals("Temperature is within range.")) {
            System.out.println(tempStatus);
            isBatteryOk = false;
        }
        
        if (!socStatus.equals("State of Charge is within range.")) {
            System.out.println(socStatus);
            isBatteryOk = false;
        }
        
        if (!chargeRateStatus.equals("Charge Rate is within range.")) {
            System.out.println(chargeRateStatus);
            isBatteryOk = false;
        }
        
        return isBatteryOk;
    }
    
    public static void main(String[] args) {
        assert(batteryIsOk(25, 70, 0.7f) == true);
        assert(batteryIsOk(-1, 70, 0.7f) == false);
        assert(batteryIsOk(50, 70, 0.7f) == false);
        assert(batteryIsOk(25, 10, 0.7f) == false);
        assert(batteryIsOk(25, 85, 0.7f) == false);
        assert(batteryIsOk(25, 70, 0.9f) == false);
        System.out.println("All tests passed.");
    }
}
