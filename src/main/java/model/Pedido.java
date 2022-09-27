package model;


import java.util.Date;


public class Pedido {
    

    private Date data;
    private Integer numPedido;
    private Servico servico;
    private Cliente cliente;
    private String infoPedido;
	

	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getInfoPedido() {
		return infoPedido;
	}
	public void setInfoPedido(String infoPedido) {
		this.infoPedido = infoPedido;
	}
	public Integer getNumPedido() {
		return numPedido;
	}
	public void setNumPedido(Integer numPedido) {
		this.numPedido = numPedido;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    

                     
    
    
}
