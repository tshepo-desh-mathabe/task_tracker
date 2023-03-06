package co.za.task.tracker.util.security.configuration;

import co.za.task.tracker.util.constants.AppConstant;
import co.za.task.tracker.util.property_fetcher.IPropertyFetcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    private IPropertyFetcher<AppConstant> propertyFetcher;

    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                propertyFetcher.getProperty(AppConstant.UNAUTHORIZED_MESSAGE));
    }
}