package salleDeConcert.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("salleDeConcert.restcontrollers")
@Import(JpaConfig.class)
public class WebConfig {

}
