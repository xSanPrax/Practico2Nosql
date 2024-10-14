//package com.hospital.security;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.stereotype.Component;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component // Para que Spring gestione esta clase como un componente
//public class Seguridad {
//
//    private final AuthenticationManager authenticationManager;
//
//    public Seguridad(AuthenticationManager authenticationManager) {
//        this.authenticationManager = authenticationManager;
//    }
//
//    public Authentication autenticar(String username, String password) {
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
//        return authenticationManager.authenticate(token);
//    }
//
//    public void autorizar(Authentication authentication) throws IllegalArgumentException {
//        if (authentication.isAuthenticated()) {
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        } else {
//            throw new IllegalArgumentException("Autenticación fallida");
//        }
//    }
//
//    public void logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//        }
//    }
//}
