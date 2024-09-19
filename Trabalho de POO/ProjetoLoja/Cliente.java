package ProjetoLoja;

import java.util.List;

public class Cliente extends Usuario {

    public Cliente (String nome, String email) {
        super(nome, email);
    }

    public void acessarSistema () {
    }
    
    public void accessProducts (Loja loja) {
        List <Produtos> produto = loja.geProdutos();
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

    public void createAccount (Usuario infoUser) {
        
    }




    public void deleteAccount (Usuario infoUser) {
    }


}
