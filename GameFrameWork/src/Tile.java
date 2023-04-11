import java.util.*;

public class Tile {
    private int xPosition;
    private int yPosition;

    private List units;

    public Tile(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.units = new LinkedList();
    }

    public List getUnits(){
        return units;
    }

    public void setUnit(Unit unit){
        units.add(unit);
    }

    public void removeUnit(Unit unit){
        units.remove(unit);
    }


}
