package co.za.task.tracker.util.security.configuration;

import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private IPropertyFetcher<AppConstant> propertyFetcher;

    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(propertyFetcher.getProperty(AppConstant.FE_BASE_DOMAIN))
                .allowedMethods(allowedHttpMethods())
                .maxAge(MAX_AGE_SECS);
    }

    private String[] allowedHttpMethods() {
        final String[] httpMethods = {
                propertyFetcher.getProperty(AppConstant.HTTP_HEAD), propertyFetcher.getProperty(AppConstant.HTTP_OPTIONS),
                propertyFetcher.getProperty(AppConstant.HTTP_GET), propertyFetcher.getProperty(AppConstant.HTTP_POST),
                propertyFetcher.getProperty(AppConstant.HTTP_PUT), propertyFetcher.getProperty(AppConstant.HTTP_PATCH),
                propertyFetcher.getProperty(AppConstant.HTTP_DELETE)
        };
        return httpMethods;
    }
}