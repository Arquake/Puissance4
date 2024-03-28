import Controleur.ControleurPuissanceQuatre;
import Vue.Ihm;

public class Main {



    public static void main(String[] args) {
        Ihm ihm = new Ihm();
        ControleurPuissanceQuatre controleurPuissanceQuatre = new ControleurPuissanceQuatre(ihm);
        controleurPuissanceQuatre.jouer();


    }
}