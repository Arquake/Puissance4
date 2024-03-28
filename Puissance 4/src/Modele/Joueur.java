package Modele;

public class Joueur implements Comparable<Joueur>  {
    /**
     * name of the player
     */
    private final String nom;
    /**
     * score of the player
     */
    private int score = 0;

    /**
     * make a player with this name
     * @param nom player's name
     */
    public Joueur(String nom) {
        this.nom = nom;
    }

    /**
     * give the name of the player
     * @return the name of the player
     */
    public String getNom() {
        return nom;
    }

    /**
     * Increases the players score by 1
     */
    public void increaseScore() {
        this.score++;
    }

    /**
     * give the score of the player
     * @return the score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * compare two players to see which player have a grater score
     * @param player the other player to compare score with
     * @return the difference between this player score and the other one
     * -1 this player has a lower score | 0 players has an equal score | 1 this player has a higher score
     */
    @Override
    public int compareTo(Joueur player) {
        int score = this.score - player.score;
        if ( score < 0 ) { return -1; }
        return this.score - player.score > 0 ? 1 : 0 ;
    }


}
