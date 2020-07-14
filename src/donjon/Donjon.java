package donjon;

import physique.Position;
import pile.PileSChainee;

import static physique.Direction.*;

import java.util.Random;

public class Donjon {

    //Constante de la classe
    private static final int NB_DIRECTION = 4;

    //Les attributs de la classe
    private Case depart;
    private Case fin;
    private Case[][] cases;
    private Random positionAlea = new Random();
    Configuration config = Configuration.getInstance();

    //Constructeur par defaut
    public Donjon(){

        cases = new Case[config.getConfig(Configuration.NB_LIGNES)]
                           [config.getConfig(Configuration.NB_COLONNES)];
        depart = getPositionAlea();
        // produit le labyrinthe
        this.produireLabyrinthe();
        // assigne la fin
        this.fin.setFin(true);
    }

    public Case getFin() { return fin; }

    public Case[][] getCases() { return cases; }

    public Case getPositionAlea() {

        return cases[positionAlea.nextInt(config.getConfig(Configuration.NB_LIGNES))]
                       [positionAlea.nextInt(config.getConfig(Configuration.NB_COLONNES))];
    }

    /**
     * --------------------À terminer----------------------
     *
     * @param position
     * @return
     */
    public int getNbVoisinsNonDeveloppe(Position position){

        int compte = 0;
        Position posVoisin = new Position();
        Case caseDonjon = null;

        for (int direction = 0; direction < NB_DIRECTION; direction++){

            posVoisin= directionAPosition(direction);
            position.additionnerPos(posVoisin);
            caseDonjon = new Case(posVoisin);

            if (!caseDonjon.getDeveloppe()){
                compte++;
            }
        }

        return compte;
    }

    /**
     * --------------------À terminer----------------------
     *
     * @param position
     * @return
     */
    public Position getVoisinAlea(Position position){

        Position pos;

        do {
            int direction = obtenirDirAlea();
            pos = directionAPosition(direction);
            position.additionnerPos(pos);
        }
        while (! new Case(pos).getDecouverte());

        return pos;
    }

    public Position getVoisinLibreAlea(Position position){

        Case cas = new Case(position);
        while (cas.getDeveloppe()){
            cas = new Case(getVoisinAlea(position));
        }

        return cas.getPos();
    }

    public void produireLabyrinthe(){

        Position position;
        Position posVoisin;
        Case cas;
        Case caseVoisin;
        int direction;

        // développe le labyrinthe a partir de la case départ
        // l'empile
        PileSChainee pile = new PileSChainee();
        depart = getPositionAlea();
        pile.empiler(depart);

        //tant que la pile n'est pas vide, continue
        while (!pile.estVide()){
            // prend la case du haut de la pile sans l’enlever
            cas = (Case) pile.regarder();
            // obtient sa position
            position = cas.getPos();
            // indique que cette case est maintenant développé
            cas.setDeveloppe(true);

            // vérifie si cette case a un voisin non-développé
            if (getNbVoisinsNonDeveloppe(position) != 0){

                // oui, choisit une case non-développé voisine au hasard
                caseVoisin = new Case(getVoisinLibreAlea(position));
                // obtient la position du voisin
                posVoisin = caseVoisin.getPos();
                // calcul la direction du voisin
                // position voisin moins position case courante
                // -> position à direction
                posVoisin.soustrairePos(position);
                direction = positionADirection(posVoisin);

                // ajoute à la case, comme voisin réciproque
                // appel à setVoisin pour les deux cases
                // note: la droite d'une case est la gauche de l'autre,
                // utiliser directionOpposee
                cas.setVoisin(direction, caseVoisin);
                caseVoisin.setVoisin(directionOpposee(direction), cas);
                // ajoute le voisin à la pile
                pile.empiler(caseVoisin);
                // définit la fin comme étant la dernière case développé
                this.fin = (Case)pile.regarder();
            }else {
                //sinon
                // il s'agit d'un cul-de-sac, dépile une case
                pile.depiler();
            }


        }




    }
}
