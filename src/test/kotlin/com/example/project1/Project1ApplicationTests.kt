package com.example.project1

import com.example.project1.service.CaseService
import com.example.project1.service.CaseServiceImpl
import com.github.demidko.aot.WordformMeaning.lookupForMeanings
import com.github.demidko.aot.WordformMeaning
import junit.framework.TestCase.assertEquals
import org.hamcrest.core.StringContains.containsString
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class Project1ApplicationTests {
	private val baseUrl = "http://localhost:8083/spell"
	private val jsonContentType = MediaType(MediaType.APPLICATION_JSON.type, MediaType.APPLICATION_JSON.subtype)
	//private lateinit var mockMvc: MockMvc

	@Autowired
	private lateinit var mockMvc: MockMvc

	@Test
	fun testSpell() {
		this.mockMvc.perform(get("$baseUrl/варенье").contentType(jsonContentType))
			.andDo(print()).andExpect(status().isFound)
			.andExpect(content().string(containsString("[\"варенье\",\"варенья\",\"варенью\",\"варенье\",\"вареньем\",\"варенье\"]")));
//		val request = get(baseUrl + "варенье").contentType(jsonContentType)
//
//		val resultJsonString = """
//			["варенье","варенья","варенью","варенье","вареньем","варенье"]
//        """.trimIndent()
//		mockMvc.perform(request)
//			.andExpect(status().isFound)
//			.andExpect(content().json(resultJsonString, true))
	}
}
