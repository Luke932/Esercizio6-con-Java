package Esercizio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Order {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Order.class);
		int num = 10;

		List<Integer> taskR = listaCasuale(num);
		List<Integer> taskU = sistemaInverso(taskR);

		System.out.println("Lista casuale: " + taskR);
		System.out.println("Lista inversa: " + taskU);

		boolean printP = true;
		printU(taskU, printP);
	}

	public static List<Integer> listaCasuale(int num) {
		List<Integer> task = new ArrayList<>();
		Random around = new Random();

		for (int i = 0; i < num; i++) {
			task.add(around.nextInt(101));
		}

		Collections.sort(task);
		return task;
	}

	public static List<Integer> sistemaInverso(List<Integer> task) {
		List<Integer> taskU = new ArrayList<>(task);
		Collections.reverse(taskU);
		taskU.addAll(task);
		return taskU;
	}

	public static void printU(List<Integer> task, boolean pari) {
		Logger log = LoggerFactory.getLogger(Order.class);
		log.info("Valori in posizioni " + (pari ? "pari" : "dispari") + ": ");
		for (int i = pari ? 0 : 1; i < task.size(); i += 2) {
			if ((pari && i % 2 == 0) || (!pari && i % 2 != 0)) {
				System.out.print(task.get(i) + " ");
			}
		}
		System.out.println();
	}
}
