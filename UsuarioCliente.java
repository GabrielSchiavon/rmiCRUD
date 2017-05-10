import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel H. Tasso Schiavon
 */
public class UsuarioCliente {
    private static boolean possuiCpf(String cpf, List<Usuario> lista) {
        return lista.stream().anyMatch((i) -> (i.getCpf().equals(cpf)));
    }
    private static Retorno adicionarUsuario(CrudUsuario crud, List<Usuario> lista)
            throws RemoteException {
        Scanner sc = new Scanner(System.in);
        String nome, cpf;
        int idade;

        System.out.println("\n\n************************");
        System.out.println("*****  Adicionar  ******");
        System.out.println("************************");

        System.out.print("Nome: ");
        nome = sc.next();

        System.out.print("Idade: ");
        idade = sc.nextInt();

        System.out.print("CPF: ");
        cpf = sc.next();

        Usuario u = new Usuario(nome, idade, cpf);
        return crud.add(u, lista);
    }

    private static Retorno editarUsuario(CrudUsuario crud, List<Usuario> lista)
            throws RemoteException {
        Scanner sc = new Scanner(System.in);
        String nome, cpf;
        int idade;

        System.out.println("\n\n************************");
        System.out.println("*******  Editar  *******");
        System.out.println("************************");
        
        System.out.print("CPF: ");
        cpf = sc.next();

        while (!possuiCpf(cpf, lista)) {
            System.out.println("Cpf Nao encontrado ! Tente Novamente");
            System.out.print("CPF: ");
            cpf = sc.next();
        }

        System.out.print("Nome: ");
        nome = sc.next();

        System.out.print("Idade: ");
        idade = sc.nextInt();

        Usuario u = new Usuario(nome, idade, cpf);
        return crud.edita(u, lista);
    }

    private static Retorno removerUsuario(CrudUsuario crud, List<Usuario> lista) throws RemoteException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n\n************************");
        System.out.println("******  Remover  *******");
        System.out.println("************************");

        System.out.print("CPF: ");
        String cpf = sc.next();

        while (!possuiCpf(cpf, lista)) {
            System.out.println("Cpf Nao encontrado ! Tente Novamente");
            System.out.print("CPF: ");
            cpf = sc.next();
        }
        
        return crud.remove(cpf, lista);
    }
    
    private static void mostraMenu() {
        System.out.println("\n\n\n************************");
        System.out.println("********  MENU  ********");
        System.out.println("************************");
        System.out.println("**  1) Adicionar      **");
        System.out.println("**  2) Editar         **");
        System.out.println("**  3) Remover        **");
        System.out.println("**  4) Listar         **");
        System.out.println("**  0) Sair           **");
        System.out.println("************************");
        System.out.print("** Resp:");
    }

    public static void main(String[] args)
            throws NotBoundException, MalformedURLException, RemoteException {
        CrudUsuario crud = (CrudUsuario) Naming.lookup("//localhost/CRUD");
        Scanner sc = new Scanner(System.in);
        List<Usuario> listaUsuario = new LinkedList<>();

        int resp = 1;
        while (resp >= 1 && resp <= 4) {
            mostraMenu();
            resp = sc.nextInt();
            switch (resp) {
                case 1:
                    Retorno ret1 = adicionarUsuario(crud, listaUsuario);
                    listaUsuario = ret1.getLista();
                    System.out.println(ret1.getMensagem());
                    break;
                case 2:
                    Retorno ret2 = editarUsuario(crud, listaUsuario);
                    listaUsuario = ret2.getLista();
                    System.out.println(ret2.getMensagem());
                    break;
                case 3:
                    Retorno ret3 = removerUsuario(crud, listaUsuario);
                    listaUsuario = ret3.getLista();
                    System.out.println(ret3.getMensagem());
                    break;
                case 4:
                    System.out.println(crud.listar(listaUsuario));
                    break;
            }
        }
    }
}
