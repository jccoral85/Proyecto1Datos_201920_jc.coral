package controller;

import java.io.FileReader;
import java.util.Scanner;

import com.opencsv.CSVReader;

import jdk.nashorn.internal.runtime.ListAdapter;
import model.data_structures.Queue;
import model.logic.MVCModelo;
import model.logic.Viaje;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	private Queue<Viaje> viajesMes = new Queue<Viaje>();
	private Queue<Viaje> viajesSemana = new Queue<Viaje>();
	private Queue<Viaje> viajesHora = new Queue<Viaje>();


	public static final String file1 = "./docs/bogota-cadastral-2018-1-All-HourlyAggregate.csv";

	public static final String file2 = "./docs/bogota-cadastral-2018-1-All-MonthlyAggregate.csv";

	public static final String file3 = "./docs/bogota-cadastral-2018-1-WeeklyAggregate.csv";

	public static final String file4 = "./docs/bogota-cadastral-2018-2-All-HourlyAggregate.csv";

	public static final String file5 = "./docs/bogota-cadastral-2018-2-All-MonthlyAggregate.csv";

	public static final String file6 = "./docs/bogota-cadastral-2018-2-WeeklyAggregate.csv";

	public static final String file7 = "./docs/bogota-cadastral-2018-3-All-HourlyAggregate.csv";

	public static final String file8 = "./docs/bogota-cadastral-2018-3-All-MonthlyAggregate.csv";

	public static final String file9 = "./docs/bogota-cadastral-2018-3-WeeklyAggregate.csv";

	public static final String file10 = "./docs/bogota-cadastral-2018-4-All-HourlyAggregate.csv";

	public static final String file11 = "./docs/bogota-cadastral-2018-4-All-MonthlyAggregate.csv";

	public static final String file12 = "./docs/bogota-cadastral-2018-4-WeeklyAggregate.csv";

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}

	public int darTotalMes() {
		Queue <Viaje> t = viajesMes;
		return t.size();
	}
	public int darTotalSemana() {
		Queue <Viaje> t = viajesSemana;
		return t.size();
	}
	public int darTotalHora() {
		Queue <Viaje> t = viajesHora;
		return t.size();
	}

	public void load(String pArchivo, Queue pCola) {
		CSVReader reader;

		try {
			reader = new CSVReader(new FileReader(pArchivo));
			String [] nextLine = new String[7];
			nextLine = reader.readNext();
			while ((nextLine = reader.readNext())!=null)
			{
				Viaje nuevo = new Viaje(Integer.parseInt(nextLine[0]), Integer.parseInt(nextLine[1]), Integer.parseInt(nextLine[2]), Double.parseDouble(nextLine[3]), Double.parseDouble(nextLine[4]), Double.parseDouble(nextLine[5]), Double.parseDouble(nextLine[6]));
				pCola.enqueue(nuevo);
			}
			reader.close();

		} catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public int darMenorID()
	{
		Viaje viaje = null;
		Viaje menor = null;
		for (Viaje viajeHoras: viajesHora) {

			if(viaje != null)
			{
				if(viaje.getDstid()>viajeHoras.getDstid())
				{
					viaje = viajeHoras;
				}
				if(menor.getSourceid()>viajeHoras.getSourceid())
				{
					menor = viajeHoras;
				}
			}
			else
			{
				viaje = viajeHoras;
				menor = viajeHoras;
			}

		}
		for (Viaje viajeSemana: viajesSemana) {

			if(viaje != null)
			{
				if(viaje.getDstid()>viajeSemana.getDstid())
				{
					viaje = viajeSemana;
				}
				if(menor.getSourceid()>viajeSemana.getSourceid())
				{
					menor = viajeSemana;
				}
			}
			else
			{
				viaje = viajeSemana;
				menor = viajeSemana;
			}

		}
		for (Viaje viajeMes: viajesMes) {

			if(viaje != null)
			{
				if(viaje.getDstid()>viajeMes.getDstid())
				{
					viaje = viajeMes;
				}
				if(menor.getSourceid()>viajeMes.getSourceid())
				{
					menor = viajeMes;
				}
			}
			else
			{
				viaje = viajeMes;
				menor = viajeMes;
			}

		}
		if(menor.getSourceid() < viaje.getDstid())
		{
			return menor.getSourceid();
		}
		else
		{
			return viaje.getDstid();
		}
		
		
	}

	public int darMayorID() {
		
		Viaje viaje = null;
		Viaje mayor = null;
		for (Viaje viajeHoras: viajesHora) {

			if(viaje != null)
			{
				if(viaje.getDstid()<viajeHoras.getDstid())
				{
					viaje = viajeHoras;
				}
				if(mayor.getSourceid()<viajeHoras.getSourceid())
				{
					mayor = viajeHoras;
				}
			}
			else
			{
				viaje = viajeHoras;
				mayor = viajeHoras;
			}

		}
		for (Viaje viajeSemana: viajesSemana) {

			if(viaje != null)
			{
				if(viaje.getDstid()<viajeSemana.getDstid())
				{
					viaje = viajeSemana;
				}
				if(mayor.getSourceid()<viajeSemana.getSourceid())
				{
					mayor = viajeSemana;
				}
			}
			else
			{
				viaje = viajeSemana;
				mayor = viajeSemana;
			}

		}
		for (Viaje viajeMes: viajesMes) {

			if(viaje != null)
			{
				if(viaje.getDstid()<viajeMes.getDstid())
				{
					viaje = viajeMes;
				}
				if(mayor.getSourceid()<viajeMes.getSourceid())
				{
					mayor = viajeMes;
				}
			}
			else
			{
				viaje = viajeMes;
				mayor = viajeMes;
			}

		}
		if(mayor.getSourceid() > viaje.getDstid())
		{
			return mayor.getSourceid();
		}
		else
		{
			return viaje.getDstid();
		}

	}
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){

			case 0:
				view.printMessage("Ingrese el trimestre que quiere (1, 2, 3, 4)");
				int trimestre = lector.nextInt();

				if(trimestre == 1)
				{
					this.load(file1, viajesHora);
					this.load(file2, viajesMes);
					this.load(file3, viajesSemana);
					System.out.println("La cantidad de viajes leídos por mes es: " + darTotalMes());
					System.out.println("La cantidad de viajes leídos por hora es: " + darTotalHora());
					System.out.println("La cantidad de viajes leidos por semana es: " + darTotalSemana());
					System.out.println("La zona con menor identificador es: " + darMenorID());
					System.out.println("La zona con mayor identificador es: " + darMayorID());
				}
				if(trimestre == 2)
				{
					this.load(file4, viajesHora);
					this.load(file5, viajesMes);
					this.load(file6, viajesSemana);
					System.out.println("La cantidad de viajes leídos por mes es: " + darTotalMes());
					System.out.println("La cantidad de viajes leídos por hora es: " + darTotalHora());
					System.out.println("La cantidad de viajes leidos por semana es: " + darTotalSemana());
					System.out.println("La zona con menor identificador es: " + darMenorID());
					System.out.println("La zona con mayor identificador es: " + darMayorID());
					
				}

				if(trimestre == 3)
				{
					this.load(file7, viajesHora);
					this.load(file8, viajesMes);
					this.load(file9, viajesSemana);
					System.out.println("La cantidad de viajes leídos por mes es: " + darTotalMes());
					System.out.println("La cantidad de viajes leídos por hora es: " + darTotalHora());
					System.out.println("La cantidad de viajes leidos por semana es: " + darTotalSemana());
					System.out.println("La zona con menor identificador es: " + darMenorID());
					System.out.println("La zona con mayor identificador es: " + darMayorID());
				}

				if(trimestre == 4)
				{
					this.load(file10, viajesHora);
					this.load(file11, viajesMes);
					this.load(file12, viajesSemana);
					System.out.println("La cantidad de viajes leídos por mes es: " + darTotalMes());
					System.out.println("La cantidad de viajes leídos por hora es: " + darTotalHora());
					System.out.println("La cantidad de viajes leidos por semana es: " + darTotalSemana());
					System.out.println("La zona con menor identificador es: " + darMenorID());
					System.out.println("La zona con mayor identificador es: " + darMayorID());
				}
				break;
			}



			//				case 1:
			//					System.out.println("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
			//				    int capacidad = lector.nextInt();
			//				    modelo = new MVCModelo(capacidad); 
			//					System.out.println("Arreglo Dinamico creado");
			//					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
			//					break;
			//
			//				case 2:
			//					System.out.println("--------- \nDar cadena (simple) a ingresar: ");
			//					dato = lector.next();
			//					modelo.agregar(dato);
			//					System.out.println("Dato agregado");
			//					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
			//					break;
			//
			//				case 3:
			//					System.out.println("--------- \nDar cadena (simple) a buscar: ");
			//					dato = lector.next();
			//					respuesta = modelo.buscar(dato);
			//					if ( respuesta != null)
			//					{
			//						System.out.println("Dato encontrado: "+ respuesta);
			//					}
			//					else
			//					{
			//						System.out.println("Dato NO encontrado");
			//					}
			//					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
			//					break;
			//
			//				case 4:
			//					System.out.println("--------- \nDar cadena (simple) a eliminar: ");
			//					dato = lector.next();
			//					respuesta = modelo.eliminar(dato);
			//					if ( respuesta != null)
			//					{
			//						System.out.println("Dato eliminado "+ respuesta);
			//					}
			//					else
			//					{
			//						System.out.println("Dato NO eliminado");							
			//					}
			//					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
			//					break;
			//
			//				case 5: 
			//					System.out.println("--------- \nContenido del Arreglo: ");
			//					view.printModelo(modelo);
			//					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
			//					break;	
			//					
			//				case 6: 
			//					System.out.println("--------- \n Hasta pronto !! \n---------"); 
			//					lector.close();
			//					fin = true;
			//					break;	

			//				default: 
			//					System.out.println("--------- \n Opcion Invalida !! \n---------");
			//					break;
			//			}
		}
	}
}



