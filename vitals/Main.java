package vitals;

public class Main {
    
    static String getStatus(String parameter, float value, float min, float max, String lowMessage, String highMessage) {
        if (value < min) {
            return parameter + lowMessage;
        } else if (value > max) {
            return parameter + highMessage;
        }
        return parameter + " is within range.";
    }

    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        boolean isBatteryOk = true;
        
        String tempStatus = getStatus("Temperature", temperature, 0, 45, " is too low!", " is too high!");
        String socStatus = getStatus("State of Charge", soc, 20, 80, " is too low!", " is too high!");
        String chargeRateStatus = getStatus("Charge Rate", chargeRate, 0, 0.8f, "", " is too high!");
        
        String[] statusMessages = {tempStatus, socStatus, chargeRateStatus};
        
        for (String status : statusMessages) {
            if (!status.contains("within range")) {
                System.out.println(status);
                isBatteryOk = false;
            }
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
