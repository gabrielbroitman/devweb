package weedem.usuario.controller;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import weedem.models.Venda;
import weedem.venda.dao.VendaDAO;

@ManagedBean
public class VendaDetalheBean {

	@Inject
	private Venda venda;

	private boolean falha = false;
	private boolean sucesso = false;

	private VendaDAO vendaDAO = new VendaDAO();

	public void finalizarCompra() {

		if (venda == null && venda.getItens().isEmpty()) {
			this.falha = true;
			return;
		}

		try {
			this.vendaDAO.Inserir(this.venda);
			this.sucesso = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean getSucesso() {
		return this.sucesso;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public boolean isFalha() {
		return falha;
	}

	public void setFalha(boolean falha) {
		this.falha = falha;
	}

}
