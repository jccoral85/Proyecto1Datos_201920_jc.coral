package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("---------ISIS 1206 - Estructuras de datos------------");
			System.out.println("----------------proyecto1-------------------");
			System.out.println("0. Cargar los datos del trimestre");
			
			System.out.println("1. Consultar el tiempo promedio de viaje y su desviaci�n est�ndar de los viajes entre una zona de origen y una zona destino para un d�a dado del mes.");
			System.out.println("2. Consultar la informaci�n de los N viajes con mayor tiempo promedio para un mes dado.");
			System.out.println("3. Comparar los tiempos promedios de los viajes para una zona dada de ida y vuelta para un mes dado");
			System.out.println("4. Consultar el tiempo promedio de viaje y su desviaci�n est�ndar de los viajes entre una zona de origen y una zona destino para un d�a dado de la semana");
			System.out.println("5. Consultar la informaci�n de los N viajes con mayor tiempo promedio para un d�a dado");
			System.out.println("6. Comparar los tiempos promedios de los viajes para una zona dada de ida y vuelta para un dia dado");
			System.out.println("7. Consultar los viajes entre una zona de origen y una zona destino en una franja horaria (hora inicial � hora final) dada");
			System.out.println("8. Consultar la informaci�n de los N viajes con mayor tiempo promedio para una hora dada");
			System.out.println("9. Generar una gr�fica ASCII que muestre el tiempo promedio de los viajes entre una zona origen y una zona destino para cada hora del d�a");
			
			System.out.println("10. Salir");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}
