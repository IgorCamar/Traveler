package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ServicoDAO {

	public void save (Servico Servico) {
		String sql = "INSERT INTO servico(valorServico,tipoServico,descricao)" + "VALUES(?,?,?)";
		
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setDouble(1, Servico.getValor());
			pstm.setString(2, Servico.getTipoServico());
			pstm.setString(3, Servico.getDescricao());

			
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
	
	public void removeById (int idServico) {
		String sql = "DELETE FROM servico WHERE codServico = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt (1, idServico);
			
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

	public void update(Servico Servico) {
		
		String sql = "UPDATE servico SET valorServico = ?,tipoServico = ?,descricao = ?"+
		"WHERE codServico = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = Conexao.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setDouble(1, Servico.getValor());
			pstm.setString(2, Servico.getTipoServico());
			pstm.setString(3, Servico.getDescricao());

			
			//Qual o ID do registro que deseja atualizar?
			pstm.setInt(4, Servico.getIdServico());
			
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

	public List<Servico> getServicos() {
		String sql = "SELECT * FROM servico";

		List<Servico> servicos = new ArrayList<Servico>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Servico servico = new Servico();
				
				servico.setValor(rset.getDouble("cpf"));
				servico.setTipoServico(rset.getString("tipoServico"));
				servico.setDescricao(rset.getString("descricao"));

				
				servicos.add(servico);
			
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
			
			return servicos;
	}



}