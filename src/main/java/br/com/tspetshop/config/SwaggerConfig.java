package br.com.tspetshop.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI getOpenApi() {
		
		Contact contact = new Contact();
		contact.name("Tiago Souza");
		contact.email("tiagoeduardosouza@gmail.com");
		
		Map<String, Object> extensions = new HashMap<>();
        extensions.put("LinkedIn", "https://www.linkedin.com/in/tiagotsouza/");
        
		contact.extensions(extensions);
		
		Info info = new Info();	
		info.title("PetShop");
		info.version("v1");
		info.description("Aplicaçao para agendamento de banho e tosa no petShop");
		info.contact(contact);
		
		return new OpenAPI().info(info);
	}
}
