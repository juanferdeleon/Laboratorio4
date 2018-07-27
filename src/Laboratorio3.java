import java.util.Scanner;

public class Laboratorio3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Map Mapa = new Map();

        System.out.print("Ingrese direccion del Mapa: ");
        String userFile = input.nextLine();

        Mapa.readMap(userFile);

        

    }

}
