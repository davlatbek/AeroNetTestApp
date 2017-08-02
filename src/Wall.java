/**
 * Created by davlet on 8/1/17.
 */
public class Wall {
    boolean isVertical;
    int rowNumber1 = -1;
    int rowNumber2 = -1;
    int columnNumber1 = -1;
    int columnNumber2 = -1;

    public Wall(int x1, int y1,
                int x2, int y2) {
        if (y1 == y2){
            isVertical = false;
            this.columnNumber1 = y1 - 1;
            this.rowNumber1 = x1 - 1;
            this.rowNumber2 = x2 - 1;
        } else if (x1 == x2){
            isVertical = true;
            this.rowNumber1 = x1 - 1;
            this.columnNumber1 = y1 - 1;
            this.columnNumber2 = y2 - 1;
        }
    }

    public boolean isVertical() {
        return isVertical;
    }

    public void setVertical(boolean vertical) {
        isVertical = vertical;
    }

    public int getRowNumber1() {
        return rowNumber1;
    }

    public void setRowNumber1(int rowNumber1) {
        this.rowNumber1 = rowNumber1;
    }

    public int getRowNumber2() {
        return rowNumber2;
    }

    public void setRowNumber2(int rowNumber2) {
        this.rowNumber2 = rowNumber2;
    }

    public int getColumnNumber1() {
        return columnNumber1;
    }

    public void setColumnNumber1(int columnNumber1) {
        this.columnNumber1 = columnNumber1;
    }

    public int getColumnNumber2() {
        return columnNumber2;
    }

    public void setColumnNumber2(int columnNumber2) {
        this.columnNumber2 = columnNumber2;
    }
}
