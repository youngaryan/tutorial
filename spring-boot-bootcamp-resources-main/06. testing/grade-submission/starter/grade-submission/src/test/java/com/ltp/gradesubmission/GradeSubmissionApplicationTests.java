package com.ltp.gradesubmission;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GradeSubmissionApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
		assertNotNull(mockMvc);
	}

	@Test
	public void ShowGetTheGradeForm() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/?id=1");

		mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful())
		.andExpect(view().name("form"))
		.andExpect(model().attributeExists("grade"));
	}

	@Test
	public void successfullSubmissionTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/handleSubmit")
		.param("name", "Jack")
		.param("subject", "Math")
		.param("score", "A+");

		mockMvc.perform(requestBuilder).andExpect(status().is3xxRedirection())
		.andExpect(redirectedUrl("/grades"));
	}

	@Test
	public void unsuccessfullSubmitTest() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/handleSubmit")
		.param("name", "Julie")
		.param("subject","Law")
		.param("score", "A*");

		mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful())
		.andExpect(view().name("form"));
	}

	@Test
	public void gradeFormTest() throws Exception{
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/grades");

		mockMvc.perform(requestBuilder).andExpect(status().is2xxSuccessful())
		.andExpect(view().name("grades"))
		.andExpect(model().attributeExists("grades"));
	}
}
