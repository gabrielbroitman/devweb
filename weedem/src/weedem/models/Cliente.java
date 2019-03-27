package weedem.models;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	
	public Cliente() {
		
	}
	
	public Cliente(int id) {
		super(id);
	}

	public Cliente(int id, String nome, String email, String cpf, String endereco) {
		super(id, nome, email, cpf, endereco);

		
	}


	
	

}
