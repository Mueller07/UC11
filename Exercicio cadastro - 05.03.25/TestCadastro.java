/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testFinal;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author ISABELADACOSTAMUELLE
 */
public class TestCadastro {
    private Cadastro cadastro;
    
    @BeforeEach
    void setUp() {
        cadastro = new Cadastro(); 
    }
    
    @Test
    void testValidarNome(){
        assertTrue(cadastro.validarNome("Isabela"));
    }
    
    @Test
    void testErroValidarNome(){
        assertFalse(cadastro.validarNome(null));
    }
    
    @Test
    void testValidarNomeVazio() {
        assertFalse(cadastro.validarNome(""));
    }
    
    @Test
    void testValidarNomeComEspacos() {
    assertFalse(cadastro.validarNome("  ")); 
}
    
    
    
    @Test
    void testValidarEmail(){
        assertTrue(cadastro.validarEmail("isabela@gmail.com"));
    }
    
    @Test
    void testArrobaValidarEmail() {
        assertFalse(cadastro.validarEmail("isabelagmail.com")); // Testa um e-mail sem '@', o que deve ser inválido
    }
    
    @Test
    void testPontoValidarEmail() {
        assertFalse(cadastro.validarEmail("isabela@gmailcom")); // Testa um e-mail sem '@', o que deve ser inválido
    }
    

    
    @Test
    void testValidarSenha(){
        assertTrue(cadastro.validarSenha("123456"));
    }
    
    @Test
    void testErroValidarSenha(){
        assertFalse(cadastro.validarSenha("123"));
    }
    
}
