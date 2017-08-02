/**
 * Created by davlet on 8/1/17.
 */
public class Ball {
    private int id;
    private int X;
    private int Y;
    private boolean isInHole;

    public Ball(int id, int x, int y) {
        this.id = id;
        X = x - 1;
        Y = y - 1;
        isInHole = false;
    }

    public void rollBallOneStep(RollDirection direction, int xLength, int yLength){
        switch (direction){
            case NORTH:
                Y--;
                if (Y < 0) Y = 0;
                break;
            case SOUTH:
                Y++;
                if (Y > xLength) Y = xLength;
                break;
            case EAST:
                X++;
                if (X > yLength) X = yLength;
                break;
            case WEST:
                X--;
                if (X < 0) X = 0;
                break;
        }
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public boolean isInHole() {
        return isInHole;
    }

    public void setInHole(boolean inHole) {
        isInHole = inHole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
