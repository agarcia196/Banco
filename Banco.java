package Banco;

import java.util.Arrays;

import Banco.Cuenta.EValorNegativo;
import Banco.Cuenta.EValorMayorSaldo;
import Banco.Cuenta.CuentaInactiva;

public class Banco {

	private  User [] usuarios;
	
	
	public User[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(User[] usuarios) {
		this.usuarios = usuarios;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Banco d =new Banco();
	
		d.crear_user(1234, "Alexis", "Av 45", 322555);
		d.crear_user(12345, "Ana", "Av 45", 322555);
		d.crear_user(55555, "Emma", "Av 45", 322555);
			d.usuarios[0].addCuenta("Ahorros",987,500);
			d.usuarios[1].addCuenta("Corriente",789,300);
			d.usuarios[1].addCuenta("Ahorros",7889,56);
			d.usuarios[2].addCuenta("Ahorros",788988,56);
			
			/*Cuenta d2 = d.Bcuenta_nc(789);
			int[]r=d.Bcuenta_ncint(7889);			
			System.out.print(r[0]+" "+r[1]);*/
			try {
			
			System.out.println(d.usuarios[0].getNombre());
			System.out.println(d.usuarios[0].getCuenta()[0].getSaldo());
			System.out.println(d.usuarios[1].getNombre());
			System.out.println(d.usuarios[1].getCuenta()[0].getSaldo());
			d.Transfer(987,1234, 789,12345,300);
			System.out.println(d.usuarios[0].getNombre());
			System.out.println(d.usuarios[0].getCuenta()[0].getSaldo());
			System.out.println(d.usuarios[1].getNombre());
			System.out.println(d.usuarios[1].getCuenta()[0].getSaldo());
			}
			catch (CuentasNoCoinciden e) {
				System.out.println("La cuenta no coincide con la cedula");
			}
			catch (usuarionoencontrado e) {
				System.out.println("Usuario no encontrado ");
			}
			catch (CuentaDesactivada e) {
				System.out.println("Usuario no encontrado ");
			}
			catch(EValorNegativo e){
				System.out.println("Se opera con valor negativo");
			}
			catch(EValorMayorSaldo e) {
				System.out.println("Se esta tratando de Transferir mas del saldo disponible");
			}
			catch(CuentaInactiva e) {
				System.out.println("Una cuenta no se encuentra activa");
			}
				/*System.out.println(d2.getT_cuenta());
				System.out.println(d2.getNcuenta());
				System.out.println(d2.getSaldo());*/
	}
	//Metodo para realizar Transferencias.
	public void Transfer(int c1,int cc1,int c2,int cc2,float v)throws CuentasNoCoinciden,usuarionoencontrado,EValorNegativo,EValorMayorSaldo,CuentaInactiva,CuentaDesactivada {
			int ccc1 =  Bcuenta_cc(cc1);
			int ccc2 =  Bcuenta_cc(cc2);
			Cuenta u1 = usuarios[ccc1].Bcuenta_nc(c1);
			Cuenta u2 = usuarios[ccc2].Bcuenta_nc(c2);
			if(u1==null || u2==null) 
				throw new CuentasNoCoinciden();
			else if (u1.isEstado()==false || u2.isEstado()==false) {
				throw new CuentaDesactivada();
			}
			else {
				u1.extraer(v);
				u2.depositar(v);
			}
		
	}
	// Metodo para Crear usuario nuevo.
	public void crear_user(int cedula, String nombre, String direccion, int telefono) {
		if(usuarios==null)
			usuarios=new User[1];
		else 
			usuarios=Arrays.copyOf(usuarios,usuarios.length+1);
		User u= new User(cedula,nombre,direccion,telefono);
		usuarios[usuarios.length-1]=u;
	}
	/* Metodo para busqueda de Usuario por medio del numero de Cedula, Imprime Nombre, Numero de cedula
	*Numero de cuanta y el saldo disponible de la cuenta.*/
	public  int Bcuenta_cc(int ndcc) throws usuarionoencontrado {
		int  i=0;
		while(i<usuarios.length && usuarios[i].getCedula()!=ndcc) {
			i++;
		}	
		if(i==usuarios.length)
			throw new usuarionoencontrado();
		else
			return i;
	}
	/* Metodo para busqueda de Usuario por medio del numero de cuenta, Imprime Nombre, Numero de cedula
	*Numero de cuanta y el saldo disponible de la cuenta.*/
	public Cuenta Bcuenta_nc(int ndcu) throws usuarionoencontrado{
		int  i=0;

		while(i<usuarios.length && usuarios[i].Bcuenta_nc(ndcu)==null)  {
			i++;
		}
		if(i==usuarios.length)
			throw new usuarionoencontrado();
		else {
			return usuarios[i].Bcuenta_nc(ndcu);
		}
	}
	//Metodo para buscar ID de cliente y ID de cuenta 
	public int[] Bcuenta_ncint(int ndcu) throws usuarionoencontrado{
		int  i=0;
		while(i<usuarios.length && usuarios[i].Bcuenta_ncint(ndcu)==-1)  {
			i++;
		}
		if(i==usuarios.length)
			throw new usuarionoencontrado();
		else {
			int a = usuarios[i].Bcuenta_ncint(ndcu);
			int[]e = {i, a};
			return e;
		}
	}
	// Exceptions
	public class usuarionoencontrado extends Exception{
		public usuarionoencontrado() {
			super("La cuenta no fue encontrada");
		}
	}
	public class CuentasNoCoinciden extends Exception{
		public CuentasNoCoinciden() {
			super("La cuenta no coincide con la cedula");
		}
		
	}
	public class CuentaDesactivada extends Exception{
		public CuentaDesactivada() {
			super("Una de las cuentas no esta activa");
		}
		
	}
	
}

