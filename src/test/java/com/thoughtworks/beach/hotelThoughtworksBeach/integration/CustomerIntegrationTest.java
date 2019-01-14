package com.thoughtworks.beach.hotelThoughtworksBeach.integration;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.CustomerRepository;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.model.CustomerEntity;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("integration")
public class CustomerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Ignore
    public void returnsCustomerWhenGetAllCustomersIsTriggered() throws Exception {

        String expectedJson = "[{\"name\":\"vicky\",\"lastName\":\"la reina\"}]";

        mockMvc.perform(get("/customers/all"))
                .andDo(print())
                .andExpect(content().json(expectedJson));
    }

    @Test
    public void returnsCustomerWhenCreatingCustomer() throws Exception {
        String customerInformation  = "{\"name\":\"vicky\",\"lastName\":\"la reina\"}";

        String expectedJson = "{\"name\":\"vicky\",\"lastName\":\"la reina\"}";

        mockMvc.perform(post("/customers/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(customerInformation))
                .andExpect(content().json(expectedJson));
    }

}
