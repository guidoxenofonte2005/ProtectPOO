package user.client;

import java.util.List;
import user.accessGranted.Usuario;
import store.Loja;
import store.Produtos;

public class Cliente extends Usuario {

    public Cliente (String nome, String email) {
        super(nome, email);
    }

    @Override
    protected void acessarSistema() {
        // não acessa
    }
    
    public void accessProducts (Loja loja) {
        List<Produtos> produto = loja.getProdutos();
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
