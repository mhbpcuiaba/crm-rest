package br.com.mhbp.rest.restfulwebservice.service

import br.com.mhbp.eurekaserver.rest.service.UserService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired

//import org.mockito.junit.jupiter.MockitoExtension
//@RunWith(SpringJUnit4ClassRunner::class)
//@ExtendWith(MockitoExtension.class)
@DisplayName("Spring boot 2 mockito2 Junit5 example")
class UserServiceTest {

    @Autowired
    lateinit var service: UserService

//    @Autowired
//    lateinit var repo: UserRepository

//    @Test
    fun `'retrieveCities' should retrieve empty list if repository doesn't contain entities`() {
        assertThat(service.findbyId(1L)).isNotNull()
    }

}

