import java.util.ArrayList;

public class PileOfCoins {

    private int row;
    private int column;
    private ArrayList<Coin> amountOfCoins = new ArrayList<>();

    public PileOfCoins(int row, int column){
        this.setRow(row);
        this.setColumn(column);
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    public void setAmountOfCoins (Coin coin){
        this.amountOfCoins.add(coin);
    }

    public ArrayList<Coin> getAmountOfCoins(){
        return amountOfCoins;
    }

    public void removeCoin(){
        this.amountOfCoins.remove(0);
    }

}
