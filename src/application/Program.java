package application;

import chess.ChessMatch;

public class Program {

	public static void main(String[] args) {

		ChessMatch chessMatch = new ChessMatch();
		
		//Função que vai imprimir o tabuleiro. Para isso, vamos criar a classe User Interface (UI)
		UI.printBoard(chessMatch.getPieces());
	}

}
