/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class EstoqueTest {
    private Estoque estoque;

    @BeforeEach
    void setUp() {
        estoque = new Estoque();
    }

    @AfterEach
    void tearDown() {
        estoque.limparEstoque();
    }

    @Test
    void testAdicionarProduto() {
        estoque.adicionarProduto("Arroz", 10);
        assertEquals(10, estoque.consultarQuantidade("Arroz"));
    }

    @Test
    void testAdicionarProdutoExistente() {
        estoque.adicionarProduto("Arroz", 10);
        estoque.adicionarProduto("Arroz", 5);
        assertEquals(15, estoque.consultarQuantidade("Arroz"));
    }

    @Test
    void testRemoverProduto() {
        estoque.adicionarProduto("Arroz", 10);
        estoque.removerProduto("Arroz", 5);
        assertEquals(5, estoque.consultarQuantidade("Arroz"));
    }

    @Test
    void testRemoverProdutoTotalmente() {
        estoque.adicionarProduto("Arroz", 10);
        estoque.removerProduto("Arroz", 10);
        assertEquals(0, estoque.consultarQuantidade("Arroz"));
    }

    @Test
    void testRemoverProdutoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> estoque.removerProduto("Arroz", 5));
    }

    @Test
    void testProdutoMaisEstocado() {
        estoque.adicionarProduto("Arroz", 10);
        estoque.adicionarProduto("Feijão", 20);
        assertEquals("Feijão", estoque.produtoMaisEstocado());
    }

    @Test
    void testProdutoMaisEstocadoComEstoqueVazio() {
        assertNull(estoque.produtoMaisEstocado());
    }

    @Test
    void testLimparEstoque() {
        estoque.adicionarProduto("Produto1", 10);
        estoque.limparEstoque();
        assertEquals(0, estoque.consultarQuantidade("Produto1"));
    }

    @Test
    void testReabastecerEstoque() {
        estoque.adicionarProduto("Arroz", 10);
        estoque.adicionarProduto("Feijão", 15);
        estoque.reabastecerEstoque(5);
        assertEquals(15, estoque.consultarQuantidade("Arroz"));
        assertEquals(20, estoque.consultarQuantidade("Feijão"));
    }

    @Test
    void testListarProdutos() {
        estoque.adicionarProduto("Arroz", 10);
        estoque.adicionarProduto("Feijão", 15);
        List<String> produtos = estoque.listarProdutos();
        assertTrue(produtos.contains("Arroz"));
        assertTrue(produtos.contains("Feijão"));
        assertEquals(2, produtos.size());
    }
}
