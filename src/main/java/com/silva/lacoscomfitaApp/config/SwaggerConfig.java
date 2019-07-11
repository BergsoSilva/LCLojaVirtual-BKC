package com.silva.lacoscomfitaApp.config;

import com.google.common.base.Predicate;
import com.silva.lacoscomfitaApp.config.property.LacosApiProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Configuração do Swagger para consultar a API através de um browser e para gerar API para o FRONT
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {

    @Value("${build.timestamp}")
    private String buildTimestamp;


    @Value("${security.oauth2.client-id}")
    private String clientId;

    @Value("${security.oauth2.resource.token-url}")
    private String tokenUrl;

    @Value("${pdm.seguranca.security.oauth2.client.client-secret}")
    private String clientSecret;

    @Autowired
    private LacosApiProperty lacosApiProperty;


    private static  final String TITLE="PDM";
    private static  final String DESCRIPTION="PDM - Product Data Managment";
    private static  final String VERSION="3.0.0";


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).forCodeGeneration(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                .apis(apis())
                .paths(PathSelectors.any())
                .build().securitySchemes(Collections.singletonList(securitySchema()))
                .apiInfo(apiInfo())
                .securityContexts(Collections.singletonList(securityContext()));

    }


    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.ant("/**"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {

        AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
        authorizationScopes[0] = new AuthorizationScope("read", "read all");
        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
        authorizationScopes[2] = new AuthorizationScope("write", "write all");

        return Collections.singletonList(new SecurityReference("oauth2schema", authorizationScopes));

    }

    private Predicate<RequestHandler> apis() {
        return RequestHandlerSelectors.basePackage("br.com.itbam.controller");
    }


    private ApiInfo apiInfo() {
        ApiInfo apiInfos = new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .build();
        return apiInfos;
    }

    private OAuth securitySchema() {

        List<AuthorizationScope> authorizationScopeList = new ArrayList();
        authorizationScopeList.add(new AuthorizationScope("read", "read all"));
        authorizationScopeList.add(new AuthorizationScope("trust", "trust all"));
        authorizationScopeList.add(new AuthorizationScope("write", "access all"));

        List<GrantType> grantTypes = new ArrayList();

        grantTypes.add(new ResourceOwnerPasswordCredentialsGrant(tokenUrl));

        return new OAuth("oauth2schema", authorizationScopeList, grantTypes);

    }

    @Bean
    public SecurityConfiguration securityInfo() {

        SecurityConfigurationBuilder builder = SecurityConfigurationBuilder.builder();
        builder.clientId(lacosApiProperty.getSeguranca().getSwaggerClientId());
        builder.clientSecret(clientSecret);
        builder.scopeSeparator(" ");

        return builder.build();
    }

}
