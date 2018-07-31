public class Wall {

    private int row;
    private int column;

    public Wall(int row, int column){
        this.setRow(row);
        this.setColumn(column);
    }

    private void setRow(int row){
        this.row = row;
    }

    private void setColumn(int column){
        this.column = column;
    }

}
