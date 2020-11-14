package br.com.agendasus.notification.email.v1.infrastructure.documentation;

import br.com.agendasus.notification.AgendaSUSApp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket apis() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.agendasus.notification"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Agenda SUS API Notification")
                .description("\"This service has the goal send warnings messages or information messages about system operations\"")
                .version(AgendaSUSApp.systemVersion)
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
                .build();
    }

}
