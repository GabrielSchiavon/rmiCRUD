import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Gabriel H. Tasso Schiavon
 */
public interface CrudUsuario extends Remote{
    public Retorno add(Usuario u, List<Usuario> lista) throws RemoteException;
    public Retorno remove(String cpf, List<Usuario> lista) throws RemoteException;
    public Retorno edita(Usuario u, List<Usuario> lista) throws RemoteException;
    public String listar(List<Usuario> lista) throws RemoteException;
}
