import io.codeforall.heapsforall.Grid;
import io.codeforall.heapsforall.Player;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid(20,20);
        new Player(0,0,grid);
    }
}
