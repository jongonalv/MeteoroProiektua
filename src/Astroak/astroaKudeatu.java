package Astroak;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.Color;
import java.time.*;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/**
 * The Class meteoroKudeatu.
 */
public class astroaKudeatu {

	/**
	 * Aldagaiak eskatu erabiltzaileari, meteoritoaren datuak.
	 *
	 * @return the meteorito
	 */

	private static Astroa aldagaiakEskatu() {

		// Aldagaiak
		double masa 		= 0.0;

		Koordenatuak raGraduak;
		Koordenatuak raMinutoak;
		Koordenatuak deGraduak;
		Koordenatuak deMinutoak;

		Scanner scanner = new Scanner(System.in);

		String izena = "";
		String data  = "";
		String Konposizioa = "";

		boolean aukeraDa;

		aukeraDa = false;

		// Aldagai bakoitzeko errore kontrola
		while (!aukeraDa) {
			System.out.println("Sartu meteoritoaren izena:");
			izena = scanner.nextLine();
			if (izena != null && !izena.trim().isEmpty()) {
				aukeraDa = true;
			} else {
				System.out.println("Mesedez, sartu izen bat.");
			}
		}

		aukeraDa = false;

		while (!aukeraDa) {
			System.out.print("Meteoritoaren masa sartu: ");
			String input = scanner.nextLine();
			try {
				masa = Integer.parseInt(input);

				if (masa > 0) {
					aukeraDa = true;
				} else {
					System.out.println("Sartu duzun zenbakia negatiboa ada");
				}
			} catch (NumberFormatException e) {
				System.out.println("Zenbaki bat sartu behar duzu.");
			}
		}


		aukeraDa = false;

		while (!aukeraDa) {
			System.out.print("Sartu meteoritoaren data (UUUU-HH-EE): ");
			data = scanner.nextLine();
			try {
				if (izena != null && !izena.trim().isEmpty()) {
					LocalDate dataAktibitate = LocalDate.parse(data);
					aukeraDa = true;
				} else {
					System.out.println("Ez da ezer sartu");
				}
			} catch (DateTimeParseException e) {
				System.out.println("UUUU-HH-EE formatoa erabili, mesedez");
			}
		}

		LocalDate dataAktibitate = LocalDate.parse(data);

		aukeraDa = false;

		while (!aukeraDa) {
			System.out.println("Sartu meteoritoaren konposizioa:");
			Konposizioa = scanner.nextLine();

			if (izena != null && !izena.trim().isEmpty()) {
				aukeraDa = true;
			} else {
				System.out.println("Mesedez, sartu konposizio bat.");
			}
		}

		System.out.println("Sartu zeruko posizioa. RA/DE metodoa erabiliko da.");

		raGraduak = koordenatuaIrakurri("RA1 sartu (Graduak):");
		raMinutoak = koordenatuaIrakurri("RA2 sartu (Minutuak):");
		deGraduak = koordenatuaIrakurri("DE1 sartu (Graduak):");
		deMinutoak = koordenatuaIrakurri("DE2 sartu (Minutuak):");

		// Iruzkinak gehitzeko blokea, aukerazkoa denez, erabiltzaileari.
		// galdetu ea nahi duen sartu ala ez, baiezkoa bada, eraikitzaile bat erabili.
		// Bestela, beste eraikitzailea erabiliko da.

		String iruzkin = "";

		System.out.print("Iruzkin bat edo beste daturen bat sartu nahi duzu? (BAI/EZ): ");
		String respuesta = scanner.nextLine();

		// Aukera bat edo beste erabiltzeko.
		if ("BAI".equalsIgnoreCase(respuesta)) {
			System.out.print("Hemen idatzi: ");
			iruzkin = scanner.nextLine();
			System.out.println("Zure iruzkina: '" + iruzkin + "' gorde egin da.");

		} else if ("EZ".equalsIgnoreCase(respuesta)) {
			System.out.println("Ez duzu iruzkinik idatzi.");

			// Sortzen diren meteoroen objektuen zerrendari gehitu, iruzkinak gabe.
			Astroa Meteoro = new Astroa(izena, masa, dataAktibitate, Konposizioa, raGraduak, raGraduak, deGraduak, deMinutoak);
			return Meteoro;

		} else {
			System.out.println("Hautatu duzun erantzunak ez da baliogarria. Programa amaituko da.");
			return null;  // o realiza alguna acción adicional según tus necesidades
		}

		// Sortzen diren meteoroen objektuen zerrendari gehitu, iruzkinak sartuz.
		Astroa Meteoro = new Astroa(izena, masa, dataAktibitate, Konposizioa, raGraduak, raGraduak, deGraduak, deMinutoak, iruzkin);
		return Meteoro;

	}


