package physique;

import java.util.Random;

public class Direction {

    //Déclaration des Constantes publiques de la classe
    public static final int HAUT = 0;
    public static final int BAS = 1;
    public static final int GAUCHE = 2;
    public static final int DROITE = 3;

    //Déclaration de la constant aléotoir
    private static final int VALEUR_MAX = 3;

    //Déclaration des champs membres de la classe
    private static Random random = new Random();

    /**
     * Cette méthode permet d'obtenir la direction opposée à cell reçu en paramètre.
     *
     * @param direction : La direction à permuter par son opposé
     * @return l'opposé de la direction reçu en paramètre
     */
    public static int directionOpposee(int direction){

        //Déclaration de la diraction à retourner
        int directRetour;

        //Permutation des directions
        switch (direction){
            case HAUT:
                directRetour = BAS;
                break;
            case BAS:
                directRetour = HAUT;
                break;
            case GAUCHE:
                directRetour = DROITE;
                break;
            case DROITE:
                directRetour = GAUCHE;
                break;
            default:
                directRetour = -1;
        }

        return directRetour;
    }

    /**
     * Cette methode permet de convertir une direction en sa représentation Position
     *
     * @param direction : La direction à convertir
     * @return La position de la direction reçu en paramètre
     */
    public static Position directionAPosition(int direction){

        //Declaration de la position à retourner
        Position position = new Position();

        //Conversion de la direction vers la position
        switch (direction){

            case HAUT:
                position = new Position(-1,0);
                break;
            case BAS:
                position = new Position(1,0);
                break;
            case GAUCHE:
                position = new Position(0,-1);
                break;
            case DROITE:
                position = new Position(0,1);
                break;
        }

        return position;
    }

    /**
     * Cette methode permet de convertir une position en sa représentation Direction
     *
     * @param position : La position à convertir
     * @return La direction de la position reçu en paramètre
     */
    public static int positionADirection(Position position){

        //Déclaration de la direction à retourner
        int directRetour;

        //On compare les positions et on fait la conversion
        if (position.equals(new Position(-1,0))){

            directRetour = HAUT;
        } else if (position.equals(new Position(1,0))){

            directRetour = BAS;
        }else if (position.equals(new Position(0,-1))){

            directRetour = GAUCHE;
        }else if (position.equals(new Position(0,1))){

            directRetour = DROITE;
        } else {
            directRetour = -1;
        }

        return directRetour;
    }

    /**
     * Cette methode permet d'obtenir une direction aléatoire
     *
     * @return la direction générée de façon aléatoire.
     */
    public static int obtenirDirAlea(){ return random.nextInt(VALEUR_MAX);}

}
