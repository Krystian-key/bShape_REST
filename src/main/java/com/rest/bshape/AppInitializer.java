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
	// http://localhost:8090/actuator/prometheus podgląd metryk

	//
	// http://localhost:8090/actuator/prometheus - wystawienie aktualnych metryk aplikacji
	// http://localhost:9090/graph - prometheus - w puste pole wpisuje nazwa metryki i otrzymuje o niej dane
	// http://localhost:3000/ - monitoring (login admin, admin) (klikam + import ID 4701 )
	// https://grafana.com/grafana/dashboards?search=Spring%20boot&orderBy=downloads&direction=desc - wszystkie dashbordy
	// krystian db test MarianTester@123.pl marian123321123

	// uster do testów
	// p: testertestowy
	// login: test@123.interia.pl
	// Usnername do DB AWS : AndrzejTester
	// Haslo do DB AWS : SuperSecretPassword12345678910$!
	// adnotacja preAuthorize w każdym controllerze które wymagają

	// beanStalk mam adres do servera (narzędzie do usługi z serverwa)
	// EC2 na TYm jest serwer
	// S3 bucket (na tym odpalam front i w properties mam linka do serverwa który serwuje statyczny kontent)
	// aws baza danych RDS
	// wchodzę w databases wybieram bazę danych + wchodzę w security group od mojej bazdy danych link po prawej + action (edit inbound rules)
	// na koniec podłaczam się przez link do bazdy danych w workbenchu hasło do db aws mam zapisane
	// stefanBatory123@interia.pl stefanBatory123
	//
}
