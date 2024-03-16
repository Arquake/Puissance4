package Vue;

import Modele.Exception.invalidColumException;

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
    public int demanderCoup(String plateau, String playerName) throws invalidColumException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(plateau + playerName + " à vous de jouer ! Indiquez le numéro de la colone visée. \nVotre coup : ");

        String coup = scanner.nextLine();
        Pattern pattern = Pattern.compile("[1-7]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(coup);
        if (matcher.find()) {
            return Integer.parseInt(coup);
        }
        throw new invalidColumException();
    }

    /**
     * @return int with the user input that should represent the number of heap
     */
    public int creerJeu(){
        int res = -1;
        Scanner scanner = new Scanner("");
        while ( true ) {
            System.out.print("Nombre de tas : ");
            scanner = new Scanner(System.in);
            res = verifierCreationJeu(scanner.nextLine());
            if (res != -1) { break; }
            invalidData();
        }
        return res;
    }

    /**
     * receives user player name
     * @param i which player it is making right now
     * @return the player name to the controller
     */
    public String creerJoueur(int i){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nom du joueur "+i+" : ");
        return scanner.nextLine();
    }

    /**
     * prints to the screen if data is invalid
     */
    public void invalidData() {
        System.out.println("\u001B[41m" + "\u001B[30m" + " les données fournit sont invalides " + "\u001B[0m");
    }

    /**
     * prints which player have won
     * @param nomJoueur le nom du joueur
     */
    public void victory(String nomJoueur) {
        System.out.println("\u001B[42m" + "\u001B[30m " + nomJoueur + " a gagné " + "\u001B[0m");
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
        System.out.println("\n\u001B[42m" + "\u001B[30m" + " le vainqueur est : " + joueur + " \u001B[0m");
    }

    /**
     * print "ex aequo" because the two players have the same score
     */
    public void endExeaquo(){
        System.out.println("\n\u001B[43m" + "\u001B[30m " + " ex aequo " + "\u001B[0m");
    }

    /**
     * checks if the number of Heap is valid
     * @param nombre user input
     * @return number of Heap if valid, -1 otherwise
     */
    public int verifierCreationJeu(String nombre){
        Scanner scanner = new Scanner(nombre);
        // scanner check if there's an int in the string
        if ( !scanner.hasNextInt()) {
            return -1;
        }
        // if there's an int we parse it to an int and store it
        int res = Integer.parseInt(scanner.next());
        // if scanner hase other information or res is invalid -1 returned
        if (scanner.hasNext() ) { return -1; }
        // if everything is valid we return the res
        return res >= 1 ? res : -1;
    }
}
