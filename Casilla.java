class Casilla{
    private int num;
    private boolean norte,sur,este,oeste;

    public Casilla(int num, boolean norte, boolean sur, boolean oeste, boolean este){
        this.num = num;
        this.norte=norte;
        this.sur=sur;
        this.oeste=oeste;
        this.este = este;
    }

    public Casilla(){};

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isNorte() {
        return norte;
    }

    public void setNorte(boolean norte) {
        this.norte = norte;
    }

    public boolean isSur() {
        return sur;
    }

    public void setSur(boolean sur) {
        this.sur = sur;
    }

    public boolean isEste() {
        return este;
    }

    public void setEste(boolean este) {
        this.este = este;
    }

    public boolean isOeste() {
        return oeste;
    }

    public void setOeste(boolean oeste) {
        this.oeste = oeste;
    }

    
}