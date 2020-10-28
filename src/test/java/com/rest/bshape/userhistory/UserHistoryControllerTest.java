package com.rest.bshape.userhistory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.bshape.userhistory.domain.UserHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestPropertySource(locations = "classpath:application-local.properties")
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class UserHistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldTestFindAllGetMethod() throws Exception {
        mockMvc.perform(get("/api/user-history"))
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    /*@Test
    void shouldFindBodyTypeById() throws Exception {
        userHistoryRepository.save(new UserHistory(   *//*problem z utwożeniem obiektu i z polem daty *//*  ));
        mockMvc.perform(get("/api/user-history/1"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.userHistory").value(2020-12-12));

    }*/



}
