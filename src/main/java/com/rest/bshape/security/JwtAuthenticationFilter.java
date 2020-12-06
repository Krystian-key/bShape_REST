package com.rest.bshape.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.bshape.user.domain.LoginDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

import static java.util.stream.Collectors.joining;

// glasa do generowania tokenów po poprawnym zalogowanu
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.setAuthenticationManager(authenticationManager);
        setUsernameParameter("email"); // loguje sie po emailu , default username

    }

    // bedzie generowac token po poprawnym zalogowaniu
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        Claims claims = new DefaultClaims()
                .setSubject(((UserDetails) authResult.getPrincipal()).getUsername()) // castuje do interfejsu UserDetails aby pobrać nazwę uzytkownika ktory poprawnie sie zalogowal
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));  // jak długo token jest wazny - token jest ważny cały dzień


        claims.put("authorities", authResult.getAuthorities().stream()            /// pobrałem liste simpleAuhtority
                .map(GrantedAuthority::getAuthority) // metoda referencyjna
                .collect(joining(","))); // mapuje, pobieram auuthority i colectuje łącząc przy pomocy joning.


        String token = Jwts.builder()
                .setClaims(claims)  // setuje claimsy
                .signWith(SignatureAlgorithm.HS512, "mySecretKeyHehe")  // ustawiam sygnature haszowania + ustawiam klucz
                .compact(); // tworze token
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        // wykorzystuje Singletonowa mape, oraz ObjectMapper ktora parsuje i rozparosowywuje Jsony,  parujsemy mape na jsona tworze mape z jednym wpisem.
        new ObjectMapper().writeValue(response.getWriter(), Collections.singletonMap("token", token));

    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            LoginDTO loginDTO = new ObjectMapper().readValue(request.getInputStream(), LoginDTO.class);
            UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
            setDetails(request,authRequest);  // bazuje na orginalnej funkcji
            return this.getAuthenticationManager().authenticate(authRequest);
        } catch (IOException e) {
            throw new AuthenticationServiceException("Wrong Params: " + e.getMessage()); // jedyne co może sie zepsuć to parsowanie Jsona dlatego taki komentarz
        }

    }
}
