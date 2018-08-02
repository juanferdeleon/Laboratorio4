import java.util.ArrayList;
import java.util.Scanner;

public class Laboratorio3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Map Mapa = new Map();

        System.out.print("Ingrese direccion del Mapa: ");
        String userFile = input.nextLine();

        String [][] map = Mapa.readMap(userFile);
        Mapa.printMap(map);
        Mapa.setObjects(map);

        System.out.print("Ingrese direccion de las instrucciones: ");
        userFile = input.nextLine();
        ArrayList<String> instructions = Mapa.giveInstructions(userFile);
        Mapa.executeInstructions(map, instructions);

    }

}
