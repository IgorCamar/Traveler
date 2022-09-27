package model;



public class Servico {

    private Integer idServico;
    private String descricao;
    private double valor;
    private String TipoServico;



	public String getTipoServico() {
		return TipoServico;
	}

	public void setTipoServico(String TipoServico) {
		this.TipoServico = TipoServico;
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


    
}
