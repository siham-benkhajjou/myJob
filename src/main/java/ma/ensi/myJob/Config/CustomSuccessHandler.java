package ma.ensi.myJob.Config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();

            switch (role) {
                case "CANDIDAT":
                    response.sendRedirect("/candidate/home");
                    return;
                case "RECRUTEUR":
                    response.sendRedirect("/recruteur/home");
                    return;
                case "ADMIN":
                    response.sendRedirect("/admin/dashboard");
                    return;
                case "UNIVERSITY":
                    response.sendRedirect("/university/home");
                    return;
            }
        }

        // Default fallback
        response.sendRedirect("/default");
    }
}
