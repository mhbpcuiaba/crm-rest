package br.com.mhbp.eurekaserver.rest.resourceassembler

import br.com.mhbp.eurekaserver.rest.dto.UserDTO
import br.com.mhbp.eurekaserver.rest.resource.UserResource
import org.springframework.hateoas.mvc.ResourceAssemblerSupport
import org.springframework.stereotype.Component

/*
https://www.logicbig.com/tutorials/spring-framework/spring-hateoas/enable-hypermedia-support-hal.html
https://reflectoring.io/accessing-spring-data-rest-with-feign/
4. Client side support, 4.1. Traverson
 */
@Component
class UserResourceAssembler : ResourceAssemblerSupport<UserDTO, UserResource>(UserDTO::class.java, UserResource::class.java) {

    override fun toResource(dto: UserDTO?): UserResource {
        return UserResource(
                _id = dto?.id!!,
                name = dto?.name,
                email = dto?.email,
                login = dto?.login,
                phone = dto?.phone,
                birthday = dto?.birthday
        )
         }
}