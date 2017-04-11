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
	public static final ArrayList<String> SOLUTIONS = new ArrayList<String>();
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

		WORKERS.add(new PuzzleThread(0, 1, 					PIECES, SOLUTIONS));
		WORKERS.add(new PuzzleThread(2, 3, 					PIECES, SOLUTIONS));
		WORKERS.add(new PuzzleThread(4, 5, 					PIECES, SOLUTIONS));
		WORKERS.add(new PuzzleThread(6, 7, 					PIECES, SOLUTIONS));
		WORKERS.add(new PuzzleThread(8, 9,					PIECES, SOLUTIONS));
		WORKERS.add(new PuzzleThread(10, PIECES.size() - 1,	PIECES, SOLUTIONS));

		for (PuzzleThread worker: WORKERS) {
			Thread t = new Thread(worker);
			t.setPriority(Thread.MAX_PRIORITY);
			t.start();
		}

		boolean areWorkersDone = false;
		while (!areWorkersDone) {
			System.out.println((new Date()) + ", Number of Solutions so far: " + SOLUTIONS.size());
			areWorkersDone = true;
			for (PuzzleThread worker: WORKERS) {
				System.out.println("Worker status: " + worker.isiAmDone());
				areWorkersDone = (areWorkersDone && worker.isiAmDone());
			}
			System.out.println("Are All Workers Done?: " + areWorkersDone);

			// Wait 15 min. and then ask again about the status.
			try{Thread.sleep(900000);}catch(Exception ex){}
		}
		System.out.println((new Date()) + ", Finally!, We're DONE!!!");
	}
}
