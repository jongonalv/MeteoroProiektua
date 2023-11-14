package Meteoroak;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Comparator;

/**
 * The Class meteoroKudeatu.
 */
public class meteoroKudeatu {

	/**
	 * Koordenatuak formato egokian sortzeko.
	 * º ' '' eta h min seg
	 *
	 * @param DE1 the de1
	 * @param RA1 the ra1
	 * @param DE2 the de2
	 * @param RA2 the ra2
	 * @return the string builder
	 */
	private static StringBuilder koordenatuakSortu(double DE1, double RA1, double DE2, double RA2) {

		StringBuilder koordenatuak = new StringBuilder();

		double graduak = RA1;
		double Min = graduak % 1;	
		Min *= 60;
		double Seg = Min % 1;
		Seg *= 60;

		koordenatuak.append("RA1: " + (int) graduak + "º " + (int) Min + "' " + (int) Seg + "'' \n");

		graduak = DE1;
		Min = graduak % 1;	
		Min *= 60;
		Seg = Min % 1;
		Seg *= 60;

		koordenatuak.append("DE1: " + (int) graduak + "º " + (int) Min + "' " + (int) Seg + "'' \n");

		double orduak = RA2 / 60;
		Min = orduak %1;
		Min *= 60;
		Seg = Min % 1;
		Seg *= 60;

		koordenatuak.append("RA2: " + (int) orduak + "h " + (int) Min + "min " + (int) Seg + "seg \n");

		orduak = DE2 / 60;
		Min = orduak %1;
		Min *= 60;
		Seg = Min % 1;
		Seg *= 60;

		koordenatuak.append("DE2: " + (int) orduak + "h " + (int) Min + "min " + (int) Seg + "seg \n");

		return koordenatuak;
	}

	/**
	 * Aldagaiak eskatu erabiltzaileari, meteoritoaren datuak
	 *
	 *
	 * @return the meteorito
	 */
	private static Meteorito aldagaiakEskatu() {

		// Aldagaiak
		double masa 		= 0.0;
		double raGraduak	= 0.0;
		double raMinutoak	= 0.0;
		double deGraduak	= 0.0;
		double deMinutoak	= 0.0;

		String izena = "";
		String data  = "";
		String Konposizioa = "";

		boolean aukeraDa;

		aukeraDa = false;

		while (!aukeraDa) {
			izena = JOptionPane.showInputDialog("Sartu meteoritoaren izena:");

			if (izena != null && !izena.trim().isEmpty()) {
				aukeraDa = true;
			} else {
				JOptionPane.showMessageDialog(null, "Mesedez, sartu izen bat.");
			}
		}

		aukeraDa = false;

		while (!aukeraDa) {
			String input = JOptionPane.showInputDialog("Meteoritoaren masa sartu");
			try {
				masa = Integer.parseInt(input);
				if (masa > 0) {
					aukeraDa = true;
				} else {
					JOptionPane.showMessageDialog(null, "Sartu duzun zenbakia negatiboa da");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Zenbaki bat sartu behar duzu.");
			}
		}

		aukeraDa = false;

		while (!aukeraDa) {
			data = JOptionPane.showInputDialog("Sartu meteoritoaren data (UUUU-HH-EE):");
			try {
				if (izena != null && !izena.trim().isEmpty()) {
					LocalDate dataAktibitate = LocalDate.parse(data);
					aukeraDa = true;
				} else {
					JOptionPane.showMessageDialog(null, "Ez da ezer sartu");
				}
			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "UUUU-HH-EE formatoa erabili, mesedez");
			}
		}

		LocalDate dataAktibitate = LocalDate.parse(data);

		aukeraDa = false;

		while (!aukeraDa) {
			Konposizioa = JOptionPane.showInputDialog("Sartu meteoritoaren konposizioa:");

			if (izena != null && !izena.trim().isEmpty()) {
				aukeraDa = true;
			} else {
				JOptionPane.showMessageDialog(null, "Mesedez, sartu konposizio bat.");
			}
		}

		JOptionPane.showMessageDialog(null, "Sartu zeruko posizioa. RA/DE metodoa erabiliko da.");

		raGraduak = koordenatuaIrakurri("RA1 sartu (Graduak):");
		raMinutoak = koordenatuaIrakurri("RA2 sartu (Minutuak):");
		deGraduak = koordenatuaIrakurri("DE1 sartu (Graduak):");
		deMinutoak = koordenatuaIrakurri("DE2 sartu (Minutuak):");

		// Sortzen diren meteoroen objektuen zerrendari gehitu
		Meteorito Meteoro = new Meteorito(izena, masa, dataAktibitate, Konposizioa, raGraduak, raMinutoak, deGraduak, deMinutoak);
		return Meteoro;
	}

