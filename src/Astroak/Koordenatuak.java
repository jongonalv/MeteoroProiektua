package Astroak;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * The Class Koordenatuak.
 */
// Koordenatuak klasea, Gradu, minutu eta segundoak gordetzeko klasea.
class Koordenatuak {

	/** The zenbakia. */
	private double zenbakia;

	/**
	 * Instantiates a new koordenatuak.
	 *
	 * @param zenbakia the zenbakia
	 */

	public Koordenatuak(double zenbakia) {
		this.zenbakia = zenbakia;
	}

	/**
	 * Gets the zenbakia.
	 *
	 * @return the zenbakia
	 */ 

	public double getZenbakia() {
		return zenbakia;
	}

	/**
	 * Sets the zenbakia.
	 *
	 * @param zenbakia the new zenbakia
	 */
	public void setZenbakia(double zenbakia) {
		this.zenbakia = zenbakia;
	}

	/**
	 * To string graduak.
	 *
	 * @return the string
	 */

	public String toStringGraduak() {

		double graduak = zenbakia;
		double Min = graduak % 1;	
		Min *= 60;
		double Seg = Min % 1;
		Seg *= 60;

		return (int)graduak + "º " + (int)Min + "' " + (int)Seg + "\"";
	}

	/**
	 * To string orduak.
	 *
	 * @return the string
	 */
	public String toStringOrduak() {

		double orduak = zenbakia;
		double Min = orduak % 1;	
		Min *= 60;
		double Seg = Min % 1;
		Seg *= 60;

		return (int) orduak + " H " + (int) Min + " Min " + (int) Seg + " Seg";
	}
}
