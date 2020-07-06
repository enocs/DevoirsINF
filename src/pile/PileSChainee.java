package pile;

import java.util.EmptyStackException;

public class PileSChainee {

    private class Noeud{

        //Les attributs de la classe Noeud
        private Object element;
        private Noeud suivant;

        /**
         * Cet constructeur cree un nouveau Noeud contenant un autre Noeud existant comme suivant
         *
         * @param element : L'élément à stocker dans le Noeud
         * @param suivant : Le Noeud suivant celui qui a été crée
         */
        public Noeud(Object element, Noeud suivant){

            this.element = element;
            this.suivant = suivant;
        }

        /**
         * Cet contructeur crée un Noeud n'ayant pas de Noeud suivant.
         * @param element : L'élément à stocker dans le Noeud
         */
        public Noeud(Object element){ this(element, null); }



    }

    //Les attributs de la classe PileSChaine
    private int nombreElements = 0;
    private Noeud debut = null;

    /**
     * Cette methode permet d'obtenir le nombre d'éléments que contient la pile
     * @return le nombre d'elements qui sont dans la pile
     */
    public int getNombreElements(){ return nombreElements; }

    /**
     * Cette methode permet de savoir si la pile est vide ou non
     * @return true elle est vide et false dans le cas contraire
     */
    public boolean estVide() {
        return nombreElements == 0;
    }

    /**
     * Cette methode permet d'ajouter un element toujours au debut de la pile.
     * @param element : l'élément à ajouter à la pile
     */
    public void empiler(Object element) {

        //On ajoute l'élément au debut
        debut = new Noeud(element, debut);

        nombreElements++;  //On ajuste le nombre d'éléments
    }

    /**
     * Retire l'element au sommet de cette pile.
     *
     * ANTECEDENT : cette pile ne doit pas etre vide.
     * CONSEQUENT : cette pile contient un element de moins
     *             (celui qui etait au sommet avant l'appel).
     *
     * @return l'element retire de cette pile
     * @throws EmptyStackException si la pile est vide avant l'appel
     */
    public Object depiler() {

        //On vérifie si la pile est vide
        if (estVide()){
            throw new EmptyStackException();
        }
        //On recupère l'élément à retirer
        Object reponse = debut.element;

        //On enlève l'élément en deplaçant le debut.
        debut = debut.suivant;

        //On ajuste le nombre d'elements
        nombreElements--;  //ajustement du nombre d'elements

        return reponse;
    }

    /**
     * Cette methode retourne le l'element suivant
     * @return : Le prochain élément
     */
    public Object regarder(){

        if (estVide()){
            throw new EmptyStackException();
        }
        return debut.element;
    }


    public static void main(String[] args) {

        testPile();

    }

    private static void testPile() {

        System.out.println("---------------------------------------");
        System.out.println("---------------TEST PILE---------------");
        System.out.println("---------------------------------------");


        PileSChainee maPile = new PileSChainee();

        for(int i=0;i<10;i++) {
            try {
                maPile.empiler(i);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        for(int i=0;i<10;i++) {
            try {
                System.out.println(maPile.depiler());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
