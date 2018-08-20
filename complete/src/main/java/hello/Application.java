package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class Application {

  @Configuration
  @EnableSwagger2
  public class SwaggerConfig {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * needed so that jackson understands the JAXB Annotations.
     *
     * @return the module
     */
    @Bean
    public Module enableJaxbForJackson() {
      log.info("JAXB Annotations enabled");
      final JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();
      return jaxbAnnotationModule;
    }

    @Bean
    public Docket api() {
      return new Docket(DocumentationType.SWAGGER_2).select()
                                                    .apis(RequestHandlerSelectors.any())
                                                    .paths(PathSelectors.any())
                                                    .build();
    }
  }

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
