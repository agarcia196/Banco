package Banco;

import java.util.Arrays;

import Banco.Cuenta.EValorMayorSaldo;

public class User {
	//Atributos
	private int n_cuenta;
	private Cuenta []cuenta; 
	private int cedula;
	private String nombre;
	private String direccion;
	private int telefono;
	//Constructor
	public User(int cedula, String nombre, String direccion, int telefono) {
		super();
		cuenta=new Cuenta[0];
		this.cedula = cedula;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	//Getters and Setters
	public Cuenta[] getCuenta() {
		return cuenta;
	}
	public int getN_cuenta() {
		return n_cuenta;
	}
	public void setN_cuenta(int n_cuenta) {
		this.n_cuenta = n_cuenta;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getCedula() {
		return cedula;
	}
	public String getNombre() {
		return nombre;
	}
	//Metodo para agregar cuentas de usuario
	public void addCuenta(String tcuenta,int n,int saldon) {
		if(cuenta==null)
			cuenta=new Cuenta[1];
		else {
			///int n = (int) (Math.random()*10)+1*50;
			cuenta=Arrays.copyOf(cuenta,cuenta.length+1);
			Cuenta c = new Cuenta(n, true, saldon, tcuenta);
		    cuenta[cuenta.length-1]= c;
		    }
	}
	/* Metodo para busqueda de Usuario por medio del numero de cuenta, Imprime Nombre, Numero de cedula
	*Numero de cuanta y el saldo disponible de la cuenta.*/
	public Cuenta Bcuenta_nc(int ndcu){
		int  i=0;
		while(i<cuenta.length && cuenta[i].getNcuenta()!=ndcu) {
			i++;
		}
		if(i==cuenta.length)
			return null;
		else
			return cuenta[i];
	}
	//Metodo para buscar el Index de la cuenta de un usuario.
	public int Bcuenta_ncint(int ndcu) {
		int  i=0;
		while(i<cuenta.length && cuenta[i].getNcuenta()!=ndcu) {
			i++;
		}
		if(i==cuenta.length)
			return -1;
		else
			return i;
	}
	
}

