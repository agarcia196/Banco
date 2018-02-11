package Banco;

public class Cuenta {
	//Atributos
	private int Ncuenta;
	private boolean estado;
	private float saldo;
	private String t_cuenta;
	//Constructor
	public Cuenta(int ncuenta, boolean estado, float saldo, String t_cuenta) {
		super();
		Ncuenta = ncuenta;
		this.estado = estado;
		this.saldo = saldo;
		this.t_cuenta = t_cuenta;
	}
	
	//Getters and Setters
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getNcuenta() {
		return Ncuenta;
	}

	public void setNcuenta(int ncuenta) {
		Ncuenta = ncuenta;
	}

	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	public String getT_cuenta() {
		return t_cuenta;
	}
	public void setT_cuenta(String t_cuenta) {
		this.t_cuenta = t_cuenta;
	}

	/* Metodo que deposita un valor comprueba que el valor a
	 * depositar es positivo. si no lo es eleva una excepcion de
	 * tipo EvalorNegativo*/
	public void depositar(float v) throws EValorNegativo,CuentaInactiva{
		if(estado) {
		if(v>0)
			saldo+=v;
		else
			throw new EValorNegativo();}
		else 
			throw new CuentaInactiva();
	} 
	//Metodo para extraer dinero de una cuenta y sus respectivas excepciones 
	public void extraer (float v) throws EValorNegativo,EValorMayorSaldo,CuentaInactiva{
		if(estado) {
		if(v>0) {
			if(v<=saldo)
				saldo-=v;
			else
				throw new EValorMayorSaldo();}
		else
			throw new EValorNegativo();}
		else 
			throw new CuentaInactiva();
	}
	public class EValorNegativo extends Exception {
		public EValorNegativo() {
			super("El valor es negativo");
		}
	}
	public class EValorMayorSaldo extends Exception {
		public EValorMayorSaldo() {
			super("El valor es mayor al disponible");
		}
	}
	public class CuentaInactiva extends Exception{
		public CuentaInactiva(){
			super("La cuenta esta inactiva");
		}
	}
}

