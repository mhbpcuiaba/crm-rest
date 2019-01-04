package br.com.mhbp.eurekaserver.rest.controller

import br.com.mhbp.eurekaserver.rest.dto.UserDTO
import br.com.mhbp.eurekaserver.rest.resourceassembler.UserResourceAssembler
import br.com.mhbp.eurekaserver.rest.resource.UserResource
import br.com.mhbp.eurekaserver.rest.service.UserService
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.hateoas.mvc.ControllerLinkBuilder
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping(value = "users", produces = [MediaType.APPLICATION_JSON_VALUE])
class UserController(val service: UserService, val messageSource: MessageSource, val resourceAssembler: UserResourceAssembler) {

    @GetMapping("/hello-i18n")
    fun hello(@RequestHeader(name = "Accept-Language", required = false) locale: Locale) : String {
        return messageSource.getMessage("good.morning.message", null, locale)
    }

    @GetMapping("/v1/hello-i18n")
    fun hellov2() : String {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale())
    }

    @GetMapping("{id}")
    fun retrieveUser(@PathVariable("id") id: Long?): HttpEntity<UserResource> {
        print("id operator:$id")
        val userDTO = service.findbyId(id!!)
        if (userDTO != null) {
            val resource = resourceAssembler.toResource(userDTO)
            val controllerLinkBuilder: ControllerLinkBuilder = linkTo(methodOn(this::class.java).retrieveUser(id))
            resource.add(controllerLinkBuilder.withSelfRel())
            return ResponseEntity.ok(resource)
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        }
    }

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addUser(@Valid @RequestBody userDTO: UserDTO, uriBuilder: UriComponentsBuilder): HttpEntity<UserResource> {
        val userAdded = service.addUser(userDTO)
        val resource = resourceAssembler.toResource(userAdded)
        resource.add(linkTo(methodOn(this::class.java).retrieveUser(userAdded.id)).withSelfRel())
        return ResponseEntity
                .created(uriBuilder.path("users/{id}").buildAndExpand(userAdded.id).toUri())
                .body(resource)
    }

}
//https://github.com/dnno/spring-kotlin-jpa/blob/master/web/src/main/kotlin/de/rpr/mycity/web/CityController.kt