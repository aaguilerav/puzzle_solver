/*
 * AUTHOR: Alejandro Aguilera Vega
 * EMAIL: alejandro.aguilera.vega@gmail.com
 * WHAT CAN YOU DO WITH THIS CODE?: Whatever you want, the only condition is to at least mention its origin.
 */
package main.puzzle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Start {

	public static final ArrayList<Piece> PIECES = new ArrayList<Piece>();
	public static final ArrayList<PuzzleSolution> SOLUTIONS = new ArrayList<PuzzleSolution>();
	public static final ArrayList<PuzzleThread> WORKERS = new ArrayList<PuzzleThread>();

	public static void main(String[] args) throws IOException {
		System.out.println("+-------+---+-------+-----------+---+---+");
		System.out.println("|       |   |       |           |   |   |");
		System.out.println("|   +---+   +---+   +---+   +---+   |   |");
		System.out.println("|   |           |       |   |       |   |");
		System.out.println("|   +-------+   +---+   |   +---+   |   |");
		System.out.println("|   |       |   |   |   |   |   |   |   |");
		System.out.println("|   |   +---+---+   +---+---+   |   |   |");
		System.out.println("|   |   |   |           |       |   |   |");
		System.out.println("+---+   |   +---+   +---+   +---+---+   |");
		System.out.println("|       |   |   |   |   |   |       |   |");
		System.out.println("+-------+   |   +---+   |   |       +---+");
		System.out.println("|           |           |   |           |");
		System.out.println("+-----------+-----------+---+-----------+");
		System.out.println("+---------------------------------------+");
		System.out.println("|             PUZZLE SOLVER             |");
		System.out.println("+---------------------------------------+");

		LoadConfig.loadConfigurations(PIECES);

		WORKERS.add(new PuzzleThread(0, 2, 					PIECES, SOLUTIONS));
		WORKERS.add(new PuzzleThread(3, 5, 					PIECES, SOLUTIONS));
		WORKERS.add(new PuzzleThread(6, 8,					PIECES, SOLUTIONS));
		WORKERS.add(new PuzzleThread(9, PIECES.size() - 1,	PIECES, SOLUTIONS));

		for (PuzzleThread worker: WORKERS) {
			Thread t = new Thread(worker);
			t.setPriority(Thread.MAX_PRIORITY);
			t.start();
		}

		boolean areWorkersDone = false;
		while (!areWorkersDone) {
			System.out.println(new Date());
			System.out.println("Number of Solutions so far: " + SOLUTIONS.size());
			areWorkersDone = true;
			for (PuzzleThread worker: WORKERS) {
				areWorkersDone = (areWorkersDone && worker.isiAmDone());
			}
			System.out.println("Are Workers Done?: " + areWorkersDone);
			
			// Wait 15 min. and then ask again about the status.
			try{Thread.sleep(900000);}catch(Exception ex){}
		}
		System.out.println("We're Finished!!!");
		System.out.println(new Date());
	}
}
