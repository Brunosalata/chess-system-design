package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChessMatch chessMatch = new ChessMatch();
		
		while (true) {
			try {			
				//Função para limpar o console no início de cada rodada
				UI.clearScreen();
				//Função que vai imprimir o tabuleiro. Para isso, vamos criar a classe User Interface (UI)
				UI.printMatch(chessMatch);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				//função que vai imprimir os movimentos possíveis no tabuleiro (colorir o fundo)
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
			
				System.out.println("\n");
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
			
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
			}
			catch (ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}

	}

}
