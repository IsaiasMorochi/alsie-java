package bo.alsie.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ApiServiceImpl implements ApiService {

    @Override
    public Map<String, String> createMessage(String message) {
        HashMap<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Hello World "+message+"!");
        return response;
    }

}
