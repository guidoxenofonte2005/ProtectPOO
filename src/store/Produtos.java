package store;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Produtos {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;
    private int quantidadeVendida;

    public Produtos(String nome, double preco, int quantidadeEmEstoque, int quantidadeVendida) {
        this.nome = nome;
        this.preco = preco;
        setQuantidadeEmEstoque(quantidadeEmEstoque);
        this.quantidadeVendida = quantidadeVendida;
    }

    //Criando getters para retornar os atributos privados
    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    //Criando setters
    public void setNome(String nome) {
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

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void registrarVenda (int quantidadeVendida) {
        if (quantidadeVendida <= quantidadeEmEstoque) {
            this.quantidadeVendida += quantidadeVendida;
            this.quantidadeEmEstoque -= quantidadeVendida;
            try {
                File prods = new File("produtos.txt");
                Scanner reader = new Scanner(prods);
                while (reader.hasNextLine()) {
                    continue; // mexer nisso dps
                }
            } catch (Exception e) {
                // sla
            }
        }
        else {
            System.out.println("\u001B[31mEstoque insuficiente para realizar a venda\u001B[m");
        }
    }

    public void reposicao(int repor) {
        this.quantidadeEmEstoque += repor;
    }
}