import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Gabriel H. Tasso Schiavon
 */
public class Retorno implements Serializable{
    private List<Usuario> lista;
    private String mensagem;
    
    public Retorno() {
        lista = null;
        mensagem = "";
    }
    
    public Retorno(List<Usuario> lista, String mensagem) {
        this.lista = lista;
        this.mensagem = mensagem;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
