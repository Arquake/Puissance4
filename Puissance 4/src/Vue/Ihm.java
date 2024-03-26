package Vue;

import Modele.Exception.invalidColumException;
import Modele.Plateau;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ihm {

    /**
     * Ask the player to play on a column
     * @param plateau Board of the game
     * @param playerName Player asked
     * @return a toi de jouer !
     */
    public int demanderCoup(String plateau, String playerName, Boolean erreur) throws invalidColumException {
        Scanner scanner = new Scanner(System.in);
        if (erreur){
            System.out.println(playerName + " c'est encore à vous ! Indiquez le numéro (entre 1 et 7) de la colone visée. \nVotre coup : ");
        } else {
            System.out.println(plateau + playerName + " à vous de jouer ! Indiquez le numéro de la colone visée. \nVotre coup : ");
        }
        String coup = scanner.nextLine();
        Pattern pattern = Pattern.compile("[1-7]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(coup);
        if (matcher.find()) {
            return Integer.parseInt(coup);
        }
        throw new invalidColumException();
    }

    /**
     * receives user player name
     * @param i which player it is making right now
     * @return the player name to the controller
     */
    public String creerJoueur(int i){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom du joueur "+(i+1)+" : ");
        return scanner.nextLine();
    }

    /**
     * prints to the screen if data is invalid
     */
    public void invalidData() {
        System.out.println("\u001B[41m" + "\u001B[30m" + " Les données fournit sont invalides " + "\u001B[0m");
    }

    /**
     * prints which player have won
     * @param nomJoueur player's name
     */
    public void victory(String nomJoueur, String plateau) {
        System.out.println(plateau + "\n\u001B[42m" + "\u001B[30m " + nomJoueur + " a gagné !\u001B[0m");
    }

    /**
     * asks the player if they want to replay
     * @author Matteo
     * @return the user input should be y|Y|n|N
     */
    public boolean replay() {
        Scanner scanner = new Scanner(System.in);
        String res ="";

        System.out.println("Rejouer ? (Y/N)");
        while (true) {
            if (scanner.hasNext()) {
                res = scanner.next();
            }
            if (res.equalsIgnoreCase("y") || res.equalsIgnoreCase("n")){
                return res.equalsIgnoreCase("y");
            } else {

                System.out.println("Rejouer ? (Y/N)");
            }
        }
    }

    /**
     * prints how many games the player has won
     * @param nombreParties number of games the player has won
     * @param nomJoueur name of the player
     */
    public void partieGagnerJoueur(int nombreParties, String nomJoueur){
        System.out.println("\n\u001B[42m" + "\u001B[30m " + nomJoueur + " a gagné " + nombreParties + " parties " + "\u001B[0m");
    }

    /**
     * prints which player has won the most games
     * @param joueur the name of the player
     */
    public void endVictory(String joueur){
        System.out.println("\n\u001B[42m" + "\u001B[30m" + " Le vainqueur est : " + joueur + " ! \u001B[0m");
    }

    /**
     * print "ex aequo" because the two players have the same score
     */
    public void endExeaquo(){
        System.out.println("\n\u001B[43m" + "\u001B[30m" + " Vous êtes ex aequo ! " + "\u001B[0m");
    }

    /**
     * Print when the board is full and what follows it
     * @param jeu Board showed
     */
    public void noWinBoardFull(String jeu){
        System.out.println(jeu + "\n\u001B[43m" + "\u001B[30m " + "La grille est complête et personne n'a aligné 4 jetons ! C'est un match nul. \u001B[0m");
    }
}
