package Controleur;

import Modele.Exception.invalidCellException;
import Modele.Joueur;
import Modele.Plateau;
import Vue.Ihm;

public class ControleurPuissanceQuatre {
    private Joueur[] joueurs;
    private Plateau jeu;
    private final Ihm ihm;

    /**
     * Initialize the game
     * @param ihm the Ihm ( View )
     */
    public ControleurPuissanceQuatre(Ihm ihm) {
        this.ihm = ihm;
        createPlayers();
       this.jeu = new Plateau();

    }

    /**
     * Starts the game and keeps it running until the player wants to stop
     * uses playGame() to play the actual game
     * after each full game it asks the players if they want to play the game again using the Ihm
     * if they say no then it prints the stats
     */
    public void jouer() throws invalidCellException {

        boolean running = true;
        while (running){
            playGame();

            running = ihm.replay();
        }
        for (Joueur j: joueurs) {
            ihm.partieGagnerJoueur(j.getScore(),j.getNom());
        }

        if (joueurs[0].compareTo(joueurs[1]) == 0) { ihm.endExeaquo(); }
        else {
            ihm.endVictory(joueurs[0].compareTo(joueurs[1]) > 0 ? joueurs[0].getNom() : joueurs[1].getNom());
        }
    }

    /**
     * game loops until one player wins
     * makes the actual heap
     * initializes game with joueur 0
     *
     */
    
    private void playGame() throws invalidCellException {

        Joueur dernier_joueur = joueurs[0];
        int playerTurn = 0;


        // Game loop
        while (!jeu.boardIsFull()&& jeu.checkWin() == 0) {
            // Ask the current player for their move
            int coup = ihm.demanderCoup(jeu.toString(), joueurs[playerTurn].getNom());

            // Verify and play the move if it's valid
                if (jeu.jouerCoup(coup-1,playerTurn+1)) {
                    // If the move was successful, update the last player
                    dernier_joueur = joueurs[playerTurn];

                }
                // Move to the next player's turn only if the game continues
                playerTurn = (playerTurn + 1) % 2;


        }
        // Announce the winner and update their score
        ihm.victory(dernier_joueur.getNom());
        dernier_joueur.increaseScore();
    }



    /**
     * creates two player and stores them in this.joueurs Array
     */
    private void createPlayers(){
        this.joueurs = new Joueur[2];
        // creating the players
        for (int i = 0; i < 2; i++) {
            this.joueurs[i] = new Joueur(ihm.creerJoueur(i));
        }
    }

}