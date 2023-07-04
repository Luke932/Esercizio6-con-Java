package Esercizio1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParoleDuplicate {
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(ParoleDuplicate.class);
		Scanner input = new Scanner(System.in);

		System.out.print("Inserire il numero di parole da inserire: ");
		int num = input.nextInt();
		input.nextLine();

		Set<String> parole = new HashSet<>();
		Set<String> paroleDup = new HashSet<>();

		System.out.print("Inserisci le parole: ");

		for (int i = 0; i < num; i++) {
			String parola = input.next();
			if (!parole.add(parola)) {
				paroleDup.add(parola);
			}
		}

		log.info("Parole duplicate: " + paroleDup);
		log.info("Numero di parole distinte: " + parole.size());
		System.out.print("Elenco delle parole distinte: ");
		parole.forEach(parola -> System.out.println(parola + " "));

		input.close();
	}

}
