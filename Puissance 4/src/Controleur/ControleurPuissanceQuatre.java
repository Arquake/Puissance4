package Controleur;

import Modele.Joueur;
import Modele.Plateau;
import Vue.Ihm;

public class ControleurPuissanceQuatre {
    private Joueur[] joueurs;

    private final Ihm ihm;

    /**
     * Initialize the game
     * @param ihm the Ihm ( View )
     */
    public ControleurPuissanceQuatre(Ihm ihm) {
        this.ihm = ihm;
        createPlayers();
    }

    /**
     * Starts the game and keeps it running until the player wants to stop
     * uses playGame() to play the actual game
     * after each full game it asks the players if they want to play the game again using the Ihm
     * if they say no then it prints the stats
     */
    public void jouer(){

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
    private void playGame() {

        Plateau jeu = new Plateau();
        Joueur dernier_joueur = joueurs[0];
        int playerTurn = 0;
        System.out.println(jeu.toString());
        System.out.println(jeu.checkWin());
        try {
            jeu.jouerCoup(3, 1);

            jeu.jouerCoup(2, 2);
            jeu.jouerCoup(2, 1);

            jeu.jouerCoup(1, 2);
            jeu.jouerCoup(1, 2);
            jeu.jouerCoup(1, 1);

            jeu.jouerCoup(0, 2);
            jeu.jouerCoup(0, 2);
            jeu.jouerCoup(0, 2);
            jeu.jouerCoup(0, 1);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(jeu.toString());
        System.out.println(jeu.checkWin());

        /* Game loop
        while (!jeu.isEmpty()) {
            // Ask the current player for their move
            String coup = ihm.demanderCoup(jeu.toString(), joueurs[playerTurn].getNom());

            // Verify and play the move if it's valid
            if (model.verifierCoup(coup, jeu)) {
                if (model.jouerCoup(coup, jeu)) {
                    // If the move was successful, update the last player
                    dernier_joueur = joueurs[playerTurn];

                    // Check if the game is over (heaps are empty) before changing turns
                    if (jeu.isEmpty()) {
                        break; // Exit the loop if the game is over
                    }
                }
                // Move to the next player's turn only if the game continues
                playerTurn = (playerTurn + 1) % 2;
            } else {
                // Inform the player if the input data was invalid
                ihm.invalidData();
            }

        }
        // Announce the winner and update their score
        ihm.victory(dernier_joueur.getNom());
        dernier_joueur.increaseScore();*/
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