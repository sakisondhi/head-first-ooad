import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {
    private int width;
    private int height;

    private List<List> tileBoard;

    private void initialize(){
        tileBoard = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            ArrayList<Tile> row = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                row.add(new Tile(i, j));
            }
            tileBoard.add(row);
        }
    }

    public Board(int width, int height){
        this.width = width;
        this.height = height;
        initialize();
    }

    public void removeUnitFromTile(int xPosition, int yPosition, String unit){
        ((Tile)tileBoard.get(xPosition).get(yPosition)).removeUnit(unit);
    }
    public Tile getTileAtPosition(int xPosition, int yPosition){
        return (Tile) tileBoard.get(xPosition).get(yPosition);
    }

    public Map getTileUnits(int xPosition, int yPosition) {
        return ((Tile)tileBoard.get(xPosition).get(yPosition)).getUnits();
    }

    public void addUnitToTile(int xPosition, int yPosition, String unit, Object unitValue) {
        ((Tile)tileBoard.get(xPosition).get(yPosition)).setUnit(unit, unitValue);

    }
}
