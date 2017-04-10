/*
 * AUTHOR: Alejandro Aguilera Vega
 * EMAIL: alejandro.aguilera.vega@gmail.com
 * WHAT CAN YOU DO WITH THIS CODE?: Whatever you want, the only condition is to at least mention its origin.
 */
package main.puzzle;

public class PlacedPiece {

	private Piece piece;
	private PieceConfig pieceConfig;
	private int top;
	private int left;
	public PlacedPiece(Piece piece, PieceConfig pieceConfig, int top, int left) {
		this.piece = piece;
		this.pieceConfig = pieceConfig;
		this.top = top;
		this.left = left;
	}
	public Piece getPiece() {
		return piece;
	}
	public PieceConfig getPieceConfig() {
		return pieceConfig;
	}
	public int getTop() {
		return top;
	}
	public int getLeft() {
		return left;
	}
}
