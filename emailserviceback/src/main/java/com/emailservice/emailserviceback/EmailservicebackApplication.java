package com.emailservice.emailserviceback;

import com.emailservice.emailserviceback.model.Email;
import com.emailservice.emailserviceback.model.EmailUser;
import com.emailservice.emailserviceback.repo.EmailRepo;
import com.emailservice.emailserviceback.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.time.LocalDateTime;
import java.util.Arrays;

@SpringBootApplication
public class EmailservicebackApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailservicebackApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserRepo userRepo, EmailRepo emailRepo){

		return args -> {
			userRepo.save(new EmailUser(null, "ana", "stanic"));
			userRepo.save(new EmailUser(null, "teodora", "glisic"));
			userRepo.save(new EmailUser(null, "petar", "repac"));
			userRepo.save(new EmailUser(null, "vukasin", "stepanovic"));

			emailRepo.save(new Email(null, "ana", "petar", "text mejla1",  LocalDateTime.now()));
			emailRepo.save(new Email(null, "teodora", "petar","text mejla2",  LocalDateTime.now()));
			emailRepo.save(new Email(null, "petar", "ana", "text mejla3",  LocalDateTime.now()));
			emailRepo.save(new Email(null, "vukasin", "ana", "text mejla4",  LocalDateTime.now()));



		};

	}


	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "Jwt-Token",
				"Authorization", "Origin, Accept","X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin",  "Content-Type", "Accept", "Jwt-Token",
				"Authorization","Access-Control-Allow-Origin","Access-Control-Allow-Origin",  "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);

		return new CorsFilter(urlBasedCorsConfigurationSource);


	}

}
