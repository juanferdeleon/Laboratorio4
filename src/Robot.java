import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Robot {

    private int row;
    private int column;
    private int direction;
    private ArrayList<Coin> amountOfCoins = new ArrayList<>();

    private static final int DIR_UP = 0;
    private static final int DIR_RIGHT = 1;
    private static final int DIR_DOWN = 2;
    private static final int DIR_LEFT = 3;

    public Robot(int row, int column){
        this.setRow(row);
        this.setColumn(column);
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public void setDirection(String map){
        if (map.equals("^")){
            this.direction = DIR_UP;
        }
        if (map.equals(">")){
            this.direction = DIR_RIGHT;
        }
        if (map.equals("v")){
            this.direction = DIR_DOWN;
        }
        if (map.equals("<")){
            this.direction = DIR_LEFT;
        }
    }

    public int getDirection (){
        return this.direction;
    }

    public static ArrayList<String> readInstructions(String userFile){
        try {

            ArrayList<String> instructions = new ArrayList<>();

            BufferedReader reader = new BufferedReader(new FileReader("" + userFile + ""));
            String currentLn = reader.readLine();

            while(currentLn != null){
                instructions.add(currentLn);
                currentLn = reader.readLine();
            }

            return instructions;

        } catch (IOException exception) {

            System.out.println( "ERROR: No se ha encontrado el archivo." );
            return null;

        }
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public void move(){

        if (this.direction == DIR_UP){
            this.row -= 1;
        }
        if (this.direction == DIR_RIGHT){
            this.column += 1;
        }
        if (this.direction == DIR_DOWN){
            this.row += 1;
        }
        if (this.direction == DIR_LEFT){
            this.column -=1;
        }

    }

    public void dontMove(){

        if (this.direction == DIR_UP){
            this.row += 1;
        }
        if (this.direction == DIR_RIGHT){
            this.column -= 1;
        }
        if (this.direction == DIR_DOWN){
            this.row -= 1;
        }
        if (this.direction == DIR_LEFT){
            this.column +=1;
        }

    }

    public void rotate(){

        if (getDirection() == DIR_UP){
            this.direction = DIR_RIGHT;
            return;
        }
        if (getDirection() == DIR_RIGHT){
            this.direction = DIR_DOWN;
            return;
        }
        if (getDirection() == DIR_DOWN){
            this.direction = DIR_LEFT;
            return;
        }
        if (getDirection() == DIR_LEFT){
            this.direction = DIR_UP;
            return;
        }

    }

    public void pick(Coin coin){
        this.amountOfCoins.add(coin);
    }

    @Override
    public String toString(){
        if (this.direction == DIR_UP) return "^";
        if (this.direction == DIR_RIGHT) return ">";
        if (this.direction == DIR_DOWN) return "v";
        if (this.direction == DIR_LEFT) return "<";
        return "" ;
    }

}
