//package com.example.informationmangement;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectWriter;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//class InformationManagementApplicationTests {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void uploadFile() throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
//        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
//        String requestJson = ow.writeValueAsString(MotherObject.getAnyTransactionRequestDTO());
//
//
//        mockMvc.perform(post("/api/v1/files/upload")
//                        .contentType(MediaType.MULTIPART_FORM_DATA)
//                        .content(requestJson)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andDo(print())
//                .andExpect(jsonPath("$.amount").value("100"))
//                .andExpect(
//                        status().isCreated());
//    }
//
//}
