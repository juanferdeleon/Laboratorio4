import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Map {

    private ArrayList<Wall> Walls = new ArrayList<>();
    private ArrayList<PileOfCoins> pilesOfCoins = new ArrayList<>();
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

    public ArrayList<String> giveInstructions(String userFile){
        return this.robot.readInstructions(userFile);
    }

    public String[][] executeInstructions(String [][] map, ArrayList<String> instructions){
        for (String instruction : instructions) {
            if (instruction.contains("move")){

                int row = robot.getRow();
                int column = robot.getColumn();

                robot.move();
                if (isWall(robot.getRow(), robot.getColumn())){
                    robot.dontMove();
                }else{
                    map[row][column] = " ";
                    map[robot.getRow()][robot.getColumn()] = robot.toString();
                }

            }
            if (instruction.contains("rotate")){
                robot.rotate();
                map[robot.getRow()][robot.getColumn()] = robot.toString();
            }
            if (instruction.contains("pick")){
                if (isPileOfCoins(robot.getRow(), robot.getColumn())){
                    for (PileOfCoins pile: pilesOfCoins) {
                        if ((robot.getRow() == pile.getRow()) && (robot.getColumn() == pile.getColumn())){
                            robot.pick(pile.getAmountOfCoins().get(0));
                            pile.removeCoin();
                        }
                    }
                }
            }
            for (PileOfCoins pile: pilesOfCoins) {
                if ((robot.getRow() != pile.getRow()) || (robot.getColumn() != pile.getColumn())){
                    String setPile = Integer.toString(pile.getAmountOfCoins().size());
                    map[pile.getRow()][pile.getColumn()] = setPile;
                }
            }
            printMap(map);
        }
        return map;
    }

    public boolean isPileOfCoins(int row, int column){

        boolean isPileOfCoins = false;

        for (PileOfCoins pile: pilesOfCoins) {
            if ((row == pile.getRow()) && (column == pile.getColumn()) ){
                isPileOfCoins = true;
                return isPileOfCoins;
            }
        }

        return isPileOfCoins;
    }

    public boolean isWall(int row, int column){

        boolean isWall = false;

        for (Wall wall: Walls) {
            if ((row == wall.getRow()) && (column == wall.getColumn())){
                isWall = true;
                return isWall;
            }
        }
        return isWall;

    }

    public void printMap(String[][] mapa){

        for(int j = 1; j < mapa.length; j++){
            for(int i = 0; i < mapa[j].length; i++){
                System.out.print(mapa[j][i]);
            }
            System.out.println("");
        }

    }

    public void setObjects(String[][] map){

        for(int j = 1; j < map.length; j++){
            for(int i = 0; i < map[j].length; i++){

                if(map[j][i].matches("(\\d+)")){

                    int amountOfCoins = Integer.parseInt(map[j][i]);
                    PileOfCoins pileOfCoins = new PileOfCoins(j, i);
                    int ctr = 0;

                    while (ctr < amountOfCoins){
                        Coin coin = new Coin(j, i);
                        pileOfCoins.setAmountOfCoins(coin);
                        ctr++;
                    }

                    this.pilesOfCoins.add(pileOfCoins);

                }else{

                    if (map[j][i].equals("*")){
                        Wall wall = new Wall(j, i);
                        this.Walls.add(wall);
                    }
                    if (map[j][i].equals("<") || map[j][i].equals(">") || map[j][i].equals("^") || map[j][i].equals("v")){
                        Robot robot = new Robot(j, i);
                        robot.setDirection(map[j][i]);
                        this.robot = robot;
                    }

                }

            }
        }
    }

    public boolean checkWinner(String [][] map){

        boolean isWinner = false;
        int beeperCtr = 0;

        for(int j = 1; j < map.length; j++) {
            for (int i = 0; i < map[j].length; i++) {
                if(map[j][i].matches("(\\d+)")) {
                    beeperCtr += Integer.parseInt(map[j][i]);
                }
            }
        }

        if (beeperCtr == 0){
            isWinner = true;
            return isWinner;
        }

        return isWinner;
    }


}
