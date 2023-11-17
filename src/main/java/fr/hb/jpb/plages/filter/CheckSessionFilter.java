package fr.hb.jpb.plages.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
@Order(2) // Deuxième filtre à exécuter lorsque le serveur reçoit une requête HTTP
public class CheckSessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String uri = req.getRequestURI();
        Date date = new Date();
        System.out.println(date + " passage dans CheckSessionFilter " + req.getRequestURI());

        if (!uri.startsWith("/connexion") &&
                (!uri.startsWith("/h2-console")) &&
                (!uri.startsWith("/reservations")) &&
                (!uri.startsWith("/reservationPDF")) &&
                (!uri.startsWith("/index")) &&
                (!uri.startsWith("/api")) &&
                (!uri.startsWith("/swagger")) &&
                (!uri.startsWith("/beans")) &&
                (!uri.startsWith("/health")) &&
                (!uri.startsWith("/v3")) &&
                req.getSession().getAttribute("utilisateurConnecte")==null) {
            System.out.println(new Date() + " : Pas de session");
            ((HttpServletResponse) response).sendRedirect("/index");
        }
        else {
            chain.doFilter(request, response);
        }
    }
}
