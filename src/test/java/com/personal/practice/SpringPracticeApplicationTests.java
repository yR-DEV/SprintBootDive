package com.personal.practice;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

// Both of these annotations are used to
// inject an instance of MockMvc with @Autowired
@SpringBootTest
@AutoConfigureMockMvc
class SpringPracticeApplicationTests {
	
	// MockMvc comes from Spring Test and lets you, 
	// through a set of convenient builder classes, 
	// send HTTP requests into the DispatcherServlet
	@Autowired
	private MockMvc mvc;

	// Annotation indicates that the getHome() method is a test case
	@Test
	public void getHome() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/")
					.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect((ResultMatcher) content().string(equalTo("Grettings from base url!")));
	}

}
