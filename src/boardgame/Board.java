package boardgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int column) {
		//Condi��o para lan�ar uma exce��o
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	//Sobrecarga no m�todo acima
	public Piece piece(Position position) {
		//Condi��o para lan�ar uma exce��o
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//m�todo respons�vel por colocar pe�a espec�fica em posi��o espec�fica do tabuleiro
	public void placePiece(Piece piece, Position position) {
		//Condi��o para lan�ar uma exce��o
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		//como a pe�a n�o est� mais a posi��o inicial, posi��o recebe coordenadas atuais
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		if (piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return aux;
	}
	
	//Fun��o auxiliar da positionExists abaixo: Condi��o para a exist�ncia de uma posi��o
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	//Fun��o de valida��o para verificar se a posi��o existe (BoardException)
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//Fun��o para verificar se a posi��o estpa dispon�vel
	public boolean thereIsAPiece(Position position) {
		//Exce��o criada no m�todo placePiece, mas ele roda aqui para validar a exist�ncia da posi��o antes da disponibilidade
		if (!positionExists(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		return piece(position) != null;
	}
}
