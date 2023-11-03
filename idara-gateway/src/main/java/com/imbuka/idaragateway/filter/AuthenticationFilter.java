package com.imbuka.idaragateway.filter;

import com.imbuka.idaragateway.util.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.RouteTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
@AllArgsConstructor
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter>{


    private RouteValidator routeValidator;
   /* private RestTemplate restTemplate;*/

    private JwtUtil jwtUtil;
    public AuthenticationFilter() {
        super(AuthenticationFilter.class);
    }

    @Override
    public GatewayFilter apply(AuthenticationFilter config) {
        return (((exchange, chain) -> {
            if (routeValidator.isSecured.test(exchange.getRequest())) {
                //header contains token or not
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                    throw new RuntimeException("Missing authorization header");
                }

                String authHeader = Objects.requireNonNull(exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);
                if (authHeader!=null && authHeader.startsWith("Bearer ")) {
                    authHeader = authHeader.substring(7);
                }
                try {
                    //REST call to Auth Service
                   /* restTemplate.getForObject("http://SECURITY-SERVICE//validate?token" + authHeader, String.class);*/
                    jwtUtil.validateToken(authHeader);

                } catch (Exception e) {
                    System.out.println("Invalid access");
                    throw new RuntimeException("Unauthorised access to application");
                }
            }
            return chain.filter(exchange);
        }));
    }

    public static class Config {

    }
}
