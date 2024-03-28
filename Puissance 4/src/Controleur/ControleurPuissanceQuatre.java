package Controleur;

import Modele.Exception.invalidCellException;
import Modele.Joueur;
import Modele.Plateau;
import Vue.Ihm;

public class ControleurPuissanceQuatre {
    private Joueur[] joueurs;
    private final Ihm ihm;
    private Plateau jeu;

    /**
     * Initialize the game
     *
     * @param ihm the Ihm ( View )
     */
    public ControleurPuissanceQuatre(Ihm ihm) {
        this.ihm = ihm;
        creerListeJoueurs();

    }

    /**
     * Starts the game and keeps it running until the player wants to stop
     * uses jouerPartie() to play the actual game
     * after each full game it asks the players if they want to play the game again using the Ihm
     * if they say no then it prints the stats
     */
    public void jouer() {

        boolean running = true;
        while (running) {
            jouerPartie();

            running = ihm.replay();
        }
        for (Joueur j : joueurs) {
            ihm.partieGagnerJoueur(j.getScore(), j.getNom());
        }

        if (joueurs[0].compareTo(joueurs[1]) == 0) {
            ihm.endExeaquo();
        } else {
            ihm.endVictory(joueurs[0].compareTo(joueurs[1]) > 0 ? joueurs[0].getNom() : joueurs[1].getNom());
        }
    }

    /**
     * game loops until one player wins
     * makes the actual heap
     * initializes game with joueur 0
     */

    private void jouerPartie() {
        int playerTurn = 0;


        jeu = new Plateau();
        ihm.afficherPlateau(jeu.toString());

        int coup;
        // Game loop
        while (true) {
                // Ask the current player for their move
                // Verify and play the move if it's valid
            coup = ihm.demanderCoup(joueurs[playerTurn].getNom());

                try {
                    jeu.jouerCoup(coup - 1, playerTurn + 1);
                    if (jeu.checkWin() != -1) {
                        joueurs[playerTurn].increaseScore();
                        ihm.victory(joueurs[playerTurn].getNom(), jeu.toString());
                        break;
                    }
                    if (jeu.boardIsFull()) {
                        ihm.noWinBoardFull(jeu.toString());
                        break;
                    }
                    ihm.afficherPlateau(jeu.toString());
                    // If the move was successful, update the next player
                    playerTurn = (playerTurn + 1) % 2;

                }
                catch (invalidCellException e){
                    ihm.invalidData();
                }
        }
        // Announce the winner and update their score
    }


    /**
     * creates two player and stores them in this.joueurs Array
     */
    private void creerListeJoueurs() {
        this.joueurs = new Joueur[2];
        // creating the players
        for (int i = 0; i < 2; i++) {
            this.joueurs[i] = new Joueur(ihm.creerJoueur(i));
        }
    }
}