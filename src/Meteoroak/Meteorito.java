package Meteoroak;

import java.time.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The Class Meteorito.
 */
public class Meteorito {

	/** The izena. */
	// Atributuoak definitu
	private String izena;
	
	/** The masa. */
	private double masa;
	
	/** The Konposizioa. */
	private String Konposizioa;
	
	/** The data aktibitate. */
	private LocalDate dataAktibitate;
	
	/** The ra graduak. */
	//Zeruko posizioa ateratzeko aldagaiak
    private double raGraduak;
    
    /** The ra minutoak. */
    private double raMinutoak;
    
    /** The de graduak. */
    private double deGraduak;
    
    /** The de minutoak. */
    private double deMinutoak;
	
	//Klase eraikitzaileak	
	
	/**
	 * Instantiates a new meteorito.
	 *
	 * @param aldatuMasa the aldatu masa
	 */
	
	/**
	 * Instantiates a new meteorito.
	 *
	 * @param izena the izena
	 * @param masa the masa
	 * @param dataAktibitate the data aktibitate
	 * @param Konposizioa the konposizioa
	 * @param raGraduak the ra graduak
	 * @param raMinutoak the ra minutoak
	 * @param deGraduak the de graduak
	 * @param deMinutoak the de minutoak
	 */
	Meteorito(String izena, double masa, LocalDate dataAktibitate, String Konposizioa, double raGraduak,
			double raMinutoak, double deGraduak, double deMinutoak)
	{
		this.izena 			= izena;
		this.masa			= masa;
		this.dataAktibitate = dataAktibitate;
		this.Konposizioa 	= Konposizioa;
		this.raGraduak 		= raGraduak;
		this.raMinutoak 	= raMinutoak;
		this.deGraduak 		= deGraduak;
		this.deMinutoak 	= deMinutoak;
		
	}
	
	/**
	 * Gets the izena.
	 *
	 * @return the izena
	 */
	// Metodoak
	public String getIzena() {
		return izena;
	}
	
	/**
	 * Sets the izena.
	 *
	 * @param izena the new izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}
	
	/**
	 * Gets the konposizioa.
	 *
	 * @return the konposizioa
	 */
	public String getKonposizioa() {
		return Konposizioa;
	}
	
	/**
	 * Sets the konposizioa.
	 *
	 * @param konposizioa the new konposizioa
	 */
	public void setKonposizioa(String konposizioa) {
		Konposizioa = konposizioa;
	}

	/**
	 * Gets the masa.
	 *
	 * @return the masa
	 */
	public double getMasa() {
		return masa;
	}
	
	/**
	 * Sets the masa.
	 *
	 * @param masaBerria the new masa
	 */
	public void setMasa(double masaBerria) {
		this.masa = masaBerria;
	}
	
	/**
	 * Gets the de graduak.
	 *
	 * @return the de graduak
	 */
	public double getDeGraduak() {
		return deGraduak;
	}
	
	/**
	 * Sets the de graduak.
	 *
	 * @param deGraduak the new de graduak
	 */
	public void setDeGraduak(double deGraduak) {
		this.deGraduak = deGraduak;
	}
	
	/**
	 * Gets the ra graduak.
	 *
	 * @return the ra graduak
	 */
	public double getRaGraduak() {
		return raGraduak;
	}
	
	/**
	 * Sets the ra graduak.
	 *
	 * @param raGraduak the new ra graduak
	 */
	public void setRaGraduak(double raGraduak) {
		this.raGraduak = raGraduak;
	}
	
	/**
	 * Gets the de minutoak.
	 *
	 * @return the de minutoak
	 */
	public double getDeMinutoak() {
		return deMinutoak;
	}
	
	/**
	 * Sets the de minutoak.
	 *
	 * @param deMinutoak the new de minutoak
	 */
	public void setDeMinutoak(double deMinutoak) {
		this.deMinutoak = deMinutoak;
	}
	
	/**
	 * Gets the ra minutoak.
	 *
	 * @return the ra minutoak
	 */
	public double getRaMinutoak() {
		return raMinutoak;
	}
	
	/**
	 * Sets the ra minutoak.
	 *
	 * @param raMinutoak the new ra minutoak
	 */
	public void setRaMinutoak(double raMinutoak) {
		this.raMinutoak = raMinutoak;
	}
	 
	/**
	 * Sets the data aktibitate.
	 *
	 * @param dataAktibitate the new data aktibitate
	 */
	public void setDataAktibitate(LocalDate dataAktibitate) {
		this.dataAktibitate = dataAktibitate;
	}
	
	/**
	 * Gets the data aktibitate.
	 *
	 * @return the data aktibitate
	 */
	public LocalDate getDataAktibitate() {
		return dataAktibitate;
	}	
}