import dijkstra.Edge;
import dijkstra.Graph;
import dijkstra.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davlet on 8/1/17.
 */
public class Board {
    private int mRowsCount;
    private int mColumnsCount;
    /**
     * if cell has ball, then its value = 1;
     * if it has hole, then value = -1;
     * if it is empty, then value = 0;
     */
    private int[][] table;
    private int[][] wallMatrix;
    private List<Ball> balls;
    private List<Hole> holes;
    private List<Wall> walls;

    public Board(int mRowsCount, int mColumnsCount, List<Ball> balls, List<Hole> holes, List<Wall> walls) {
        this.mRowsCount = mRowsCount;
        this.mColumnsCount = mColumnsCount;
        this.table = new int[mRowsCount][mColumnsCount];

        this.balls = balls;
        addBalls(balls);
        printTable();

        this.holes = holes;
        addHoles(holes);
        printTable();

        this.walls = walls;
        this.wallMatrix = new int[mRowsCount][mColumnsCount];
    }

    public void printTable(){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int getmRowsCount() {
        return mRowsCount;
    }

    public void setmRowsCount(int mRowsCount) {
        this.mRowsCount = mRowsCount;
    }

    public int getmColumnsCount() {
        return mColumnsCount;
    }

    public void setmColumnsCount(int mColumnsCount) {
        this.mColumnsCount = mColumnsCount;
    }

    public int[][] getTable() {
        return table;
    }

    public void setTable(int[][] table) {
        this.table = table;
    }


    public void addBalls(List<Ball> ballList){
        for (Ball ball : ballList){
            table[ball.getX()][ball.getY()] = 1;
        }
    }

    public void addHoles(List<Hole> holeList){
        for (Hole hole : holeList){
            table[hole.getX()][hole.getY()] = -1;
        }
    }

    public void tiltNorth(){
        Point wallLocation;
        for (Ball ball : balls) {
            ball.rollBallOneStep(RollDirection.NORTH, table.length - 1, table.length - 1);
            //if there is a hole on it direction, then close hole and delete ball
            if (processHole(RollDirection.NORTH, ball)){
                //success
            } else {
                wallLocation = getWallLocationOnItsWay(RollDirection.NORTH, ball);
                if (wallLocation == null){
                    //set in the 0th row of table
                    ball.setX(0);
                } else {
                    ball.setX(wallLocation.x);
                }
            }
        }
    }

    public void tiltSouth(){

    }

    public void tiltEast(){

    }

    public void tiltWest(){

    }

    public boolean processHole(RollDirection direction, Ball ball){
        if (direction == RollDirection.NORTH){
            for (Hole hole : holes){
                if (ball.getY() == hole.getY() && ball.getX() == hole.getX()){
                    ball.setInHole(true);
                    hole.setClosed(true);
                    return true;
                }
            }
        }
        return false;
    }

    public Point getWallLocationOnItsWay(RollDirection direction, Ball ball){
        if (direction == RollDirection.NORTH){
            return hasWallOnVerticalMove(ball.getX(), ball.getY());
        }
        return null;
    }

    public Point hasWallOnVerticalMove(int x, int y){
        for (Wall wall : walls){
            if (!wall.isVertical){
                //if wall is on the way
                if (wall.columnNumber1 == y && wall.rowNumber2 < x){
                    return new Point(wall.columnNumber1, wall.rowNumber2);
                }
            }
        }
        return null;
    }

    public String findSolution(){
        return "";
    }

    public Graph generateGraphFromTable(){
        List<Vertex> vertices = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();

        for (Ball ball : balls){

        }
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                vertices.add(new Vertex("id " + i, i, j));
            }
        }

        Graph graph = new Graph(vertices, edges);

        return graph;
    }
}
