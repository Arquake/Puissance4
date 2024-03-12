package Modele;

public class Plateau {

    /**
     * terrain int[line][column]
     */
    private final int[][] terrain = new int[7][7];

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("\u001B[44m                                             \u001B[0m\n");
        for (int[] i : terrain){
            content.append("\u001B[44m   \u001B[0m");
            for (int j : i) {
                switch (j) {
                    case 1 -> content.append("\u001B[43m   \u001B[0m\u001B[44m   \u001B[0m");
                    case 2 -> content.append("\u001B[41m   \u001B[0m\u001B[44m   \u001B[0m");
                    default -> content.append("\u001B[47m   \u001B[0m\u001B[44m   \u001B[0m");
                }
            }
            content.append("\n\u001B[44m                                             \u001B[0m\n");
        }
        return content.toString();
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
        int column = checkColumn();
        int row = checkRow();
        int diagonal = checkDiagonal();
        return column != 0? column:row != 0? row:diagonal;
    }

    private int checkRow(){
        for (int i = terrain.length-1; i >= 0 ; i--) {
            for (int j = terrain[0].length-1; j >= 3 ; j--) {
                if (terrain[i][j] != 0) {
                    for (int k = 3; k >= 0 ; k--) {
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

    private int checkColumn(){
        for (int i = terrain[0].length-1; i >= 0 ; i--) {
            for (int j = terrain.length-1; j >= 3 ; j--) {
                if (terrain[j][i] != 0) {
                    for (int k = 3; k >= 0 ; k--) {
                        if (terrain[j-k][i] != terrain[j][i]) {
                            break;
                        }
                        else if (k==0){
                            return terrain[j][i];
                        }
                    }
                    break;
                }
            }
        }
        return 0;
    }

    private int checkDiagonal(){
        return 1;
    }

    private int checkRightDiagonal(){

    }

    private int checkLeftDiagonal(){

    }
}
