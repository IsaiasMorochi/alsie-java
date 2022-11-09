package bo.alsie.mock;

import java.util.HashMap;
import java.util.Map;

public class Mock {

    public static Map<String, String> responseMessage(String message) {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Hello World "+message+"!");
        return response;
    }

}
