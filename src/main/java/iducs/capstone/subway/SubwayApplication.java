package iducs.capstone.subway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class SubwayApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SubwayApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SubwayApplication.class, args);
	}


	@Bean   // 메소드를 호출하여 Bean 객체를 생성
	public HiddenHttpMethodFilter hiddenHttpMethodFilter() { // put, delete 처리
		return new HiddenHttpMethodFilter();
	}

}
