/*
 * AUTHOR: Alejandro Aguilera Vega
 * EMAIL: alejandro.aguilera.vega@gmail.com
 * WHAT CAN YOU DO WITH THIS CODE?: Whatever you want, the only condition is to at least mention its origin.
 */
package main.puzzle;

public class PieceConfig {
	private int id;
	private Piece father;
	private int[][] arragement;
	private int rows = 0;
	private int columns = 0;
	public PieceConfig(int id, Piece father, int[][] arragement, int rows, int columns) {
		this.id = id;
		this.father = father;
		this.arragement = arragement;
		this.rows = rows;
		this.columns = columns;
	}
	public int getId() {
		return id;
	}
	public int[][] getArragement() {
		return arragement;
	}
	public int getRows() {
		return rows;
	}
	public int getColumns() {
		return columns;
	}
	public Piece getFather() {
		return father;
	}
}
