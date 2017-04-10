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
	private ArrayList<PuzzleSolution> SOLUTIONS;
	private int from;
	private int to;
	private boolean iAmDone = false;
	private PuzzleSolution snapshot;
	
	public PuzzleThread(
			int from,
			int to,
			ArrayList<Piece> PIECES,
			ArrayList<PuzzleSolution> SOLUTIONS) {
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
	
	private synchronized void registerSolution(PuzzleSolution localSolution) {
		PuzzleSolution newSolution = new PuzzleSolution(localSolution);
		newSolution.obtainFingerprint();
		for (PuzzleSolution ps : SOLUTIONS) {
			if (ps.getFingerprint().equals(newSolution.getFingerprint())) {
				return;
			}
		}
		SOLUTIONS.add(newSolution);
		System.out.println("-= SOLUTION FOUND =-");
		System.out.println(localSolution.serializeVisualPlayground());
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
				PuzzleSolution solution = new PuzzleSolution();
				this.solvePuzzle(p, cfg, solution);
			}
		}
		this.iAmDone = true;
		System.out.println("Worker Finished!!!");
		System.out.println(new Date());
	}
}
