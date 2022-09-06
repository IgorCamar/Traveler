import java.util.Date;

public class main {

	public static void main(String[] args) {

		ClienteDAO ClienteDAO = new ClienteDAO();

		// inserindo dados Cliente--------------------
		Cliente Cliente = new Cliente();
		//
		Cliente.setNome("null");
		Cliente.setCpf("null");
		Cliente.setEmail("null");
		Cliente.setFone(0);
		//
		ClienteDAO.save(Cliente);
		// deletando
		ClienteDAO.removeByCPF(null);
		// Visualização dos registros do banco de dados TODOS
		for (Cliente c : ClienteDAO.getClientes()) {
			System.out.println("Cliente: " + c.getCpf());
			System.out.println("Nome: " + c.getNome());
			System.out.println("----------------------------");
			}
			// inserindo dados Servico-------------------
			ServicoDAO ServicoDAO = new ServicoDAO();

			Servico Servico = new Servico();
			//
			Servico.setValor(0);
			Servico.setTipoServico("");
			Servico.setDescricao("");
			//
			ServicoDAO.save(Servico);
			// deletando
			ServicoDAO.removeById(0);
			// Visualização dos registros do banco de dados TODOS
			for (Servico s : ServicoDAO.getServicos()) {
				System.out.println("ID: " + s.getIdServico());
				System.out.println("ID: " + s.getValor());
				System.out.println("----------------------------");
				}
			// inserindo dados pedido----------------------
			PedidoDAO PedidoDAO = new PedidoDAO();

			//
			Pedido Pedido = new Pedido();
			//
			Pedido.setData(new Date());

			//
			PedidoDAO.save(Pedido);
			// deletando------------------------------
			PedidoDAO.removeById(0);
			// Visualização dos registros do banco de dados TODOS
			for (Pedido p : PedidoDAO.getPedidos()) {
				System.out.println("ID: " + p.getNumPedido());
				System.out.println("ID: " + p.getInfoPedido());
				System.out.println("----------------------------");
				}

		}

	}

