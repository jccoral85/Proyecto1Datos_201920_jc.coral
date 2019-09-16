package model.logic;

public class Viaje {
	private int  sourceid;

	private int dstid;

	private int hod;

	private double tiempo;

	private double desviacion;

	private double tiempoGeometrico;

	private double desviacionGeometrica;

	public int getSourceid() {
		return sourceid;
	}

	public Viaje(int sourceid, int dstid, int hod, double tiempo, double desviacion, double tiempoGeometrico,
			double desviacionGeometrica) {
		this.sourceid = sourceid;
		this.dstid = dstid;
		this.hod = hod;
		this.tiempo = tiempo;
		this.desviacion = desviacion;
		this.tiempoGeometrico = tiempoGeometrico;
		this.desviacionGeometrica = desviacionGeometrica;
	}

	public int getDstid() {
		return dstid;
	}



	public int getHod() {
		return hod;
	}


	public double getTiempo() {
		return tiempo;
	}



	public double getDesviacion() {
		return desviacion;
	}



	public double getTiempoGeometrico() {
		return tiempoGeometrico;
	}



	public double getDesviacionGeometrica() {
		return desviacionGeometrica;
	}






}
