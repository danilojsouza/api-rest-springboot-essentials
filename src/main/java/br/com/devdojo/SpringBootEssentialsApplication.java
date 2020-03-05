/*
*Projeto para aprendizado SpringBoot
* Feito por Danilo Souza;
* Anotações excessivas para aprendizado;
 */
package br.com.devdojo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //Substitui anotações que antes era necessário ex: @EnableAutoConfig
public class SpringBootEssentialsApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootEssentialsApplication.class, args);
	}
}