package Modele;

import java.util.Arrays;

public class Plateau {

    /**
     * terrain int[line][column]
     */
    private int[][] terrain = new int[7][7];

    @Override
    public String toString() {
        String content = "\u001B[44m                                             \u001B[0m\n";
        for (int[] i : terrain){
            content += "\u001B[44m   \u001B[0m";
            for (int j : i) {
                switch (j){
                    case 1:
                        content += "\u001B[43m   \u001B[0m\u001B[44m   \u001B[0m";
                        break;
                    case 2:
                        content += "\u001B[41m   \u001B[0m\u001B[44m   \u001B[0m";
                        break;
                    default :
                        content += "\u001B[47m   \u001B[0m\u001B[44m   \u001B[0m";
                        break;
                }
            }
            content += "\n\u001B[44m                                             \u001B[0m\n";
        }
        return content;
    }

    /**
     *
     * @param column column number as column entered by the player - 1
     *               if the player wrote 1 the number given should be 0
     * @param numeroJoueur number of the player
     */
    public void jouerCoup(int column, int numeroJoueur) {
        for (int i = terrain.length-1; i >= 0 ; i--) {
            if (terrain[i][column] == 0) {terrain[i][column] = numeroJoueur;break;}
        }
    }

    public boolean checkCell(int column){
        return !((column < 0) || (column >=terrain[0].length) || terrain[0][column] != 0);
    }

    public int checkWin(){
        return checkLine();
    }

    public int checkLine(){
        for (int i = terrain.length-1; i >= 0 ; i--) {
            for (int j = terrain[0].length-1; j >= 3 ; j--) {
                if (terrain[i][j] != 0) {
                    for (int k = 3; k >= 0 ; k--) {
                        System.out.println(i+" "+j+" "+k);
                        if (terrain[i][j-k] != terrain[i][j]) {
                            break;
                        }
                        else if (k==0){
                            return terrain[i][j];
                        }
                    }
                    break;
                }
            }
        }
        return 0;
    }

    public int checkColumn(){
        for (int i = terrain.length-1; i >= 0 ; i--) {

        }
        return 1;
    }

    public int checkDiagonal(){
        return 1;
    }
}
