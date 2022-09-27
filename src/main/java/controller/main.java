package controller;


import java.util.Date;

import model.*;


public class main {

	public static void main(String[] args) {

		ClienteDAO ClienteDAO = new ClienteDAO();

		// inserindo dados Cliente--------------------
		Cliente Cliente = new Cliente();
//		//
		  Cliente.setNome("igor"); 
		  Cliente.setCpf("854477"); 
		  Cliente.setEmail("igorcamaras");
		  Cliente.setFone(89102255);
	 
//		
		  ClienteDAO.save(Cliente);
		// atualizando dados
		// Atualizar
//				Cliente cl1 = new Cliente();
//				cl1.setNome("breno");
//				cl1.setCpf("6847813");
//				cl1.setEmail("jeansilvera@g");
//				cl1.setFone(88812070);
//				
//				//UPDATE
//				ClienteDAO.update(cl1);
		// deletando
//				ClienteDAO.removeByCPF("null");
//		// Visualização dos registros do banco de dados TODOS
//		for (Cliente c : ClienteDAO.getClientes()) {
//			System.out.println("Cliente: " + c.getCpf());
//			System.out.println("Nome: " + c.getNome());
//			System.out.println("----------------------------");
//			}
//			// inserindo dados Servico-------------------
//			ServicoDAO ServicoDAO = new ServicoDAO();
//
//			Servico Servico = new Servico();
//			//
//			Servico.setValor(0);
//			Servico.setTipoServico("");
//			Servico.setDescricao("");
//			//
//			ServicoDAO.save(Servico);
		// Atualizar
//				Servico sv1 = new Servico();
//				sv1.setIdServico(null);
//				sv1.setValor(0);
//				sv1.setTipoServico("null");
//				sv1.setDescricao("null");

		// UPDATE
//				ServicoDAO.update(sv1);
//			// deletando
//			ServicoDAO.removeById(0);
//			// Visualização dos registros do banco de dados TODOS
//			for (Servico s : ServicoDAO.getServicos()) {
//				System.out.println("ID: " + s.getIdServico());
//				System.out.println("ID: " + s.getValor());
//				System.out.println("----------------------------");
//				}
//			// inserindo dados pedido----------------------
//			PedidoDAO PedidoDAO = new PedidoDAO();
//
//			//
//			Pedido Pedido = new Pedido();
//			//
//			Pedido.setData(new Date());
//
//			//
//			PedidoDAO.save(Pedido);
		// Atualizar
//			Pedido pd1 = new Pedido();
//			pd1.setNumPedido(null);
//			pd1.setInfoPedido("null");
//			pd1.setData(new Date());
//			
//			//UPDATE
//			PedidoDAO.update(pd1);
//			// deletando------------------------------
//			PedidoDAO.removeById(0);
//			// Visualização dos registros do banco de dados TODOS
//			for (Pedido p : PedidoDAO.getPedidos()) {
//				System.out.println("ID: " + p.getNumPedido());
//				System.out.println("ID: " + p.getInfoPedido());
//				System.out.println("----------------------------");
//				}

	}

}
