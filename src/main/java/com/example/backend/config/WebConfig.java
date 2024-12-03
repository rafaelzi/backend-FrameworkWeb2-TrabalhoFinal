package com.example.backend.config;
 
/*
Este código configura o Cross-Origin Resource Sharing (CORS) em uma aplicação Spring Boot.
O CORS é um mecanismo de segurança do navegador que bloqueia requisições web
feitas a partir de um domínio diferente do domínio da página atual. Essa configuração
permite que um frontend, em execução em `http://localhost:5173`, acesse recursos
da API backend neste servidor.
*/
 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration // Indica que esta classe é uma classe de configuração do Spring
public class WebConfig implements WebMvcConfigurer { // Implementa a interface para configurar o Spring MVC
 
    @Override // Sobrescreve o método para adicionar mapeamentos CORS
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Mapeia todas as requisições que começam com /api
                .allowedOrigins("http://localhost:5173", "https://frontend-framework-web2-trabalho-final.vercel.app/") // Permite o frontend local e o VERCEL 
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite os métodos HTTP especificados
                .allowCredentials(true); // Permite enviar cookies e cabeçalhos de autenticação
    }
}