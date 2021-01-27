package springboot.askisi3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class Askisi3Application {

	public static void main(String[] args) {
		SpringApplication.run(Askisi3Application.class, args);
		
	
	
		
	

	}
	
	private static final int CORS_MAX_AGE = 3600;
	private static final String[] CORS_ALLOWED_ORIGINS = {"*"};
	private static final String[] CORS_ALLOWED_METHODS = {
	"POST", "GET", "OPTIONS", "PUT", "DELETE"
	};
	private static final String[] CORS_ALLOWED_HEADERS = {
	"X-Requested-With", "content-type", "Authorization"
	};

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**")
	.allowedOrigins(CORS_ALLOWED_ORIGINS)
	.allowedMethods(CORS_ALLOWED_METHODS)
	.maxAge(CORS_MAX_AGE)
	.allowedHeaders(CORS_ALLOWED_HEADERS)
	;
	}
	};
	}


}
