package Astroak;

public interface intAstro {
	
	public double getMasa();
	
	public void setMasa(double masaBerria);
	
	public void setIzena(String izena);	
	
	public String getIzena();
	
	public Koordenatuak getDeGraduak();
	
	public void setDeGraduak(Koordenatuak deGraduak);
	
	public Koordenatuak getRaGraduak();
	
	public void setRaGraduak(Koordenatuak raGraduak);
	
	public Koordenatuak getDeMinutoak();
	
	public void setDeMinutoak(Koordenatuak deMinutoak);
	
	public Koordenatuak getRaMinutoak();
	
	public void setRaMinutoak(Koordenatuak raMinutoak);
	
}