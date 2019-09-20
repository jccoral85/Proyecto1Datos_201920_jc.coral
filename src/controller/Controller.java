package controller;

import java.io.FileReader;
import java.util.ArrayList;
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
			



			case 1:
				
				view.printMessage("Ingrese el origen que quiere.");
				int origen = lector.nextInt();
				view.printMessage("Ingrese el destino que quiere.");
				int destino = lector.nextInt();
				view.printMessage("Ingrese el mes que quiere.");
				int mes = lector.nextInt();
				
				double promedio = modelo.darPromedioTiempo(origen, destino, mes, viajesMes);
				double desv = modelo.darDesviacion(origen, destino, mes, viajesMes);
				
				if(promedio == 0 || desv == 0)
				{
					System.out.println("No existe informacion sobre ese viaje y mes en este trimestre.");
				}
				
				else
				{
					System.out.println("El tiempo promedio de viaje es: " + promedio + "segundos con una desviacion estandar de " + desv + "." );
				}
				break;
				
			case 2:
				view.printMessage("Ingrese el mes que quiere.");
				int mes2 = lector.nextInt();
				view.printMessage("Ingrese el numero de viajes que quiere ver");
				int n = lector.nextInt();
				
				Queue<Viaje> viajes = viajesMes;
				Queue <Viaje> r = new Queue<Viaje>();
				Queue <Viaje> p = modelo.darViajesPedidos(mes2, viajes);
				Viaje [] a = modelo.arreglo(p);
				Queue <Viaje> o = modelo.darViajesOrdenados(n, a);
				Viaje check = o.dequeue();
				for(int i = 0; i < o.size();i++)
				{
					Viaje res = o.dequeue();
					System.out.println(check);
					System.out.println("zona origen: " + res.getSourceid()+", zona destino: " + res.getDstid() + ", tiempo promedio: " + res.getTiempo() + ", desviacion estandar: " + res.getDesviacion());
				}
				break;
				
			case 3:
				
			case 4:
				view.printMessage("Ingrese el origen que quiere.");
				int origin = lector.nextInt();
				view.printMessage("Ingrese el destino que quiere.");
				int dest = lector.nextInt();
				view.printMessage("Ingrese el dia de la semana que quiere.");
				int dia = lector.nextInt();
				
				double promedio1 = modelo.darPromedioTiempo(origin, dest, dia, viajesSemana);
				double desv1 = modelo.darDesviacion(origin, dest, dia, viajesSemana);
				
				if(promedio1 == 0 || desv1 == 0)
				{
					System.out.println("No existe informacion sobre ese viaje y dia en este trimestre.");
				}
				
				else
				{
					System.out.println("El tiempo promedio de viaje es: " + promedio1 + "segundos con una desviacion estandar de " + desv1 + "." );
				}
				break;
				
			case 5:
				view.printMessage("Ingrese el dia que quiere.");
				int dia1 = lector.nextInt();
				view.printMessage("Ingrese el numero de viajes que quiere ver");
				int n1 = lector.nextInt();
				
				Queue<Viaje> viajes1 = viajesMes;
				Queue <Viaje> r1 = new Queue<Viaje>();
				Queue <Viaje> p1 = modelo.darViajesPedidos(dia1, viajes1);
				Viaje [] a1 = modelo.arreglo(p1);
				Queue <Viaje> o1 = modelo.darViajesOrdenados(n1, a1);
				for(int i = 0; i < o1.size();i++)
				{
					Viaje res = o1.dequeue();
					
					System.out.println("zona origen: " + res.getSourceid()+", zona destino: " + res.getDstid() + ", tiempo promedio: " + res.getTiempo() + ", desviacion estandar: " + res.getDesviacion());
				}
				break;
			
		}
	}
}

	}



