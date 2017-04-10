/*
 * AUTHOR: Alejandro Aguilera Vega
 * EMAIL: alejandro.aguilera.vega@gmail.com
 * WHAT CAN YOU DO WITH THIS CODE?: Whatever you want, the only condition is to at least mention its origin.
 */
package main.puzzle;

import java.util.ArrayList;

public class Piece {
	private int id;
	private String alphaId;
	private ArrayList<PieceConfig> pieceConfigurations;
	public Piece(int id, String alphaId) {
		this.id = id;
		this.alphaId = alphaId;
		this.pieceConfigurations = new ArrayList<PieceConfig>();
	}
	public int getId() {
		return id;
	}
	public ArrayList<PieceConfig> getPieceConfigurations() {
		return pieceConfigurations;
	}
	public String getAlphaId() {
		return alphaId;
	}
}
