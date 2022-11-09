package bo.alsie.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UnitTest {

    @Autowired
    ApiService service;

    @Test
    void hello_from_service() {
        // Given
        var name = "Isaias";

        var response = service.createMessage(name);

        assertEquals("OK", response.get("status"));
        assertEquals("Hello World " + name + "!", response.get("message"));
    }

}
