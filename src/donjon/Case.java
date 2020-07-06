package donjon;

import physique.Direction;
import physique.Position;

import java.util.Arrays;

public class Case {

    //Constantes de la classe
    private final int NOMBRE_VOISINS = 4;

    //Les attributs de la classe
    Position position;
    private boolean decouverte;
    private boolean fin;
    private boolean developpe;
    private String[][] voisin = new String[NOMBRE_VOISINS][NOMBRE_VOISINS];

    //Constructeurs de la classe
    public Case(Position position){
        this.position.setI(position.getI());
        this.position.setJ(position.getJ());
    }

    /**
     * Petmet d'obtenir une copie de la position
     * @return la copie de la position membre
     */
    public Position getPosition() { return position.clone(); }

    public boolean getDeveloppe(){ return developpe; }

    public void setDeveloppe(boolean developpe){ this.developpe = developpe;}

    public boolean getDecouverte() { return decouverte; }

    public void setDecouverte(boolean decouverte) { this.decouverte = decouverte; }

    public boolean getFin() { return fin; }

    public void setFin(boolean fin) { this.fin = fin; }

    public String getVoisin(int direction) { return voisin[direction][direction]; }

    public void setVoisin(String voisin, int direction) { this.voisin[direction][direction] = voisin; }

    @Override
    public String toString() {
        return "Case{" + " position=" + position + ", decouverte=" + decouverte + ", fin=" + fin +
                ", developpe=" + developpe + ", voisin=" + Arrays.toString(voisin) + "}";
    }
}
