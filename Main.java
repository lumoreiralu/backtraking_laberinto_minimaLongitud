import java.util.Random;

public class Main {
    
    public static void llenarMat(Casilla[][] mat) {
        Random rand = new Random();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == 0 && j == 0) {
                    mat[i][j] = new Casilla(4, true, true, false, true);
                } else {
                    int valorAleatorio = rand.nextInt(10) + 1;
                    mat[i][j] = new Casilla(
                        valorAleatorio, 
                        rand.nextBoolean(), // norte
                        rand.nextBoolean(), // sur
                        rand.nextBoolean(), // oeste
                        rand.nextBoolean()  // este
                    );
                }
            }
        }
    }
    public static void main(String[] args) {
        Casilla[][] mat = new Casilla[5][5];
        llenarMat(mat);

        Laberinto miLaberinto = new Laberinto(mat);
        int resultado = miLaberinto.caminoMenorLongitud(mat,0, 0, 4, 4);

        if (resultado == Integer.MAX_VALUE) {
            System.out.println("No hay un camino posible.");
        } else {
            System.out.println("La longitud del camino mínimo es: " + resultado);
        }

        for(int i = 0; i<mat.length ; i ++){
            for(int j = 0; j<mat[i].length; j++){
                System.out.println("|" + mat[i][j].getNum() +" norte: "+ mat[i][j].isNorte() + " sur: " +mat[i][j].isSur() + " este: " +mat[i][j].isEste() + " oeste: " + mat[i][j].isOeste()  + "|");
            }
        }
    }
}