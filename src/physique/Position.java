package physique;

public class Position {

    //Déclarations des membres de la classe
    private int i;
    private int j;

    //Constructeur par defaut
    public Position(){}

    //Constructeur par paramètre
    public Position(int i, int j){
        this.i = i;
        this.j = j;
    }

    //Constructeur par copie
    public Position(Position position){
        this.i = position.i;
        this.j = position.j;
    }

    //Accesseur pour la coordonnée i
    public int getI() { return i; }

    //Mutateur pour la coordonnée i
    public void setI(int i) { this.i = i; }

    //Accesseur pour la coordonnée j
    public int getJ() { return j; }

    //Mutateur pour la coordonnée j
    public void setJ(int j) { this.j = j; }

    /**
     * Cette methode permet de faire une copie profonde d'une position
     *
     * @return une copie profonde de la position
     */
    public Position clone(){ return new Position(this);}

    /**
     * Cette methode permet de comparer deux postions. Deux positions sont équales si les coordonnées i sont
     * équales et les coordonnées j aussi sont équales.
     *
     * @param position la position à comparer avec notre position actuelle
     * @return true si elles sont égales et false si elles ne le sont pas.
     */
    public boolean equals(Position position){ return this.i == position.i && this.j == position.j; }

    /**
     * Cette methode fais l'addition de 2 positions de telle sorte que :
     *      this.i += position.i
     *      this.j += position.j
     * @param position la position à additionner à notre position actuelle
     */
    public void additionnerPos(Position position){

        this.i += position.i;
        this.j += position.j;
    }

    /**
     * Cette methode fais la soustraction de 2 positions de telle sorte que :
     *      this.i -= position.i
     *      this.j -= position.j
     * @param position la position à soustraire à notre position actuelle
     */
    public void soustrairePos(Position position){

        this.i -= position.i;
        this.j -= position.j;
    }

    /**
     * Cette methode fais la multiplication de 2 positions de telle sorte que :
     *      this.i *= position.i
     *      this.j *= position.j
     * @param i la position à multiplier à notre position actuelle
     */
    public void multiplierPos(int i, int j){
//
//        this.i *= position.i;
//        this.j *= position.j;

        this.i *= i;
        this.j *= j;
    }

    @Override
    public String toString() {
        return "Position{ " + i + " , " + j + " }";
    }

}
