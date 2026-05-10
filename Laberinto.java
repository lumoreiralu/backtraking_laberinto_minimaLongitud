public class Laberinto {
    private Casilla[][] mat;
    private int maxFil;
    private int maxCol;

    public Laberinto(Casilla[][] mat) {
        this.mat = mat;
        this.maxFil = mat.length;
        this.maxCol = mat[0].length;
    }

    public Casilla[][] getMat() {
        return mat;
    }

    public void setMat(Casilla[][] mat) {
        this.mat = mat;
    }

    public int getMaxFil() {
        return maxFil;
    }

    public void setMaxFil(int maxFil) {
        this.maxFil = maxFil;
    }

    public int getMaxCol() {
        return maxCol;
    }

    public void setMaxCol(int maxCol) {
        this.maxCol = maxCol;
    }

    public int caminoMenorLongitud(Casilla[][]mat, int fi, int ci, int ff, int cf){
        int filas = mat.length;
        int columnas = mat[0].length;
        boolean[][] visitados = new boolean[filas][columnas];
        int resultado = buscarCaminoMenorLongitud(mat, fi, ci, ff, cf, visitados);
        if(resultado == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return resultado;
    }
    
    private int buscarCaminoMenorLongitud(Casilla[][]mat, int fi, int ci, int ff, int cf, boolean[][]visitados){
        if((fi==ff)&&(ci==cf)){
            return mat[fi][ci].getNum();
        }
    
        visitados[fi][ci] = true;
        int minRestante = Integer.MAX_VALUE;
    
        if(mat[fi][ci].isNorte() && fi>0 && !visitados[fi-1][ci]){
            int res = buscarCaminoMenorLongitud(mat, fi-1, ci, ff, cf, visitados);
            if(res!=Integer.MAX_VALUE){
                minRestante=Math.min(minRestante, res);
            }
        }
        if(mat[fi][ci].isSur() && fi<mat.length-1 && !visitados[fi+1][ci]){
            int res = buscarCaminoMenorLongitud(mat, fi+1, ci, ff, cf, visitados);
            if(res!=Integer.MAX_VALUE){
                minRestante=Math.min(minRestante, res);
            }
        }
    
        if(mat[fi][ci].isOeste() && ci>0 && !visitados[fi][ci-1]){
            int res = buscarCaminoMenorLongitud(mat, fi, ci-1, ff, cf, visitados);
            if(res!=Integer.MAX_VALUE){
                minRestante=Math.min(minRestante, res);
            }
        }
        
        if(mat[fi][ci].isEste() && ci<mat[0].length && !visitados[fi][ci+1]){
            int res = buscarCaminoMenorLongitud(mat, fi, ci+1, ff, cf, visitados);
            if(res!=Integer.MAX_VALUE){
                minRestante=Math.min(minRestante, res);
            }
        }
    
        visitados[fi][ci] = false;
        if(minRestante == Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        return mat[fi][ci].getNum() + minRestante;
    }
}
