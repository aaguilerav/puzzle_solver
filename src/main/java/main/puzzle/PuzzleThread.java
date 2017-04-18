/*
 * AUTHOR: Alejandro Aguilera Vega
 * EMAIL: alejandro.aguilera.vega@gmail.com
 * WHAT CAN YOU DO WITH THIS CODE?: Whatever you want, the only condition is to at least mention its origin.
 */
package main.puzzle;

import java.util.ArrayList;
import java.util.Date;

public class PuzzleThread implements Runnable {

	private ArrayList<Piece> PIECES;
	private ArrayList<String> SOLUTIONS;
	private int from;
	private int to;
	private int currentPiece;
	private int currentConfig;
	private long start;
	private boolean iAmDone = false;
	private PuzzleSolution snapshot;
	private int localSolutionsCounter = 0;
	
	public PuzzleThread(
			int from,
			int to,
			ArrayList<Piece> PIECES,
			ArrayList<String> SOLUTIONS) {
		this.from = from;
		this.to = to;
		this.PIECES = PIECES;
		this.SOLUTIONS = SOLUTIONS;
	}

	public boolean isiAmDone() {
		return iAmDone;
	}

	public String getSnapshot() {
		return (snapshot != null)?(snapshot.serializeVisualPlayground()):("NO SNAPSHOT YET.");
	}

	public int getLocalSolutionsCounter() {
		return localSolutionsCounter;
	}

	private synchronized void registerSolution(PuzzleSolution localSolution) {
		String serializedSolution = localSolution.serializeVisualPlayground();
		if (!SOLUTIONS.contains(serializedSolution)) {
			this.localSolutionsCounter++;
			SOLUTIONS.add(serializedSolution);
			long execTime = System.currentTimeMillis() - this.start;
			this.start = System.currentTimeMillis();
			System.out.println("Piece: " + 
								this.currentPiece + 
								", Config: " + 
								this.currentConfig + 
								", Solution Found after (ms): " + 
								execTime);
			System.out.println(serializedSolution);
		}
	}

	private void solvePuzzle(
			Piece p, 
			PieceConfig cfg,
			PuzzleSolution solution) {

		PuzzleSolution localSolution = new PuzzleSolution(solution);
		this.snapshot = localSolution;

		if (localSolution.putPieceIntoPlayground(p, cfg)) {
			if (!localSolution.isItSolved()) {
				for (Piece pItem : PIECES) {
					if (!localSolution.isPieceHere(pItem)) {
						for (PieceConfig cfgItem: pItem.getPieceConfigurations()) {
							solvePuzzle(pItem, cfgItem, localSolution);
						}
					}
				}
			} 
			else {
				this.registerSolution(localSolution);
			}
		}
	}

	@Override
	public void run() {
		for (int i=this.from; i<=this.to; i++) {
			Piece p = PIECES.get(i);
			for (PieceConfig cfg: p.getPieceConfigurations()) {
				this.currentPiece = p.getId();
				this.currentConfig = cfg.getId();
				this.start = System.currentTimeMillis();
				PuzzleSolution solution = new PuzzleSolution();
				this.solvePuzzle(p, cfg, solution);
			}
		}
		this.iAmDone = true;
		System.out.println("Worker Finished!!!: " + 
							(new Date()) + 
							"#Solutions: " + 
							this.localSolutionsCounter);
	}
}
