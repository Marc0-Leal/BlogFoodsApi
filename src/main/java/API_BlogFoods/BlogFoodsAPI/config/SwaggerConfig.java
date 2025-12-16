package API_BlogFoods.BlogFoodsAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
@Configuration
public class SwaggerConfig {
    
    
   @Bean
   public OpenAPI customOpenAPI(){
       return new OpenAPI().info(
           new Info()
           .title("API demo")
           .version("0.1")
           .description("Api de repaso")
       );
   }

}
