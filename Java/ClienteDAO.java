
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ArrayList;
import java.util.List;
import java.sql.*;

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

	public List<Cliente> getCliente() {
		String sql = "SELECT * FROM cliente";

		List<Cliente> cliente = new ArrayList<Cliente>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Cliente cliente = new Cliente();
				

				Cliente.setCpf(rset.getString("cpf"));
				Cliente.setFone(rset.getInt("telefone"));
				Cliente.setEmail(rset.getString("email"));
				Cliente.setNome(rset.getString("nome"));
				
				cliente.add(cliente);
			
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
			
			return cliente;
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


