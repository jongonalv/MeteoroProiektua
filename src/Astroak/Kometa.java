package Astroak;

import java.time.LocalDate;

public class Kometa extends Astroa {

	Kometa(String izena, double masa, LocalDate dataAktibitate, String Konposizioa, Koordenatuak raGraduak,
			Koordenatuak raMinutoak, Koordenatuak deGraduak, Koordenatuak deMinutoak) {
		super(izena, masa, dataAktibitate, Konposizioa, raGraduak, raMinutoak, deGraduak, deMinutoak);

	}

}
