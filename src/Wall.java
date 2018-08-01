public class Wall {

    private int row;
    private int column;

    public Wall(int row, int column){
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

}
