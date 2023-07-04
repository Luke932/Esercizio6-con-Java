package Esercizio3;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rubrica {
	private Map<String, String> rub;

	public Rubrica() {
		rub = new HashMap<>();
	}

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Rubrica.class);

		Rubrica rub = new Rubrica();

		rub.addContatto("Luca", "351/9580435");
		rub.addContatto("Ignazio", "327/9577453");
		rub.addContatto("Padre", "328/1608248");
		rub.addContatto("Madre", "340/3555295");

		String numph = rub.searchNumPh("Ignazio");
		log.info("Numero di telefono di Ignazio: " + numph);

		String name = rub.searchName("340/3555295");
		log.info("Nome associato al numero di telefono 340/3555295: " + name);

		rub.removeContatto("Padre");

		rub.printRub();
	}

	public void addContatto(String nome, String numph) {
		rub.put(nome, numph);
	}

	public void removeContatto(String nome) {
		rub.remove(nome);
	}

	public String searchNumPh(String nome) {
		return rub.get(nome);
	}

	public String searchName(String numph) {
		for (Map.Entry<String, String> entry : rub.entrySet()) {
			if (entry.getValue().equals(numph)) {
				return entry.getKey();
			}
		}
		return null;
	}

	public void printRub() {
		Logger log = LoggerFactory.getLogger(Rubrica.class);
		log.info("Rubrica telefonica: ");
		for (Map.Entry<String, String> entry : rub.entrySet()) {
			log.info("Nome: " + entry.getKey() + ", Numero di telefono: " + entry.getValue());
		}
	}

}
