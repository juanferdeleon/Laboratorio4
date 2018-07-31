import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    private ArrayList<Wall> Walls;
    private ArrayList<PileOfCoins> pileOfCoins;
    private Robot robot;


    public static String[][] readMap(String userFile){
        try {

            int colCtr = 0;
            int rowCtr = 0;

            BufferedReader reader = new BufferedReader(new FileReader("" + userFile + ""));
            String currentLn = reader.readLine();
            BufferedReader reader2 = new BufferedReader(new FileReader("" + userFile + ""));
            String line = reader.readLine();

            colCtr = currentLn.length();

            while(currentLn != null){
                rowCtr += 1;
                currentLn = reader.readLine();
            }

            System.out.println("Ancho: " + colCtr);
            System.out.println("Alto: " + rowCtr);


            String [][] map = new String [rowCtr][colCtr];

            int y = 0;
            while (line != null && y < rowCtr){
                map[y] = line.split("()");
                line = reader2.readLine();
                y++;
            }

            return map;

        } catch (IOException exception) {

            System.out.println( "ERROR: No se ha encontrado el archivo." );
            return null;

        }

    }

    public  static void printMap(String[][] mapa){

        for(int j = 1; j < mapa.length; j++){
            for(int i = 0; i < mapa[j].length; i++){
                System.out.print(mapa[j][i]);
            }
            System.out.println("");
        }

    }

    public void setWalls(String[][] map){
        for(int j = 0; j < map.length; j++){
            for(int i = 0; i < map[j].length; i++){

            }
        }
    }


}
