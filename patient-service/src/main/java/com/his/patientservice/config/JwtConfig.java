package com.his.patientservice.config;

import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import com.his.patientservice.utils.PemUtils;

@Configuration
public class JwtConfig {

    @Bean
    public JwtDecoder jwtDecoder(@Value("${jwt.public-key-path}") String publicKeyPath) throws Exception {
        RSAPublicKey publicKey = (RSAPublicKey) PemUtils.readPublicKey(publicKeyPath);
        return NimbusJwtDecoder.withPublicKey(publicKey).build();
    }

}
