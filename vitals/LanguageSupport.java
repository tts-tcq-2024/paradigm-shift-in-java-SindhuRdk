package vitals;

import java.util.HashMap;
import java.util.Map;

public class LanguageSupport {
    private static String currentLanguage = "EN"; // default language
    private static Map<String, String> messages = new HashMap<>();

    static {
        // English messages
        messages.put("Temperature out of range!", "Temperature out of range!");
        messages.put("State of Charge out of range!", "State of Charge out of range!");
        messages.put("Charge Rate out of range!", "Charge Rate out of range!");
        messages.put("Warning: Temperature approaching discharge", "Warning: Temperature approaching discharge");
        messages.put("Warning: Temperature approaching charge-peak", "Warning: Temperature approaching charge-peak");
        messages.put("Warning: State of Charge approaching discharge", "Warning: State of Charge approaching discharge");
        messages.put("Warning: State of Charge approaching charge-peak", "Warning: State of Charge approaching charge-peak");
        messages.put("Warning: Charge Rate approaching discharge", "Warning: Charge Rate approaching discharge");
        messages.put("Warning: Charge Rate approaching charge-peak", "Warning: Charge Rate approaching charge-peak");

        // German messages
        messages.put("de-Temperature out of range!", "Temperatur außerhalb des Bereichs!");
        messages.put("de-State of Charge out of range!", "Ladezustand außerhalb des Bereichs!");
        messages.put("de-Charge Rate out of range!", "Laderate außerhalb des Bereichs!");
        messages.put("de-Warning: Temperature approaching discharge", "Warnung: Temperatur nähert sich der Entladung");
        messages.put("de-Warning: Temperature approaching charge-peak", "Warnung: Temperatur nähert sich dem Ladehöchststand");
        messages.put("de-Warning: State of Charge approaching discharge", "Warnung: Ladezustand nähert sich der Entladung");
        messages.put("de-Warning: State of Charge approaching charge-peak", "Warnung: Ladezustand nähert sich dem Ladehöchststand");
        messages.put("de-Warning: Charge Rate approaching discharge", "Warnung: Laderate nähert sich der Entladung");
        messages.put("de-Warning: Charge Rate approaching charge-peak", "Warnung: Laderate nähert sich dem Ladehöchststand");
    }

    public static void setLanguage(String language) {
        currentLanguage = language;
    }

    public static String getMessage(String message) {
        if ("DE".equalsIgnoreCase(currentLanguage)) {
            return messages.getOrDefault("de-" + message, message);
        }
        return messages.getOrDefault(message, message);
    }
}
