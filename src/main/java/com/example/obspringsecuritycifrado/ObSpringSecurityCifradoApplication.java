package com.example.obspringsecuritycifrado;

import com.example.obspringsecuritycifrado.entities.Usuario;
import com.example.obspringsecuritycifrado.repository.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ObSpringSecurityCifradoApplication {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ObSpringSecurityCifradoApplication.class, args);
        UsuarioRepository repository = context.getBean(UsuarioRepository.class);

        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

        Usuario usuario = new Usuario(null, "fernando", encoder.encode("admin"));
        repository.save(usuario);

    }

}
