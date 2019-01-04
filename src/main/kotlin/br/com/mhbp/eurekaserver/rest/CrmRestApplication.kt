package br.com.mhbp.eurekaserver.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import java.util.*

@EntityScan(basePackageClasses = [CrmRestApplication::class, Jsr310JpaConverters::class])
@SpringBootApplication
@EnableEurekaClient
class CrmRestApplication

fun main(args: Array<String>) {
    runApplication<CrmRestApplication>(*args)

    @Bean
    fun localeResolver(): LocaleResolver {
        val localeResolver: SessionLocaleResolver = SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US)
        return localeResolver
    }

    @Bean
    fun messageSource(): ResourceBundleMessageSource {
        val messageSource = ResourceBundleMessageSource();
        messageSource.setBasename("messages")
        return messageSource
    }
}
