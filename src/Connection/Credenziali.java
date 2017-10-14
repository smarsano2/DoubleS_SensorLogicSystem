package Connection;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="credenziali")
public class Credenziali implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1028363806920303381L;
	@Id
	@Column(name="id")
	private Integer id;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="permesso")
	private char permesso;
	
	public Credenziali(){
		
	}
	
	public Credenziali(String email, String password, char permesso){
		this.email=email;
		this.password=password;
		this.permesso=permesso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getPermesso() {
		return permesso;
	}

	public void setPermesso(char permesso) {
		this.permesso = permesso;
	}

	@Override
	public String toString() {
		return "Credenziali [id=" + id + ", email=" + email + ", password=" + password + ", permesso=" + permesso + "]";
	}
}
