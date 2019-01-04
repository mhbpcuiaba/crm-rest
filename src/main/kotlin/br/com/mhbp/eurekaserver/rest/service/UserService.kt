package br.com.mhbp.eurekaserver.rest.service

import br.com.mhbp.eurekaserver.rest.dto.UserDTO
import br.com.mhbp.eurekaserver.rest.model.UserEntity
import br.com.mhbp.eurekaserver.rest.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserService(val userRepo: UserRepository) {

    fun findbyId(id: Long): UserDTO? {
        return userRepo.findById(id).get()?.toUserDTO()
    }

    fun addUser(userDTO: UserDTO): UserDTO {
        return userRepo.save(UserEntity.fromDto(userDTO)).toUserDTO()
    }
}

/*
 fun findByName(name: String): List<UserEntity>
    fun findByLogin(login: String): UserEntity
    fun findByEmail(email: String): UserEntity
 */