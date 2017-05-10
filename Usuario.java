import java.io.Serializable;

/**
 *
 * @author Gabriel H. Tasso Schiavon
 */
public class Usuario implements Serializable{
    private String nome;
    private int idade;
    private String cpf;
    
    public Usuario() {
        cpf = "";
    }
    
    public Usuario(String nome, int idade, String cpf) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}