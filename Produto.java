/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mercado;

/**
 *
 * @author ISABELADACOSTAMUELLE
 */
public class Produto {
    private String nome;
    private int quantidade;

    public Produto(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    } 

    //método para retornar o nome do produto;
    public String getNome() {
        return nome;
    }

    //método para retornar quantidade disponível do produto;
    public int getQuantidade() {
        return quantidade;
    }

    //método para adicionar uma quantidade ao estoque do produto;
    public void adicionarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }
    
    //método para remover uma quantidade ao estoque do produto
    public void removerQuantidade(int quantidade) {
        //se a quantidade solicitada for maior doq a disponível imprimo uma mensagem de erro 
        if (quantidade > this.quantidade) {
            throw new IllegalArgumentException("Quantidade não disponível.");
        }
        this.quantidade -= quantidade;
    }
}