package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Cliente Cliente) {
		String sql = "INSERT INTO cliente(cpf,telefone,email,nome)" + "VALUES(?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, Cliente.getCpf());
			pstm.setInt(2, Cliente.getFone());
			pstm.setString(3, Cliente.getEmail());
			pstm.setString(4, Cliente.getNome());

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public void removeByCPF(String cpf) {
		String sql = "DELETE FROM cliente WHERE cpf = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cpf);

			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	public List<Cliente> getClientes() {
		String sql = "SELECT * FROM cliente";

		List<Cliente> clientes = new ArrayList<Cliente>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Cliente cliente = new Cliente();
				

				cliente.setCpf(rset.getString("cpf"));
				cliente.setFone(rset.getInt("telefone"));
				cliente.setEmail(rset.getString("email"));
				cliente.setNome(rset.getString("nome"));
				
				clientes.add(cliente);
			
			}}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if (rset!=null) {
						rset.close();
					}
					
					if (pstm!=null) {
						pstm.close();
					}
					
					if (conn!=null) {
						conn.close();
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			return clientes;
	}

	public void update(Cliente Cliente) {
		
		String sql = "UPDATE cliente SET cpf = ?,telefone = ?,email = ?,nome = ? "+
		"WHERE cpf = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = Conexao.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setString(1, Cliente.getCpf());
			pstm.setInt(2, Cliente.getFone());
			pstm.setString(3, Cliente.getEmail());
			pstm.setString(4, Cliente.getNome());
			
			//Qual o ID do registro que deseja atualizar?
			pstm.setString(5, Cliente.getCpf());
			
			//Executar a query
			pstm.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}




}


