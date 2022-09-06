import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ArrayList;
import java.util.List;

public class PedidoDAO {

	public void save (Pedido Pedido) {
		String sql = "INSERT INTO pedido(dataPedido,infoPedido)" + "VALUES(?,?)";
		
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setDate(1, new Date (Pedido.getData().getTime()));
			pstm.setString(2, Pedido.getInfoPedido());
			
			
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
	
	public void removeById (int numPedido) {
		String sql = "DELETE FROM pedido WHERE numPedido = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt (1, numPedido);
			
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

	public void update(Pedido Pedido) {
		
		String sql = "UPDATE pedido SET dataPedido = ?,infoPedido = ? "+
		"WHERE numPedido = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar conexão com o banco
			conn = Conexao.createConnectionToMySQL();
			
			//Criar a classe para executar a query
			pstm = conn.prepareStatement(sql);
			
			//Adicionar os valores para atualizar
			pstm.setDate(1, new Date (Pedido.getData().getTime()));
			pstm.setString(2, Pedido.getInfoPedido());
			//Qual o ID do registro que deseja atualizar?
			pstm.setInt(3, Pedido.getNumPedido());
			
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

	public List<Pedido> getPedido() {
		String sql = "SELECT * FROM pedido";

		List<Pedido> cliente = new ArrayList<Pedido>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;
		
		try {
			conn = Conexao.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Pedido pedido = new Pedido();
				
				Pedido.setData(rset.getDate("dataPedido"));
				Pedido.setInfoPedido(rset.getString("info"));

				
				pedido.add(pedido);
			
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
	
}