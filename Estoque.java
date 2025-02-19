/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado;

/**
 *
 * @author ISABELADACOSTAMUELLE
 */
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(String nome, int quantidade) {
        for (Produto prod : produtos) {
            if (prod.getNome().equals(nome)) {
                prod.adicionarQuantidade(quantidade);
                return;
            }
        }
        produtos.add(new Produto(nome, quantidade));
    }

    public void removerProduto(String nome, int quantidade) {
        for (int i = 0; i < produtos.size(); i++) {
            Produto prod = produtos.get(i);
            if (prod.getNome().equals(nome)) {
                prod.removerQuantidade(quantidade);
                if (prod.getQuantidade() == 0) {
                    produtos.remove(i);
                }
                return;
            }
        }
        throw new IllegalArgumentException("O produto solicitado não foi encontrado.");
    }

    public int consultarQuantidade(String nome) {
        for (Produto prod : produtos) {
            if (prod.getNome().equals(nome)) {
                return prod.getQuantidade();
            }
        }
        return 0;
    }

    public String produtoMaisEstocado() {
        if (produtos.isEmpty()) {
            return null;
        }
        Produto maisEstocado = produtos.get(0);
        for (Produto prod : produtos) {
            if (prod.getQuantidade() > maisEstocado.getQuantidade()) {
                maisEstocado = prod;
            }
        }
        return maisEstocado.getNome();
    }

    public void limparEstoque() {
        produtos.clear();
    }

    // Método extra: Reabastecer o estoque
    public void reabastecerEstoque(int quantidade) {
        for (Produto prod : produtos) {
            prod.adicionarQuantidade(quantidade);
        }
    }

    // Método extra: Listar todos os produtos
    public List<String> listarProdutos() {
        List<String> nomes = new ArrayList<>();
        for (Produto prod : produtos) {
            nomes.add(prod.getNome());
        }
        return nomes;
    }
}