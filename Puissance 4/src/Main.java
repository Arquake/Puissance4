import Controleur.ControleurPuissanceQuatre;
import Modele.Exception.invalidCellException;
import Modele.Plateau;
import Vue.Ihm;

public class Main {
    public static void main(String[] args) throws invalidCellException {
        Ihm ihm = new Ihm();
        ControleurPuissanceQuatre controleurPuissanceQuatre = new ControleurPuissanceQuatre(ihm);
        controleurPuissanceQuatre.jouer();

        Plateau plateau = new Plateau();
        try {
            ihm.demanderCoup(plateau, "Moi");
        }
        catch (Exception e){
            System.out.println("C'est dans le main salaud");
            System.out.println(e.getMessage());
        }
    }
}