package br.edu.ifsp.provaPRW3.api_2025_bes.user;
import jakarta.validation.constraints.NotBlank;

public record dadosAuth(

        @NotBlank
        String login,

        @NotBlank
        String senha) {

}