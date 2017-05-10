import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Gabriel H. Tasso Schiavon
 */
public class Gestor extends UnicastRemoteObject implements CrudUsuario{
    protected Gestor() throws RemoteException {
        super();
    }
    
    private static final long serialVersionUID = 1L;

    @Override
    public Retorno add(Usuario u, List<Usuario> lista) throws RemoteException {
        String mensagem = "usuario Inserido com sucesso ! \nDados:\n\tNome: "+
                u.getNome()+"\n\tIdade: "+u.getIdade()+"\n\tCPF: "+u.getCpf();
        lista.add(u);
        
        Retorno ret = new Retorno(lista, mensagem);
        return ret;
    }

    @Override
    public Retorno remove(String cpf, List<Usuario> lista) throws RemoteException {
    	String mensagem = "Usuario nao encontrado!";
    	int index = -1;
    	for (int i = 0; i < lista.size(); i++) {
    		if (lista.get(i).getCpf().equals(cpf)) {
    			index = i;
    			break;
    		}
    	}

    	if (index != -1){
    		lista.remove(index);
    		mensagem = "Usuario removido com sucesso!";
    	}

        return new Retorno(lista,mensagem);
    }

    @Override
    public Retorno edita(Usuario u, List<Usuario> lista) throws RemoteException {
        String mensagem = "";
        for(Usuario i : lista) {
            if (i.getCpf().equals(u.getCpf())) {
                if (!(i.getNome().equals(u.getNome()))){
                    mensagem += "Nome alterado de "+i.getNome()+" para "+u.getNome()+"\n";
                    i.setNome(u.getNome());
                }
                if (i.getIdade()!= u.getIdade()) {
                    mensagem += "Idade alterada de "+i.getIdade()+" para "+u.getIdade()+"\n";
                    i.setIdade(u.getIdade());
                }
                break;
            }
        }
        Retorno ret = new Retorno(lista, mensagem);
        return ret;
    }

    @Override
    public String listar(List<Usuario> lista) throws RemoteException {
        String listaNome = "Lista: ";
        for(Usuario nome : lista) {
        	listaNome += nome.getNome();
            listaNome += " -> ";
        }
        listaNome += "null";
        return listaNome;
    }
}