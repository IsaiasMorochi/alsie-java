package bo.alsie.controller;

import bo.alsie.service.ApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static bo.alsie.mock.Mock.responseMessage;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.mockito.Mockito.*;

@WebMvcTest(ApiController.class)
class IntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApiService apiService;

    @Test
    void hello_from_controller() throws Exception {
        // Given
        var name = "Isaias";
        when(apiService.createMessage(name)).thenReturn(responseMessage(name));

        // When
        mockMvc.perform(get("/api/v1/hello-world/" + name).contentType(MediaType.APPLICATION_JSON))

            // Then
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.status").value("OK"))
            .andExpect(jsonPath("$.message").value("Hello World " + name + "!"));
    }

}
