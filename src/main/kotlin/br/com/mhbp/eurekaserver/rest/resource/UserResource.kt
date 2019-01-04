package br.com.mhbp.eurekaserver.rest.resource

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import org.springframework.hateoas.ResourceSupport
import java.time.LocalDate

@ApiModel(description="User rsesource")
data class UserResource
constructor(
        @JsonProperty("id") val _id: Long,
        @JsonProperty("name") val name: String?,
        @JsonProperty("email") val email: String?,
        @JsonProperty("login") val login: String?,
        @JsonProperty("phone") val phone: String?,
        @JsonProperty("birthday") val birthday: LocalDate? = null) : ResourceSupport() {

    /*
    poderia retornar os links para chamadas ajax?
    a ideia eh prover todas as urls de backend para o front-end? ou nao, apenas alguns casos, mas quais casos?
     */
}