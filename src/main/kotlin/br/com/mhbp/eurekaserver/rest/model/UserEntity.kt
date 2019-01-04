package br.com.mhbp.eurekaserver.rest.model

import br.com.mhbp.eurekaserver.rest.dto.UserDTO
import org.hibernate.annotations.NaturalId
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.Email
/*
https://blog.codecentric.de/en/2017/06/kotlin-spring-working-jpa-data-classes/
 */

@Entity
@Table(schema = "crm", name = "Users")
class UserEntity() : BaseEntity() {

    @Id
    @SequenceGenerator(name = "sq_users", sequenceName = "\"crm\".users_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sq_users")
    protected  var id: Long? = null

    @Column(nullable = false)
    protected var name: String? = null

    @Column(nullable = false, name = "user_mgmt_id")
    protected var userMgmtId: Long? = null

    @Column(nullable = false)
    @Email
    @NaturalId
    protected var email: String? = null

    @Column(nullable = false)
    protected var phone: String? = null

    @Column(nullable = false)
    protected var birthday: LocalDate? = null

    @Column(name = "active")
    protected var active: Boolean = false

    constructor(id: Long, name: String, email: String, birthday: LocalDate, active: Boolean, userMgmtId: Long) : this() {
        this.id = id
        this.name = name
        this.email = email
        this.birthday = birthday
        this.active = active
        this.userMgmtId = userMgmtId
    }

    override fun toString(): String {
        return "UserEntity(id=$id, name=$name, email=$email, phone=$phone, birthday=$birthday, active=$active, userMgmtId=$userMgmtId)"
    }



    fun toUserDTO(): UserDTO = UserDTO(
            id = this.id,
            name = this.name,
            email = this.email,
            birthday = this.birthday
    )

  companion object {

    fun fromDto(dto: UserDTO) = UserEntity(
            id = dto.id ?: 0,
            name = dto.name ?: "",
            email = dto.email ?: "",
            birthday = dto.birthday ?: LocalDate.now(),
            active = true,
            userMgmtId = dto.userMgmtId ?: 0)
  }
}
