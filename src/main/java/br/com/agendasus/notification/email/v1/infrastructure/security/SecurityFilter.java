package br.com.agendasus.notification.email.v1.infrastructure.security;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecurityFilter implements Filter {

    private static final String AUTHORIZATION_TOKEN = "DM2kDSAn34Akjn2Hkj3K2j4nXkn2oTfn23AonDfoCkAn32";

    @Override
    public void init(FilterConfig fc) {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpServletRequest request = (HttpServletRequest) req;

        if (AUTHORIZATION_TOKEN.equals(request.getHeader("authorization"))) {
            chain.doFilter(req, resp);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }

    }

    @Override
    public void destroy() {
    }

}
