import java.util.List;

import store.Produtos;
import store.Loja;
import user.accessGranted.Gerente;
import user.accessGranted.Vendedor;
import user.client.Cliente;

public class CRUD {
    public List<Produtos> produtos;
    public List<Gerente> gerentes;
    public List<Vendedor> vendedores;
    public List<Cliente> clientes;
    public Loja loja;
}
