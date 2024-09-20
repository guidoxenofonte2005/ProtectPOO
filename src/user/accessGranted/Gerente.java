package user.accessGranted;

import user.accessGranted.Usuario;

public class Gerente extends Usuario {

    public Gerente(String nome, String email) {
        super(nome, email);
    }

    @Override
    protected void acessarSistema() {

    }
}
