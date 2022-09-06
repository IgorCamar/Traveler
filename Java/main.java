import java.util.Date;


public class main {

	public static void main(String[] args) {
		
		
	ClienteDAO  ClienteDAO = new ClienteDAO();
	
	
		//inserindo dados Cliente--------------------
		Cliente Cliente = new Cliente();
		//
		Cliente.setNome("null");
		Cliente.setCpf("null");
		Cliente.setEmail("null");
		Cliente.setFone(0);
		//
		ClienteDAO.save(Cliente);
		//deletando
		ClienteDAO.removeByCPF(null);
		
		//inserindo dados Servico-------------------
	ServicoDAO  ServicoDAO = new ServicoDAO();
	
		Servico Servico = new Servico();
		//
		Servico.setValor(0);
		Servico.setTipoServico("");
		Servico.setDescricao("");
		//
		ServicoDAO.save(Servico);
		//deletando
		ServicoDAO.removeById(0);
		
		//inserindo dados pedido----------------------
	PedidoDAO PedidoDAO = new PedidoDAO();
	
		//
		Pedido Pedido = new Pedido();
		//
		Pedido.setData(new Date());
		
		//
		PedidoDAO.save(Pedido);
		//deletando------------------------------
		PedidoDAO.removeById(0);
		//
		
		
		
	}

}
