package vitals;

public class Main {
    
    static String checkTemperature(float temperature) {
        if (temperature < 0) {
            return "Temperature is too low!";
        } else if (temperature > 45) {
            return "Temperature is too high!";
        }
        return "Temperature is within range.";
    }
    
    static String checkSOC(float soc) {
        if (soc < 20) {
            return "State of Charge is too low!";
        } else if (soc > 80) {
            return "State of Charge is too high!";
        }
        return "State of Charge is within range.";
    }
    
    static String checkChargeRate(float chargeRate) {
        if (chargeRate > 0.8) {
            return "Charge Rate is too high!";
        }
        return "Charge Rate is within range.";
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
