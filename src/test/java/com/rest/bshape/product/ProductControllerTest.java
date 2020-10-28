package com.rest.bshape.product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.bshape.product.domain.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestPropertySource(locations = "classpath:application-local.properties")
// gdzie znajduje sie moj localny properties do testow integracyjnych
@SpringBootTest // do testów integracyjnych must have adnostacja
@AutoConfigureMockMvc
// pozwala na wykonywanie testow przez controller, dobijamy sie do metod z controlera poprzez mvc, mozemy przejsc przez cale flow od controlera po repozytorium
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
// podnosi context springa przy kazdym tescie na nowo
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
// wyrzuca nam baze h2 i tworzy odnowa żeby uniknac bledu zwiazanego z id ktore juz sa zapisane w poprzednich testwach
class ProductControllerTest {

    private final Long id = 1L;
    private final String productName = "testProduct";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldTestFindAllGetMethod() throws Exception {
        mockMvc.perform(get("/api/product"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray());
    }

    @Test
    void shouldFindProductById() throws Exception {
        productRepository.save(Product.builder().name(productName).build());
        mockMvc.perform(get("/api/product/1"))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.name").value(productName));
    }

    @Test
    void shouldReturnNotFoundProductById() throws Exception {
        mockMvc.perform(get("/api/product/50"))
                .andExpect(status().is(404))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.timestamp").exists())
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.details").exists());
    }

    @Test
    void shouldSaveProduct() throws Exception {
        mockMvc.perform(post("/api/product")
                .content(objectMapper.writeValueAsBytes(Product.builder().name(productName).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id));
    }

    @Test
    void shouldSaveProductThrowError() throws Exception {
        mockMvc.perform(post("/api/product")
                .content(objectMapper.writeValueAsBytes(Product.builder().build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400));
    }

    @Test
    void shouldUpdateProduct() throws Exception {
    }

    @Test
    void shouldDelete() {
    }
}