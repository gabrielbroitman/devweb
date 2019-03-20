package weedem.models;

public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + matriculaCliente;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (matriculaCliente != other.matriculaCliente)
			return false;
		return true;
	}

	private int matriculaCliente;
	
	public Cliente() {
		
	}

	public Cliente(int id, String nome, String email, String cpf, int matriculaCliente, Endereco endereco) {
		super(id, nome, email, cpf, endereco);
		setMatriculaCliente(matriculaCliente);
		
	}

	public int getMatriculaCliente() {
		return matriculaCliente;
	}

	public void setMatriculaCliente(int matriculaCliente) {
		this.matriculaCliente = matriculaCliente;
	}
	
	

}
