package user.accessGranted;

import java.util.List;
import user.accessGranted.Usuario;
import store.Loja;
import store.Produtos;

public class Vendedor extends Usuario {
    public Vendedor (String nome, String email) {
        super(nome, email);
    }

    @Override
    public void acessarSistema () {

    }

    public void accessProducts (Loja loja) {
        List <Produtos> produto = loja.getProdutos();
        if (produto.isEmpty()) {
            System.out.println("Não há produtos disponíveis");
        }
        else {
            System.out.println("Acessando os produtos: ");
            for (Produtos produtos : produto) {
                System.out.println("-----------------------------");
                System.out.println("Nome: " +  produtos.getNome() + ", Preço: " + produtos.getPreco()
                        + ", Quantidade em estoque: " + produtos.getQuantidadeEmEstoque());

            }
        }
    }

    public void changePrice (Produtos produto, double novoPreco) {
        produto.setPreco(novoPreco);
        System.out.println("O preço do " + produto.getNome() + " foi atualizado para: R$ " + novoPreco) ;
    }


    public void stockReplenishment (Produtos produto, int replace) {
        System.out.println("Quantidade de produtos vendidos: " + produto.getQuantidadeVendida());
        produto.reposicao(produto.getQuantidadeEmEstoque(), replace);
        System.out.println("Quantida em estoque após a reposição: " + produto.getQuantidadeEmEstoque());
    }

    public void sellingRate (Produtos produto, double total) {

    }
}