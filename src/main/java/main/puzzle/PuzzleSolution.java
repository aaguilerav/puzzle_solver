/*
 * AUTHOR: Alejandro Aguilera Vega
 * EMAIL: alejandro.aguilera.vega@gmail.com
 * WHAT CAN YOU DO WITH THIS CODE?: Whatever you want, the only condition is to at least mention its origin.
 */
package main.puzzle;

import java.util.ArrayList;

public class PuzzleSolution {

	public static final int PLAYGROUNG_ROW_COUNT = 6;
	public static final int PLAYGROUNG_COL_COUNT = 10;

	private ArrayList<PlacedPiece> placedPieces;
	private int[][] playground;
	private String[][] visualPlayground;
	private String fingerprint = "";

	public PuzzleSolution() {
		this.placedPieces = new ArrayList<PlacedPiece>();
		this.playground = new int[][]{	{0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,0,0,0,0}};
		this.visualPlayground = new String[][]{	{"#","#","#","#","#","#","#","#","#","#"},
												{"#","#","#","#","#","#","#","#","#","#"},
												{"#","#","#","#","#","#","#","#","#","#"},
												{"#","#","#","#","#","#","#","#","#","#"},
												{"#","#","#","#","#","#","#","#","#","#"},
												{"#","#","#","#","#","#","#","#","#","#"}};
	}
	
	public PuzzleSolution(PuzzleSolution solution) {
		this.placedPieces = new ArrayList<PlacedPiece>();
		for (int i=0; i<solution.getPlacedPieces().size(); i++) {
			this.placedPieces.add(solution.getPlacedPieces().get(i));
		}
		this.playground = new int[PLAYGROUNG_ROW_COUNT][PLAYGROUNG_COL_COUNT];
		this.visualPlayground = new String[PLAYGROUNG_ROW_COUNT][PLAYGROUNG_COL_COUNT];
		for (int i=0; i<PLAYGROUNG_ROW_COUNT; i++) {
			for (int j=0; j<PLAYGROUNG_COL_COUNT; j++) {
				this.playground[i][j] = solution.getPlayground()[i][j];
				this.visualPlayground[i][j] = solution.getVisualPlayground()[i][j];
			}	
		}
	}

	public ArrayList<PlacedPiece> getPlacedPieces() {
		return placedPieces;
	}

	public int[][] getPlayground() {
		return playground;
	}

	public String[][] getVisualPlayground() {
		return visualPlayground;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public boolean isPieceHere(Piece particularPiece) {
		for (int i=0; i<this.placedPieces.size(); i++) {
			if (particularPiece.getId() == this.placedPieces.get(i).getPiece().getId()) {
				return true;
			}
		}
		return false;
	}

	public boolean isItSolved() {
		for (int i=0; i<PLAYGROUNG_ROW_COUNT; i++) {
			for (int j=0; j<PLAYGROUNG_COL_COUNT; j++) {
				if (this.playground[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private void updatePlayground(int index_i, int index_j, PieceConfig cfg) {
		for (int i=index_i; i<index_i + cfg.getRows(); i++) {
			for (int j=index_j; j<index_j + cfg.getColumns(); j++) {
				if (cfg.getArragement()[i-index_i][j-index_j] == 1) {
					this.playground[i][j] = cfg.getArragement()[i-index_i][j-index_j];
					this.visualPlayground[i][j] = cfg.getFather().getAlphaId();
				}
			}
		}
	}
	
	private boolean testPieceConfigurationFit(PieceConfig cfg, int[][] playground) {
		for (int i=0; i<= PLAYGROUNG_ROW_COUNT - cfg.getRows(); i++) {
			for (int j=0; j<= PLAYGROUNG_COL_COUNT - cfg.getColumns(); j++) {
				boolean itCanBePlaced = true;
				for (int ii = 0; ii<cfg.getRows(); ii++) {
					if (!itCanBePlaced) break;
					for (int jj = 0; jj<cfg.getColumns(); jj++) {
						if ((cfg.getArragement()[ii][jj] + playground[i+ii][j+jj]) > 1) {
							itCanBePlaced = false; break;
						}
					}
				}
				if (itCanBePlaced) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean noIncompatibleSpaces() {
		Xray X = new Xray();
		ArrayList<int[][]> negatives = X.obtainNegatives(this.playground);
		int numPiecesThatFit = 0;
		boolean piecesThatFit = true;
		boolean pieceCfgFit;

		for (int n=0; n<negatives.size(); n++) {
			numPiecesThatFit = 0;
			for (Piece p: Start.PIECES) {
				pieceCfgFit = false;
				if (!this.isPieceHere(p)) {
					for (PieceConfig cfg: p.getPieceConfigurations()) {
						if (this.testPieceConfigurationFit(cfg, negatives.get(n))) {
							pieceCfgFit = true;
							break;
						}
					}
					if (pieceCfgFit) {
						numPiecesThatFit++;
						break;
					}					
				}
			}
			if (numPiecesThatFit == 0) {
				piecesThatFit = false;
				break;
			}
		}
		return piecesThatFit;
	}

	public boolean putPieceIntoPlayground(
			Piece p, 
			PieceConfig cfg) {

		// Check incompatible spaces
		if (!this.noIncompatibleSpaces())
			return false;

		for (int i=0; i<= PLAYGROUNG_ROW_COUNT - cfg.getRows(); i++) {
			for (int j=0; j<= PLAYGROUNG_COL_COUNT - cfg.getColumns(); j++) {
				boolean itCanBePlaced = true;
				for (int ii = 0; ii<cfg.getRows(); ii++) {
					if (!itCanBePlaced) break;
					for (int jj = 0; jj<cfg.getColumns(); jj++) {
						if ((cfg.getArragement()[ii][jj] + this.playground[i+ii][j+jj]) > 1) {
							itCanBePlaced = false; break;
						}
					}
				}
				if (itCanBePlaced) {
					this.placedPieces.add(new PlacedPiece(p, cfg, i, j));
					this.updatePlayground(i, j, cfg);
					return true;
				}
			}
		}
		return false;
	}
	
	public String serializeVisualPlayground() {
		String result = "";
		for (int i=0; i<PLAYGROUNG_ROW_COUNT; i++) {
			for (int j=0; j<PLAYGROUNG_COL_COUNT; j++)
				result += this.visualPlayground[i][j] + " ";
			result += "\r\n";
		}
		result += "\r\n";
		return result;
	}

	public void obtainFingerprint() {
		this.fingerprint = "";
		for (int i=0; i<PLAYGROUNG_ROW_COUNT; i++)
			for (int j=0; j<PLAYGROUNG_COL_COUNT; j++)
				this.fingerprint += this.visualPlayground[i][j];
	}
}