	/**
	 * Meteoro zerrenda bistaratu.
	 *
	 * @param meteoroak the meteoroak
	 */
	// Meteoritoak listatzeko funtzioa
	public static void meteoroZerrenda(ArrayList<Meteorito> meteoroak) {
		StringBuilder mezua = new StringBuilder();
		mezua.append("Sartutako meteoritoen zerrenda:\n");
		for (int i = 0; i < meteoroak.size(); i++) {
			Meteorito meteorito = meteoroak.get(i);
			mezua.append(i).append(". Izena: ").append(meteorito.getIzena()).append("\n");
		}
		JOptionPane.showMessageDialog(null, mezua.toString());
	}

	/**
	 * koordenatuak irakurtzeko.
	 *
	 * @param mezua the mezua
	 * @return the double
	 */

	private static double koordenatuaIrakurri(String mezua) {

		double zenb = 0;
		boolean baliozkoa = false;

		while (!baliozkoa) {
			String sarrera = JOptionPane.showInputDialog(mezua);
			try {
				zenb = Double.parseDouble(sarrera);
				baliozkoa = true;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Balio okerra. Mesedez, sartu zenbaki bat.");
			}
		}

		return zenb;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */

	public static void main(String[] args) {

		// Aldagaiak
		int aukera 			= 0;
		boolean bukatuDa = true;

		// Meteoroak gordetzeko zerrenda
		ArrayList<Meteorito> 	Meteoroak 		= new ArrayList<Meteorito>();

		// Datak
		LocalDate data1 = LocalDate.of(1990, 10, 10);		
		LocalDate data2 = LocalDate.of(1900, 10, 10);		
		LocalDate data3 = LocalDate.of(2050, 10, 10);		

		// Meteoro objektuak sortu
		Meteorito M1 = new Meteorito("Bennu", 20000, data1, "Nikel", 250.20, 600.15, 2500.875, 2200.430);	
		Meteoroak.add(M1);
		Meteorito M2 = new Meteorito("Apolo", 7500000, data2, "Diamante", 200.120, 4000.65, 3100.90, 5200.234);	
		Meteoroak.add(M2);
		Meteorito M3 = new Meteorito("Ceres", 342000, data3, "Izotza", 400.253, 795.21, 253.86, 543.15);
		Meteoroak.add(M3);

		// MENUA HASIERATU
		while (bukatuDa == true) {

			String menu = "METEORO KUDEAKETA\n\n";
			menu+="1. Meteoro berria gehitu\n";
			menu+="2. Meteoro bat ezabatu\n";
			menu+="3. Meteoroak datuaren arabera listatu\n";
			menu+="4. Meteoro bat eguneratu\n";
			menu+="5. Bukatu exekutatzen\n";
			menu+="Aukeratu bat\n";

			boolean aukeraDa = false;

			// Funtzio aukeraketa eta errore kontrola. 
			while (!aukeraDa) {
				String input = JOptionPane.showInputDialog(menu);
				try {
					aukera = Integer.parseInt(input);
					if (aukera >= 1 && aukera <= 5) {
						aukeraDa = true;
					} else {
						JOptionPane.showMessageDialog(null, "Sartu duzun zenbakia ez da 1-5 artekoa.");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Zenbaki bat sartu behar duzu.");
				}
			}

			// Meteoro berria gehitzeko blokea
			if (aukera == 1) {

				Meteorito Meteoro = aldagaiakEskatu();
				Meteoroak.add(Meteoro);

				JOptionPane.showMessageDialog(null, "METEORO BERRI BAT SARTU DA!");
			}

			//Meteoro bat ezabatzeko blokea
			if (aukera == 2) {

				meteoroZerrenda(Meteoroak);

				aukeraDa = false;				
				int indizea = 0;

				// Errore kontrola, zerrendaren arabera eta negatiboa bada menua itzultzeko aukera
				while (!aukeraDa) {
					String input = JOptionPane.showInputDialog("Sartu ezabatu nahi duzun meteoroaren zenbakia. Ateratzeko, zenbaki negatibo bat sartu");
					StringBuilder mezua = new StringBuilder();
					try {
						indizea = Integer.parseInt(input);
						if (indizea >= 0 && indizea < Meteoroak.size()) {
							Meteorito borratu = (Meteorito) Meteoroak.remove(indizea);
							mezua.append("Meteorito: ").append(borratu.getIzena()).append(" ezabatuta");
							JOptionPane.showMessageDialog(null, mezua);
							aukeraDa = true;
						} else if (indizea < 0){
							JOptionPane.showMessageDialog(null, "Menu-ra itzuliko da");
							break;
						} else {
							JOptionPane.showMessageDialog(null, "Sartutako zenbakia zerrendatik kanpo dago");
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Zenbaki bat sartu, mesedez.");
					}
				}
			}

			//Meteoroak datu motaren arabera zerrendatzeko blokea
			if (aukera == 3) {

				int aukera2 = 0;

				// Datu mota aukeratzeko menua
				String menu2="Aukeratu datu mota zerrendatzeko: \n";
				menu2+="1.- Izenaren arabera\n";
				menu2+="2.- Masaren arabera\n";
				menu2+="3.- RA koordenatuen arabera\n";
				menu2+="4.- DE koordenatuen arabera\n";
				menu2+="5.- Aktibitate dataren arabera\n";
				menu2+="6.- Konposizioa";

				aukeraDa = false;

				// Errore kontrola. Datu mota aukeratzeko. Zenbaki bat izan behar du.
				// Zenbakia 1-5 tartean egon behar du. Negatiboa sartzen bada bueltatzeko aukera.
				while (!aukeraDa) {
					String input2 = JOptionPane.showInputDialog(menu2);
					try {
						aukera2 = Integer.parseInt(input2);
						if (aukera2 >= 1 && aukera2 <= 6) {
							aukeraDa = true;
						} else if (aukera2 < 0) {
							JOptionPane.showMessageDialog(null, "Menu-ra itzuli");
							return;
						} else {
							JOptionPane.showMessageDialog(null, "Zenbakia ez da egokia");
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Zenbaki bat sartu behar duzu.");
					}
				}
				
				//Comparator bat, meteorito objektuko datu motak konparatzeko
				Comparator<Meteorito> comparator = null;

				//Aukeraren arabera, datu mota bat edo beste konparatu
				switch (aukera2) {
				case 1:
					comparator = Comparator.comparing(Meteorito::getIzena);
					break;
				case 2:
					comparator = Comparator.comparing(Meteorito::getMasa);
					break;
				case 3:
					comparator = Comparator.comparing((Meteorito m) -> m.getRaGraduak() + m.getRaMinutoak());
					break;
				case 4:
					comparator = Comparator.comparing((Meteorito m) -> m.getDeGraduak() + m.getDeMinutoak());
					break;
				case 5:
					comparator = Comparator.comparing(Meteorito::getDataAktibitate);
					break;
				case 6:
					comparator = Comparator.comparing(Meteorito::getKonposizioa);
					break;
				default:
					System.out.println("Aukera ez da egokia. Menu-ra bueltatu.");
					return;
				}

				// Konparadoreak eman duen emaitzaren arabera, meteoro zerrendako objektuak zerrendatu
				Collections.sort(Meteoroak, comparator);

				// Emaitza bistaratu
				StringBuilder mezua = new StringBuilder();
				mezua.append("Meteoritoen zerrenda aukeratutako kriterioarekin zerrendatuta:\n");

				// Meteoroen zerrenda atera, datu motaren arabera
				for (int i = 0; i < Meteoroak.size(); i++) {
					Meteorito meteoroOrdenatua = Meteoroak.get(i);

					mezua.append(i).append(". - Izena: ").append(meteoroOrdenatua.getIzena()).append("\n");
					mezua.append("Masa: " + meteoroOrdenatua.getMasa()).append("\n");
					mezua.append(koordenatuakSortu(meteoroOrdenatua.getDeGraduak(), meteoroOrdenatua.getRaGraduak(), meteoroOrdenatua.getDeMinutoak(), meteoroOrdenatua.getRaMinutoak()));
					mezua.append("Data aktibitate maximoa: " + meteoroOrdenatua.getDataAktibitate()).append("\n");
					mezua.append("Konposizioa: " + meteoroOrdenatua.getKonposizioa()).append("\n\n");
				}

				JOptionPane.showMessageDialog(null, mezua);
			}

			//Meteoroak eguneratzeko blokea
			if (aukera == 4) {

				int aukera3 = 0;

				meteoroZerrenda(Meteoroak);

				aukeraDa = false;

				// Errore kontrola. Erabiltzaileari eskatzeko zein meteoro nahi duen aukeratu
				// Zenbaki bat bakarrik izan behar du, meteoro zerrenda tartean.
				// Zenbakia negatiboa bada menura itzultzeko aukera.
				while (!aukeraDa) {
					String input = JOptionPane.showInputDialog("Sartu eguneratu nahi den meteoroaren zenbakia:");
					try {
						aukera = Integer.parseInt(input);
						if (aukera >= 0 && aukera < Meteoroak.size()) {
							aukeraDa = true;
						} else {
							JOptionPane.showMessageDialog(null, "Sartutako zenbakia zerrendatik kanpo dago");
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "Zenbaki bat sartu behar duzu.");
					}
				}

				//Aldagai berriak sartzen dira eta meteoro berri batean gordetzen dira
				Meteorito MeteoroBerria = aldagaiakEskatu();
				Meteorito Meteoro = Meteoroak.get(aukera3);

				StringBuilder mezua = new StringBuilder();

				String azkenekoIzena = Meteoro.getIzena();

				// Sortutako meteoro berriko datuak eskatutako meteoroan sartu, datuak eguneratzeko
				Meteoro.setIzena(MeteoroBerria.getIzena());
				Meteoro.setMasa(MeteoroBerria.getMasa());
				Meteoro.setDataAktibitate(MeteoroBerria.getDataAktibitate());
				Meteoro.setKonposizioa(MeteoroBerria.getKonposizioa());
				Meteoro.setRaGraduak(MeteoroBerria.getRaGraduak());
				Meteoro.setRaMinutoak(Meteoro.getRaMinutoak());
				Meteoro.setDeGraduak(MeteoroBerria.getRaMinutoak());
				Meteoro.setDeMinutoak(MeteoroBerria.getDeMinutoak());

				mezua.append("Meteorito: ").append(azkenekoIzena).append(" eguneratuta,").append(" horain: ").append(MeteoroBerria.getIzena());
				JOptionPane.showMessageDialog(null, mezua);

			}	

			if (aukera == 5) {
				bukatuDa = false;
			}			
		}

		JOptionPane.showMessageDialog(null, "Exekuzioa bukatu da.");
	}
}