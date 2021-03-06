package vendatapetes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Filipe de Freitas Martins da Silva - GRR20193884
 */
public class Controller {
    private static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
    private static HashMap<String, Pedido> pedidos = new HashMap<String, Pedido>();
    
    public static void incluirCliente(String nome, String sobrenome, String CPF){
        if(!(CPF.equals("")||nome.equals("")||sobrenome.equals(""))){
            Cliente c = new Cliente(nome, sobrenome, CPF);
            clientes.put(CPF, c);
        }
    }
    public static void atualizarCliente(String nome, String sobrenome, String CPF){
        if(!CPF.equals("")){
        Cliente alvo =clientes.get(CPF);
        if(nome == ""){
            nome = alvo.getNome();
        }
        if(sobrenome == ""){
            sobrenome = alvo.getSobrenome();
        }
        if(alvo!=null){
        alvo.Alterar(nome, sobrenome);
        clientes.put(CPF, alvo);
        }
        }
    }
    public static void removerCliente(String CPF){
        clientes.remove(CPF);
    }
    public static Object[] listarCliente(Object[] ClienteAlvo){
        ArrayList<Cliente> Busca= new ArrayList<Cliente>();
        if(ClienteAlvo.length>3){
        String busca=ClienteAlvo[0].toString();
        String nome=ClienteAlvo[1].toString();
        String sobrenome=ClienteAlvo[2].toString();
        String cpf=ClienteAlvo[3].toString();

        for(Map.Entry<String, Cliente> c: clientes.entrySet()){
            if((nome.equals("true")&& c.getValue().getNome().matches("(.*)"+busca+"(.*)"))
                    ||(sobrenome.equals("true")&& c.getValue().getSobrenome().matches("(.*)"+busca+"(.*)"))
                    ||(cpf.equals("true")&& c.getValue().getCPF().matches("(.*)"+busca+"(.*)"))){ 
                Busca.add(c.getValue());
            }
        }
        if(busca.isEmpty())
            return null;
        }
        return Busca.toArray();
    }
    
}
