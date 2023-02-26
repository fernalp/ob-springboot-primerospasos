package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt que genera su propio salt de 16 bytes
     *
     * El resultado de cifrar con BCrypt será un Strin de 60 carácteres
     *
     * $a versión
     * $10 fuerza (valor que va de 4 a 31 y por defecto es 10)
     * los 22 siguientes carácteres son el salt generado
     */
    @Test
    void bcryptTest(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("1234567");
        System.out.println(hashedPassword);

        Boolean matches = passwordEncoder.matches("1234567",hashedPassword);
        System.out.println(matches);
    }

    @Test
    void bcryptCheckMultiplePasswords(){
        for (int i = 0; i <30 ; i++) {
            System.out.println(new BCryptPasswordEncoder().encode("admin"));
        }
    }

    @Test
    void pbkdf2() {
        Pbkdf2PasswordEncoder passwordEncoder = Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
        for (int i = 0; i < 30; i++) {
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

    @Test
    void argon() {
//        Argon2PasswordEncoder passwordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_2();
//        for (int i = 0; i < 30; i++) {
//            System.out.println(passwordEncoder.encode("admin"));
//        }
    }

    @Test
    void scrypt() {
//        SCryptPasswordEncoder passwordEncoder = SCryptPasswordEncoder.defaultsForSpringSecurity_v5_8();
//        System.out.println(passwordEncoder.encode("Fernandp"));
    }

    @Test
    void springPasswordEncoder() {
//
//        String idForEncode = "bcrypt";
//
//        Map<String,PasswordEncoder> encoders = new HashMap<>();
//
//        encoders.put("bcrypt", new BCryptPasswordEncoder());
//        encoders.put("pbkdf2", Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8());
//
//        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt",encoders);
////        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2",encoders);
//        System.out.println(passwordEncoder.encode("admin"));
    }
}
