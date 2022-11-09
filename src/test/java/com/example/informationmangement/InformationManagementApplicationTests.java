package com.example.informationmangement;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class InformationManagementApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllTransactionByUserId_whenIdNotExist_thenThrowsException() throws Exception {
        mockMvc.perform(get("/api/v1/information/getAll"))
                .andDo(print())
                .andExpect(jsonPath("$").isEmpty())
                .andExpect(
                        status().isOk());
    }

}
