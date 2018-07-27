import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class Map {

    private ArrayList<Wall> Walls;
    private ArrayList<PileOfCoins> pileOfCoins;
    private Robot robot;


    public static void readMap(String userFile){


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


            String [][] map = new String [rowCtr][colCtr];

            int y = 0;
            while (line != null && y < rowCtr){
                map[y] = line.split("()");
                line = reader2.readLine();
                y++;
            }

            for (int j = 0; j < rowCtr; j++){
                for (int i = 0; i < colCtr; i++){
                    System.out.print(map[j][i]);
                }
                System.out.println("");
            }

        } catch (IOException exception) {

            System.out.println( "ERROR: No se ha encontrado el archivo." );

        }

    }



}
