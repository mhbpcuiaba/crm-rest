package br.com.mhbp.eurekaserver.rest.dto

import java.time.LocalDate
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class UserDTO(val id: Long? = null,
                   @NotEmpty val name: String? = null,
                   @Email val email: String? = null,
                   @NotEmpty val login: String? = null,
                   val password: String? = null,
                   val phone: String? = null,
                   @NotEmpty val birthday: LocalDate? = null,
                   val userMgmtId :Long? = null)



