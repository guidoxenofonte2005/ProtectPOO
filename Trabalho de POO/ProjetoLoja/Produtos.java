package ProjetoLoja;

public class Produtos {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produtos (String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    //Criando getters para retornar os atributos privados
    public String getNome () {
        return nome;
    }

    public double getPreco () {
        return preco;
    }
    
    public int getQuantidadeEmEstoque () {
        return quantidadeEmEstoque;
    }

    //Criando setters
    public void setNome (String nome) {
        this.nome = nome;
    }

    public void setPreco (double preco) {
        if (preco >= 0) {
            this.preco = preco;
        }
        else {
            System.out.println ("O preço não pode ser negativo");
        }
    }

    public void setQuantidadeEmEstoque (int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}   

