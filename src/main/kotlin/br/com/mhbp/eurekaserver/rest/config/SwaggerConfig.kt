package br.com.mhbp.eurekaserver.rest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SwaggerConfig {

    val DEFAULT_CONTACT : Contact = Contact("marcos", "no-url-yet", "marcoscba@gmail.com")
    val DEFAULT_API_INFO: ApiInfo = ApiInfo("Api Documentation", "api desc", "1.0.0", "no terms right now", "MARCOSCBA@GMAIL.COM", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0")
    val DEFAULT_PRODUCES_AND_CONSUMES: Set<String> = HashSet<String>(Arrays.asList("application/json"))

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.mhbp.rest.restfulwebservice.controller"))
                .build()
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES)
    }
}