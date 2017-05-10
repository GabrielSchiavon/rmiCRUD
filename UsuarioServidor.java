import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Gabriel H. Tasso Schiavon
 */
public class UsuarioServidor {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Gestor gestor = new Gestor();
        Naming.rebind("//localhost/CRUD", gestor);
    }
}
