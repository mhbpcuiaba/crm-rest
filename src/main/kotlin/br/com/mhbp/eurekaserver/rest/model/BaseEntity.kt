package br.com.mhbp.eurekaserver.rest.model

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*


@MappedSuperclass
abstract class BaseEntity() : Serializable {

    @Column(nullable = false)
    @Version
    protected var version: Long = 0


    @Column(name = "modification_time")
    protected lateinit var updatedOn: LocalDateTime

    @Column(name = "creation_time")
    protected lateinit var createdAt: LocalDateTime

    @PrePersist
    fun onPreparePersist() {
        version = 1L
        createdAt = LocalDateTime.now()
    }

    @PreUpdate
    fun onPrepareUpdate() {
        updatedOn = LocalDateTime.now()
    }
}

/*
https://my.oschina.net/swiftloop/blog/1570506
https://ordina-jworks.github.io/conference/2016/07/10/SpringIO16-DDD-Rest.html
https://speakerdeck.com/mploed/ddd-strategic-design-with-spring-boot-examples?slide=13
https://spring.io/blog/2018/04/11/event-storming-and-spring-with-a-splash-of-ddd
http://www.baeldung.com/database-auditing-jpa
https://grokonez.com/spring-framework/spring-boot/kotlin-spring-boot/kotlin-spring-jpa-composite-primary-key-springboot-mysql
https://dzone.com/articles/graceful-shutdown-spring-boot-applications?edition=385197&utm_source=Daily%20Digest&utm_medium=email&utm_campaign=Daily%20Digest%202018-07-04
 */