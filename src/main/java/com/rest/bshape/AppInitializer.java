package com.rest.bshape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@EnableAspectJAutoProxy(proxyTargetClass=true) // włączam działanie aspektów
public class AppInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AppInitializer.class, args);
	}


	//http://localhost:8092/swagger-ui.html wchodzę pod ten adres i widzę controlery i mogę testować rest api
	// default SpringSecurity login auth
	// login: user a hasło generuje wam sie w consoli
}
