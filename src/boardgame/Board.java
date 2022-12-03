package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	//Sobrecarga no m�todo acima
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//m�todo respons�vel por colocar pe�a espec�fica em posi��o espec�fica do tabuleiro
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		//como a pe�a n�o est� mais a posi��o inicial, posi��o recebe coordenadas atuais
		piece.position = position;
	}
	
}
