package user.accessGranted;

public class Vendedor extends Usuario {
    public Vendedor(String nome, String email) {
        super(nome, email);
    }

    @Override
    protected void acessarSistema() {

    }
}
