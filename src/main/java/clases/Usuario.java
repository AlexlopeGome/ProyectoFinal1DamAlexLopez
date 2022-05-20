package clases;

import java.util.Date;

public class Usuario extends EntidadConNombre {
	
	private String apellidos;
	private Date fechaNacimiento;
	private int contrenia;
	private String direccion;
	private String correo;
	private byte numehijos;
	private String nick;
	

	public Usuario(String nombre, String apellidos, Date fechaNacimiento, int contrenia, String direccion,
			String correo, byte numehijos,String nick) {
		super(nombre);
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.contrenia = contrenia;
		this.direccion = direccion;
		this.correo = correo;
		this.numehijos = numehijos;
		this.nick=nick;
	}

	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getContrenia() {
		return contrenia;
	}
	public void setContrenia(int contrenia) {
		this.contrenia = contrenia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public byte getNumehijos() {
		return numehijos;
	}
	public void setNumehijos(byte numehijos) {
		this.numehijos = numehijos;
		
	}
	

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "Usuario [apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", contrenia=" + contrenia
				+ ", direccion=" + direccion + ", correo=" + correo + ", numehijos=" + numehijos + ",nick= "+nick +"]";
	}
	
	
	
	
}
