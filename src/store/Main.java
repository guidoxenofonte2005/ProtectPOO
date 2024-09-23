package store;

import user.accessGranted.Gerente;
import user.accessGranted.Vendedor;
import user.client.Cliente;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.InputMismatchException;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        // testar criação, leitura e escrita em um arquivo separado para os vendedores, gerente e clientes do sistema
        try {
            File contas = new File("contas.txt");
            if (contas.createNewFile()) {
                System.out.println("\u001B[32m" + "Banco de contas criado" + "\u001B[0m");
            }
            else {
                System.out.println("\u001B[34m" + "Banco de contas acessado" + "\u001B[0m");
            }
        } catch (IOException e) {
            System.out.println("\u001B[31m" + "Erro no acesso/criação do banco de contas. Finalizando programa..." + "\u001B[0m");
        }

        Scanner scam = new Scanner(System.in);
        int valor = 0;
        Loja loja = new Loja(new ArrayList<>());
        boolean continuar = false;

        System.out.println("<----------------------------->");
        System.out.println("1 - Login como cliente");
        System.out.println("2 - Login como vendedor");
        System.out.println("3 - Login como gerente");
        System.out.println("<----------------------------->");
        while (valor < 1 || valor > 3) {
            System.out.print("Digite a sua opção: ");
            try {
                valor = scam.nextInt();
                scam.nextLine();  // Consumir o restante da linha após nextInt()
            } catch (InputMismatchException e) {
                System.out.println("Erro!!! Valor digitado de tipo inválido. Finalizando...");
                break;
            }
        }

        switch (valor) {
        // Login como cliente
            case 1:
                String nomeDoCliente;
                String emailCliente;

                // Inserir os dados de login do cliente
                System.out.print("Digite seu nome: ");
                nomeDoCliente = scam.nextLine();
                System.out.print("Digite seu email: ");
                emailCliente = scam.nextLine();

                // Criar o objeto cliente com os dados fornecidos
                Cliente cliente = new Cliente(nomeDoCliente, emailCliente);
                System.out.println("Login feito com sucesso como Cliente!");

                continuar = true;
                while (continuar) {
                    System.out.println("<----------------------------->");
                    System.out.println("1 - Acessar catálogo de produtos");
                    System.out.println("2 - Comprar produto");
                    System.out.println("3 - Criar conta");
                    System.out.println("4 - Deletar conta");
                    System.out.println("5 - Sair");
                    System.out.println("<----------------------------->");
                    System.out.print("Digite a sua opção: ");
                    valor = scam.nextInt();
                    scam.nextLine();  // Consumir o restante da linha após nextInt()

                    if (valor == 1) {
                        // Acessar o catálogo de produtos
                        cliente.accessProducts(loja);
                    }
                    else if (valor == 2) {
                        // Comprar produto
                        System.out.print("Digite o nome do produto que deseja comprar: ");
                        String nomeProduto = scam.nextLine();
                        System.out.print("Digite a quantidade que deseja comprar: ");
                        int quantidade = scam.nextInt();
                        scam.nextLine();  // Consumir o restante da linha

                        // Buscar produto na loja e realizar a compra
                        Produtos produtoParaComprar = loja.getProdutoPorNome(nomeProduto);
                        if (produtoParaComprar != null) {
                            cliente.purchaseOption(produtoParaComprar, quantidade);
                        }
                        else {
                            System.out.println("Produto não encontrado!");
                        }
                    }
                    else if (valor == 3) {
                        // Criar conta
                        cliente.criarConta();  // Método já pede os dados do cliente
                    }
                    else if (valor == 4) {
                        // Deletar conta
                    }
                    else if (valor == 5) {
                        continuar = false;
                        System.out.println("Saindo...");
                    }
                }
                break;

        //Login como vendedor
            case 2:
                String nomeDoVendedor;
                String email;

                System.out.print("Digite seu nome: ");
                nomeDoVendedor = scam.nextLine();
                System.out.print("Digite seu email: ");
                email = scam.nextLine();
                Vendedor vendedor = new Vendedor(nomeDoVendedor, email);

                System.out.println("Login feito com sucesso como Vendedor!");

                continuar = true;
                while (continuar) {
                    System.out.println("<----------------------------->");
                    System.out.println("1 - Adicionar produto");
                    System.out.println("2 - Ver produtos da loja");
                    System.out.println("3 - Sair");
                    System.out.println("<----------------------------->");
                    System.out.print("Digite a sua opção: ");
                    valor = scam.nextInt();
                    scam.nextLine();  // Consumir o restante da linha após nextInt()

                    if (valor == 1) {
                        // Adicionando um novo produto
                        System.out.print("Digite o nome do produto: ");
                        String nomeProduto = scam.nextLine();
                        System.out.print("Digite o preço do produto: ");
                        double precoProduto = scam.nextDouble();
                        System.out.print("Digite a quantidade em estoque: ");
                        int quantidadeEmEstoque = scam.nextInt();
                        scam.nextLine();  // Consumir o restante da linha

                        Produtos novoProduto = new Produtos(nomeProduto, precoProduto, quantidadeEmEstoque, 0);
                        vendedor.addProducts(loja, novoProduto);  // Método para adicionar o produto na loja

                        System.out.println("Produto adicionado com sucesso!");
                    }
                    else if (valor == 2) {
                        // Ver produtos da loja
                        vendedor.accessProducts(loja);
                    }
                    else if (valor == 3) {
                        continuar = false;
                        System.out.println("Saindo...");
                    }
                }
                scam.close();  // Fechar o scanner ao final
                break;
            case 3:
                break;
            default:
                break;
        }
    }
}