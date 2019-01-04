package br.com.mhbp.eurekaserver.rest.repository

import br.com.mhbp.eurekaserver.rest.model.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface UserRepository : JpaRepository<UserEntity, Long> {

    fun findByName(name: String): List<UserEntity>
    fun findByEmail(email: String): UserEntity
}