package com.simplilearn.prototype.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
	
@Configuration
//@EnableSwagger2
public class SwaggerConfig {
		/*@SuppressWarnings("unchecked")
		@Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	        		.apiInfo(getApiInfo())
	                .select()
	                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.simplilearn"))
	                .paths((Predicate<String>) PathSelectors.any())
	                .build();
	    }

		private ApiInfo getApiInfo() {
	        //Contact contact = new Contact("webtutsplus", "http://webtutsplus.com", "contact.webtutsplus@gmail.com");
	        return new ApiInfoBuilder()
	                .title("Ecommerce API")
	                .description("Documentation Ecommerce api")
	                .version("1.0.0")
	                .license("Apache 2.0")
	                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
	                .build();
	    }*/
	
	@Bean
    public Docket getBean() {
       return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.regex("/com.simplilearn.*")).build();
    }
	
	@SuppressWarnings("unused")
	private ApiInfo getInfo() {
		return new ApiInfoBuilder().title("GvStuidiozz").description("Sporty Shoes").license("GvStudiozz").build();
	}
		
		
		
		
}


