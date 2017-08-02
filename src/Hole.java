/**
 * Created by davlet on 8/1/17.
 */
public class Hole {
    private int id;
    private int X;
    private int Y;
    private boolean isClosed;

    public Hole(int id, int x, int y, boolean isClosed) {
        this.id = id;
        X = x - 1;
        Y = y - 1;
        this.isClosed = isClosed;
    }

    public Hole(int id, int x, int y) {
        this.id = id;
        X = x - 1;
        Y = y - 1;
        isClosed = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
