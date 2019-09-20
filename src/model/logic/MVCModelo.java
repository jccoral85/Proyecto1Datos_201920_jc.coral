package model.logic;

import java.util.Comparator;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.Queue;
import model.data_structures.MergeBU;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	
	private MergeBU ordenar;
	
	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		datos = new ArregloDinamico(7);
	}
	
	/**
	 * Constructor del modelo del mundo con capacidad dada
	 * @param tamano
	 */
	public MVCModelo(int capacidad)
	{
		datos = new ArregloDinamico(capacidad);
	}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}
	
	public double darPromedioTiempo(int pOrigen, int pDestino, int pMes, Queue<Viaje> vM)
	{
		double prom = 0;
		
		for(Viaje viaje : vM)
		{
			if(viaje.getHod() ==  pMes && viaje.getSourceid() == pOrigen && viaje.getDstid() == pDestino)
			{
				prom = viaje.getTiempo();
			}
		}
		
		return prom;
		
	}
	
	public double darDesviacion(int pOrigen, int pDestino, int pMes, Queue<Viaje> vM)
	{
		double desv = 0;
	
		for(Viaje viaje : vM)
		{
			if(viaje.getHod() ==  pMes && viaje.getSourceid() == pOrigen && viaje.getDstid() == pDestino)
			{
				desv = viaje.getDesviacion();
			}
		}
		
		return desv;
		
	}
	
	public Queue<Viaje> darViajesPedidos(int pP, Queue<Viaje> vM)
	{
		Queue<Viaje> viajes = new Queue <Viaje>();
		
		Queue<Viaje> au = vM;
		int tamano = au.size();
		for(int i=0;i<tamano;i++)
		{
			Viaje viaje = au.dequeue();
			if(viaje.getHod()==pP)
			{
				viajes.enqueue(viaje);
			}
		}
		
		return viajes;
	}
	
	public Queue<Viaje> darViajesOrdenados(int pN, Viaje [] vM)
	{
		ordenar.sort(vM);

		Queue<Viaje> viajes = new Queue<Viaje> ();
		

		for(int i = vM.length-1; i > vM.length-pN-1; i-- )
		{
			System.out.println(vM[i].getTiempo());
			viajes.enqueue(vM[i]);
		}
		
		return viajes;
	}
	
	public Viaje[] arreglo(Queue<Viaje> cola) {
		
		Viaje [] arreglo = new Viaje[cola.size()];
		
		for(int i = 0; i < cola.size(); i++)
		{
			arreglo[i] = cola.dequeue();
		}
		
		return arreglo;
	}
	


	
}
