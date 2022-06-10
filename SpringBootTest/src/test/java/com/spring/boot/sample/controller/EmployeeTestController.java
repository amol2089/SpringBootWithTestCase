package com.spring.boot.sample.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.spring.boot.sample.SpringBootApplicationTest;


public class EmployeeTestController extends SpringBootApplicationTest{

	
	

	@Test
	public void testEmployee() throws Exception {
		
		System.out.println(" ---Inside Test Employee---"); 
//		 String uri = "/employee";
//	      MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
//	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
//	      
//	      int status = mvcResult.getResponse().getStatus();
//	      assertEquals(200, status);
	      
	      
		mockMvc.perform(get("/employee")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("emp1")).andExpect(jsonPath("$.designation").value("manager"))
				.andExpect(jsonPath("$.empId").value("1")).andExpect(jsonPath("$.salary").value(3000));
		System.out.println(" ---Inside Endof Test Employee---"); 
	}
}
