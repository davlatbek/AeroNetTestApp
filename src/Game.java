import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by davlet on 8/1/17.
 */
public class Game {
    Board board;

    public String solve(int tableDimension, int numberOfBalls, int numberOfHoles,
                      List<Ball> ballList, List<Hole> holeList, List<Wall> wallList){
        this.board = new Board(tableDimension, tableDimension, ballList, holeList, wallList);
        return this.board.findSolution();
    }

    public static void main(String[] args) {
        int dimensions = 0, numberOfBalls = 0, numberOfHoles = 0;
        List<Ball> ballList = new ArrayList<>();
        List<Hole> holeList = new ArrayList<>();
        List<Wall> wallList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("./test1.txt"))) {
            String lineSplitted[];
            int number = 0;
            lineSplitted = bufferedReader.readLine().split(" ");
            dimensions = Integer.parseInt(lineSplitted[number++]);
            numberOfBalls = Integer.parseInt(lineSplitted[number++]);
            numberOfHoles = Integer.parseInt(lineSplitted[number++]);

            for (int i = 0; i < numberOfBalls; i++) {
                ballList.add(new Ball(i,
                        Integer.parseInt(lineSplitted[number++]),
                        Integer.parseInt(lineSplitted[number++])));
            }

            for (int i = 0; i < numberOfHoles; i++) {
                holeList.add(new Hole(i,
                        Integer.parseInt(lineSplitted[number++]),
                        Integer.parseInt(lineSplitted[number++])));
            }

            for (int i = number; i < (lineSplitted.length - number) / 4; i++) {
                wallList.add(new Wall(
                        Integer.parseInt(lineSplitted[number++]),
                        Integer.parseInt(lineSplitted[number++]),
                        Integer.parseInt(lineSplitted[number++]),
                        Integer.parseInt(lineSplitted[number++])));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Game game = new Game();
        game.writeResultsToFile(game.solve(
                dimensions,
                numberOfBalls, numberOfHoles,
                ballList, holeList, wallList));
    }

    public void writeResultsToFile(String resultPath){
        File file = new File("result.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write(resultPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public void
}
