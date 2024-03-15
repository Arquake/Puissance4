package Modele;

import java.util.Scanner;

public class PuissanceQuatreModele {

    /**
     * check if the move is valid
     * @param coup String of the coup that the player wants to do
     * @param jeu the game board
     * @return true if valid false otherwise
     */
    public boolean verifierCoup(String coup, Plateau jeu){

        // a scanner is instantiated
        Scanner scanner = new Scanner(coup);

        // if the scanner does not find an int it returns false
        if ( !scanner.hasNextInt()) {
            return false;
        }

        // skip the int
        scanner.nextInt();

        // if the scanner still got something else then false else true
        return !scanner.hasNext();
    }

    /**
     * if the move is valid it executes the move otherwise it doesn't
     * @param coup the move the player wants to execute of type int
     * @param board the game object with heaps in it
     * @return true if the move is valid

     */
    public boolean jouerCoup(String coup, Plateau board, int playerNumber) {
        Scanner scanner = new Scanner(coup);
        return board.jouerCoup(scanner.nextInt(),playerNumber);
    }

    public boolean[] stopCheck(Plateau board){
        boolean victory = board.checkWin();
        boolean isEmpty = board.
        return {}
    }
}
