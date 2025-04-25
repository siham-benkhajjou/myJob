package ma.ensi.myJob.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthUtil {

    public void forceLogin(HttpServletRequest request, String email, String password) {
        try {
            if (request.getUserPrincipal() != null) {
                request.logout();
            }
            request.login(email, password);
        } catch (ServletException e) {
            throw new RuntimeException("Erreur lors de la connexion automatique", e);
        }
    }
}