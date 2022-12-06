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
		//Condição para lançar uma exceção
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	//Sobrecarga no método acima
	public Piece piece(Position position) {
		//Condição para lançar uma exceção
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}
	
	//método responsável por colocar peça específica em posição específica do tabuleiro
	public void placePiece(Piece piece, Position position) {
		//Condição para lançar uma exceção
		if (thereIsAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		//como a peça não está mais a posição inicial, posição recebe coordenadas atuais
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
	
	//Função auxiliar da positionExists abaixo: Condição para a existência de uma posição
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	//Função de validação para verificar se a posição existe (BoardException)
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	//Função para verificar se a posição estpa disponível
	public boolean thereIsAPiece(Position position) {
		//Exceção criada no método placePiece, mas ele roda aqui para validar a existência da posição antes da disponibilidade
		if (!positionExists(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		return piece(position) != null;
	}
}
