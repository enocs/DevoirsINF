package donjon;

import physique.Position;

import java.util.Arrays;

public class Case {

    //Constantes de la classe
    private final int NOMBRE_VOISINS = 4;

    //Les attributs de la classe
    Position pos = new Position();
    private boolean decouverte;
    private boolean fin;
    private boolean developpe;
    private Case[] voisin = new Case[NOMBRE_VOISINS];

    //Constructeurs de la classe
    public Case(Position pos){

        this.pos.setI(pos.getI());
        this.pos.setJ(pos.getJ());
    }

    /**
     * Petmet d'obtenir une copie de la position
     * @return la copie de la position membre
     */
    public Position getPos() { return this.pos.clone(); }

    public boolean getDeveloppe(){ return developpe; }

    public void setDeveloppe(boolean developpe){ this.developpe = developpe;}

    public boolean getDecouverte() { return decouverte; }

    public void setDecouverte(boolean decouverte) { this.decouverte = decouverte; }

    public boolean getFin() { return fin; }

    public void setFin(boolean fin) { this.fin = fin; }

    public Case getVoisin(int direction) { return voisin[direction]; }

    public void setVoisin(int direction, Case cases) { voisin[direction] = cases; }

    @Override
    public String toString() {
        return "Case{" + " position=" + pos + ", decouverte=" + decouverte + ", fin=" + fin +
                ", developpe=" + developpe + ", voisin=" + Arrays.toString(voisin) + "}";
    }
}
