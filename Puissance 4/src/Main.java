import Controleur.ControleurPuissanceQuatre;
import Modele.Exception.invalidCellException;

import Vue.Ihm;

public class Main {
    public static void main(String[] args) throws invalidCellException {
        Ihm ihm = new Ihm();
        ControleurPuissanceQuatre controleurPuissanceQuatre = new ControleurPuissanceQuatre(ihm);
        controleurPuissanceQuatre.jouer();

    }
}