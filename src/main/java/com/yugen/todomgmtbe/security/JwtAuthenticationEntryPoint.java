package com.yugen.todomgmtbe.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * This class represents an authentication entry point for JWT authentication.
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * Commences the authentication process.
     *
     * @param request the HttpServletRequest object
     * @param response the HttpServletResponse object
     * @param authException the AuthenticationException object
     * @throws IOException if an input or output error occurs
     * @throws ServletException if a servlet error occurs
     */
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
            throws IOException, ServletException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());

    }
}
