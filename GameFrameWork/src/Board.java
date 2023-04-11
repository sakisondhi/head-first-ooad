import java.util.ArrayList;
import java.util.Map;

public class Board {
    private int width;
    private int height;

    private ArrayList<ArrayList<Tile>> tileBoard;

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        tileBoard = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            ArrayList<Tile> row = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                row.add(new Tile(i, j));
            }
            tileBoard.add(row);
        }
    }

    public Tile getTileAtPosition(int xPosition, int yPosition){
        return tileBoard.get(xPosition).get(yPosition);
    }

    public Map getTileUnits(int xPosition, int yPosition) {
        return tileBoard.get(xPosition).get(yPosition).getUnits();
    }

    public void addUnitToTile(int xPosition, int yPosition, String unit, Object unitValue) {
        tileBoard.get(xPosition).get(yPosition).setUnit(unit, unitValue);
    }
}
