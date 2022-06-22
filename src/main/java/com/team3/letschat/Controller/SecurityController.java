package com.team3.letschat.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team3.letschat.Service.userService;
import com.team3.letschat.Users.User;
import com.team3.letschat.Users.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController @Slf4j @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "false")
public class SecurityController {

    @Autowired
    private userService UserService;


    /*@RequestMapping("/login")
    protected void Login(HttpServletRequest request, HttpServletResponse response)
    {}*/

    @GetMapping("/_refresh")
    protected void validaterefreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        String authorizationHeader = request.getHeader(AUTHORIZATION);

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer "))
        {
            try
            {
                String refreshtoken = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("D3M0@p!K3Y4APPDEV".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refreshtoken);
                String username = decodedJWT.getSubject();
                User user = UserService.getUser(username);
                String access_token = generateAuthToken(algorithm, user.getUsername(), request, user);
                response.setHeader("access_token", access_token);
            }
            catch(Exception e)
            {
                log.error("error logging in: {}", e.getMessage());
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                error.put("error_message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);

            }
        }
        else
        {
            throw new RuntimeException("Refresh Token missing or invalid");
        }
    }

    protected String generateAuthToken(Algorithm key, String username, HttpServletRequest request, User user)
    {
        String access_token = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 10 * 60 * 1000))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", user.getRoles().stream().map(UserRole::getRoleType).collect(Collectors.toList()))
                .sign(key);
        return access_token;
    }

}
