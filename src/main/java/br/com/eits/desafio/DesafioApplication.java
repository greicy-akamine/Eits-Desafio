package br.com.eits.desafio;

import org.directwebremoting.spring.DwrSpringServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/META-INF/spring/desafio-context.xml")
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	/**
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean dwrSpringServletRegistration() {
		final ServletRegistrationBean registration = new ServletRegistrationBean(new DwrSpringServlet(), "/broker/*");
		registration.addInitParameter("debug", "true");
		registration.setName("dwrSpringServlet");
		return registration;
	}
}
