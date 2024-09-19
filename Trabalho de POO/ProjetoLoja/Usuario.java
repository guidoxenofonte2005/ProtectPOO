package ProjetoLoja;

public abstract class Usuario {
    protected String nome;
    protected String email;

    public Usuario (String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public abstract void acessarSistema ();
}
