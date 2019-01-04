package br.com.mhbp.rest.restfulwebservice.controller

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext


//@RunWith(SpringRunner::class)
class UserControllerTest {

    val mvc: MockMvc? = null

//    @Autowired
    val context: WebApplicationContext? = null

//    @Before
    fun setup() {
        val mvc = MockMvcBuilders.webAppContextSetup(context!!).build()
    }

//    @Test
    fun fetchUserById() {

        mvc?.perform(get("/operator/1"))?.andExpect(status().isOk)
    }


}