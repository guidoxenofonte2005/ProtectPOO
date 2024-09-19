package ProjetoLoja;

import java.util.Arrays;
import java.util.List;

public class Loja {
    
    private List <Produtos> produto;

    public Loja (Produtos [] produtoArray) {
        this.produto = Arrays.asList(produtoArray);
    }

    public List <Produtos> geProdutos () {
        return produto;
    }
}
