package dio.web_api.doc;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .displayName("Primeira API com swagger")
                .group("Web-Api")
                .pathsToMatch("/users/**")
                .build();
    }
}
