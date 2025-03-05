/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testFinal;

/**
 *
 * @author ISABELADACOSTAMUELLE
 */
public class Cadastro {

    // Valida o nome (não pode ser vazio)
    public static boolean validarNome(String nome) {
 if (nome == null || nome.trim().isEmpty()) {
        return false;
    }
 return true;
    }

    // Valida o e-mail (deve conter "@" e ".")
    public   static boolean validarEmail(String email) {
    if (email == null) {
        return false;
    }

    return email.contains("@") && email.contains(".");
    }

    // Valida a senha (deve ter pelo menos 6 caracteres)
    public static boolean validarSenha(String senha) {
 if (senha.length()>=6) {
        return true;
    }
 return false;
    }
}