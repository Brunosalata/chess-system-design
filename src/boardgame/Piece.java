package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;
	
	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}
	
	//m�todo abstrato, porque se trata de movimento de pe�a (gen�rico). Fosse pi�o, rei, bispo, n�o seria abstrato
	public abstract boolean[][] possibleMoves();
	
	//m�todo n�o abstrato utilizando um m�todo abstrato
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	//implementa��o padr�o de m�todo n�o abstrato, que utiliza um m�todo abstrato
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int i=0; i<mat.length; i++) {
			for (int j=0; j<mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
