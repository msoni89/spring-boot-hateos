package com.sample.pagination.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PinCodeRestControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testShouldReturnAllPincodesFromService() throws Exception {
		this.mockMvc.perform(get("/api/pin-code-list")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.page.totalElements").value(39732))
		.andExpect(jsonPath("$.page.size").value(20))
		.andExpect(jsonPath("$.page.totalPages").value(1987));
	}
	
	@Test
	public void testShouldReturnAllPincodeInSortedOrderAscFromService() throws Exception {
		this.mockMvc.perform(get("/api/pin-code-list?page=5&size=5&sort=id,asc")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.page.totalElements").value(39732))
		.andExpect(jsonPath("$.page.size").value(5))
		.andExpect(jsonPath("$.page.totalPages").value(7947))
		.andExpect(jsonPath("$._embedded.pinCodes[0].pinCode").value(110002))
		.andExpect(jsonPath("$._embedded.pinCodes[0].postOfficeName").value("Indraprastha"));
	}
	
	@Test
	public void testShouldReturnAllPincodeInSortedOrderDescFromService() throws Exception {
		this.mockMvc.perform(get("/api/pin-code-list?page=5&size=5&sort=id,desc")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.page.totalElements").value(39732))
		.andExpect(jsonPath("$.page.size").value(5))
		.andExpect(jsonPath("$.page.totalPages").value(7947))
		.andExpect(jsonPath("$._embedded.pinCodes[0].pinCode").value(854365))
		.andExpect(jsonPath("$._embedded.pinCodes[0].postOfficeName").value("Kajha"));
	}
	
	
	@Test
	public void testShouldReturnPincodeByPinNumberFromService() throws Exception {
		this.mockMvc.perform(get("/api/pin-codes/id/39707")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.pinCode").value(854365))
		.andExpect(jsonPath("$.id").value(39707))
		.andExpect(jsonPath("$.district").value("Purnia"))
		.andExpect(jsonPath("$.city").value("Purnia"))
		.andExpect(jsonPath("$.postOfficeName").value("Kajha"))
		.andExpect(jsonPath("$.state").value("Bihar"));
	}
	
	@Test
	public void testShouldReturnNotFoundResponseFromService() throws Exception {
		this.mockMvc.perform(get("/api/pin-codes/id/-1")).andDo(print()).andExpect(status().isNotFound());
	}
}