	/**
	 * Meteoro zerrenda bistaratu.
	 *
	 * @param meteoroak the meteoroak
	 */
	// Meteoritoak listatzeko funtzioa
	public static void meteoroZerrenda(ArrayList<Astroa> meteoroak) {
		StringBuilder mezua = new StringBuilder();
		mezua.append("Sartutako meteoritoen zerrenda:\n");
		for (int i = 0; i < meteoroak.size(); i++) {
			Astroa meteorito = meteoroak.get(i);
			mezua.append(i).append(". Izena: ").append(meteorito.getIzena()).append("\n");
		}
		System.out.println(mezua.toString());
	}

	/**
	 * koordenatuak irakurtzeko, errore kontrola.
	 *
	 * @param mezua the mezua
	 * @return the double
	 */

	private static Koordenatuak koordenatuaIrakurri(String mezua) {

		double zenb;
		Koordenatuak koordenatu = new Koordenatuak(0);
		boolean baliozkoa = false;

		Scanner scanner = new Scanner(System.in);

		while (!baliozkoa) {
			System.out.print(mezua);
			String sarrera = scanner.nextLine();

			try {
				zenb = Double.parseDouble(sarrera);
				koordenatu.setZenbakia(zenb);
				baliozkoa = true;
			} catch (NumberFormatException e) {
				System.out.println("Balio okerra. Mesedez, sartu zenbaki bat.");
			}
		}

		return koordenatu;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */

	public static void main(String[] args) {

		UIManager.put("OptionPane.background", Color.blue);
		UIManager.put("Panel.background", Color.cyan);
		UIManager.put("Button.background", Color.WHITE);

		// Aldagaiak
		int aukera 			= 0;
		boolean bukatuDa = true;

		// Meteoroak gordetzeko zerrenda
		ArrayList<Astroa> 	Meteoroak 		= new ArrayList<Astroa>();

		// Datak
		LocalDate data1 = LocalDate.of(1990, 10, 10);

		// Scanner
		Scanner scanner = new Scanner(System.in);

		//Koordenatuak
		Koordenatuak RA1 = new Koordenatuak(30.5);		
		Koordenatuak DE1 = new Koordenatuak(340.52);		
		Koordenatuak RA2 = new Koordenatuak(130.35);	
		Koordenatuak DE2 = new Koordenatuak(430.65);	

		// Meteoro objektuak sortu
		Astroa M1 = new Astroa("Bennu", 20000, data1, "Nikel", RA1, RA2, DE1, DE2);	
		Meteoroak.add(M1);

		// MENUA HASIERATU
		while (bukatuDa == true) {

			String menu = "\nMETEORO KUDEAKETA\n\n";
			menu+="1. Meteoro berria gehitu\n";
			menu+="2. Meteoro bat ezabatu\n";
			menu+="3. Meteoroak datuaren arabera listatu\n";
			menu+="4. Meteoro bat eguneratu\n";
			menu+="5. Bukatu exekutatzen\n";
			menu+="\nAukeratu bat\n";

			boolean aukeraDa = false;

			// Funtzio aukeraketa eta errore kontrola. 
			while (!aukeraDa) {
				System.out.print(menu);
				String input = scanner.nextLine();

				try {
					aukera = Integer.parseInt(input);

					if (aukera >= 1 && aukera <= 5) {
						aukeraDa = true;
					} else {
						System.out.println("Sartu duzun zenbakia ez da 1-5 artekoa.");
					}
				} catch (NumberFormatException e) {
					System.out.println("Zenbaki bat sartu behar duzu.");
				}
			}

			// Meteoro berria gehitzeko blokea
			if (aukera == 1) {

				Astroa Meteoro = aldagaiakEskatu();
				Meteoroak.add(Meteoro);

				System.out.println("METEORO BERRI BAT SARTU DA!");
			}

			//Meteoro bat ezabatzeko blokea
			if (aukera == 2) {

				meteoroZerrenda(Meteoroak);

				aukeraDa = false;				
				int indizea = 0;

				// Errore kontrola, zerrendaren arabera eta negatiboa bada menua itzultzeko aukera
				while (!aukeraDa) {
					System.out.print("Sartu ezabatu nahi duzun meteoroaren zenbakia. Ateratzeko, zenbaki negatibo bat sartu: ");
					StringBuilder mezua = new StringBuilder();

					try {
						indizea = Integer.parseInt(scanner.nextLine());

						if (indizea >= 0 && indizea < Meteoroak.size()) {
							Astroa borratu = (Astroa) Meteoroak.remove(indizea);
							mezua.append("Meteorito: ").append(borratu.getIzena()).append(" ezabatuta");
							System.out.println(mezua);
							aukeraDa = true;
						} else if (indizea < 0) {
							break;
						} else {
							System.out.println("Sartutako zenbakia zerrendatik kanpo dago");
						}
					} catch (NumberFormatException e) {
						System.out.println("Zenbaki bat sartu, mesedez.");
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
				menu2+="6.- Konposizioa\n";

				aukeraDa = false;

				// Errore kontrola. Datu mota aukeratzeko. Zenbaki bat izan behar du.
				// Zenbakia 1-5 tartean egon behar du. Negatiboa sartzen bada bueltatzeko aukera.
				while (!aukeraDa) {
					System.out.print(menu2);
					try {
						aukera2 = scanner.nextInt();

						if (aukera2 >= 1 && aukera2 <= 6) {
							aukeraDa = true;
						} else if (aukera2 < 0) {
							System.out.println("Menu-ra itzuli");
							return; // o realiza alguna acción adicional según tus necesidades
						} else {
							System.out.println("Zenbakia ez da egokia");
						}
					} catch (NumberFormatException e) {
						System.out.println("Zenbaki bat sartu behar duzu.");
					}
				}

				//Comparator bat, meteorito objektuko datu motak konparatzeko
				Comparator<Astroa> comparator = null;

				//Aukeraren arabera, datu mota bat edo beste konparatu
				switch (aukera2) {
				case 1:
					comparator = Comparator.comparing(Astroa::getIzena);
					break;
				case 2:
					comparator = Comparator.comparing(Astroa::getMasa);
					break;
				case 3:
					comparator = Comparator.comparing((Astroa m) -> {
						Koordenatuak koordenatuak = m.getRaGraduak();
						return koordenatuak.getZenbakia();
					});
					break;
				case 4:
					comparator = Comparator.comparing((Astroa m) -> {
						Koordenatuak koordenatuak = m.getDeGraduak();
						return koordenatuak.getZenbakia();
					});
					break;
				case 5:
					comparator = Comparator.comparing(Astroa::getDataAktibitate);
					break;
				case 6:
					comparator = Comparator.comparing(Astroa::getKonposizioa);
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
					Astroa meteoroOrdenatua = Meteoroak.get(i);

					mezua.append(i).append(". - Izena: ").append(meteoroOrdenatua.getIzena()).append("\n");
					mezua.append("Masa: " + meteoroOrdenatua.getMasa()).append("\n");
					mezua.append("RA1: " + meteoroOrdenatua.getRaGraduak().toStringGraduak() + ("\n")
							+  "RA2: " + meteoroOrdenatua.getRaMinutoak().toStringOrduak() + ("\n")
							+  "DE1: " +  meteoroOrdenatua.getDeGraduak().toStringGraduak() + ("\n")
							+  "DE2: " + meteoroOrdenatua.getDeMinutoak().toStringOrduak() + ("\n"));
					mezua.append("Data aktibitate maximoa: " + meteoroOrdenatua.getDataAktibitate()).append("\n");
					mezua.append("Konposizioa: " + meteoroOrdenatua.getKonposizioa()).append("\n");
					mezua.append("Iruzkinak: " + meteoroOrdenatua.getIruzkina()).append("\n\n");
				}

				System.out.println(mezua);
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
					System.out.print("Sartu eguneratu nahi den meteoroaren zenbakia: ");
					try {
						aukera = Integer.parseInt(scanner.nextLine());

						if (aukera >= 0 && aukera < Meteoroak.size()) {
							aukeraDa = true;
						} else {
							System.out.println("Sartutako zenbakia zerrendatik kanpo dago");
						}
					} catch (NumberFormatException e) {
						System.out.println("Zenbaki bat sartu behar duzu.");
					}
				}

				//Aldagai berriak sartzen dira eta meteoro berri batean gordetzen dira
				Astroa MeteoroBerria = aldagaiakEskatu();
				Astroa Meteoro = Meteoroak.get(aukera3);

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
				Meteoro.setIruzkina(MeteoroBerria.getIruzkina());

				mezua.append("Meteorito: ").append(azkenekoIzena).append(" eguneratuta,").append(" horain: ").append(MeteoroBerria.getIzena());
				System.out.println(mezua);

			}	

			if (aukera == 5) {
				bukatuDa = false;
			}			
		}
		System.out.println("Exekuzioa bukatu da.");
	}
}
