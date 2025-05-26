package com.ezybytes.accounts;

import com.ezybytes.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value ={AccountsContactInfoDto.class})
@OpenAPIDefinition(
              info=@Info(
                  title= "Account microservice REST API Documentation",
                  description= "EazyBank Account microservice REST API Documentation",
                  version= "v1",
                  contact= @Contact(
                               name= "Sakshi Agrawal",
                               email= "sakshiagrawal259@gmail.com",
                               url="https://github.com/9406886320/AccountApplication/commit/cc5cb1023792ca898c787bc232de7e4c0c28cdcf"
                  ),
                  license= @License (
                                  name= "Apache 2.0",
                                  url="---------------"
                  )
              ),
              externalDocs= @ExternalDocumentation(
                            description="EazyBank Account microservices REST API Documentation",
                            url="https://github.com/9406886320/"
              )
)

public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }


}
