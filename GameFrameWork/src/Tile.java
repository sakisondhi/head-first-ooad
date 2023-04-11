import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tile {
    private int xPosition;
    private int yPosition;

    private Map<String, Object> unitMap;

    public Tile(int xPosition, int yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        unitMap = new HashMap<>();
    }

    public Map<String, Object> getUnits(){
        return unitMap;
    }

    public void setUnit(String unit, Object unitValue){
        unitMap.put(unit, unitValue);
    }

    public void removeUnit(String unit){
        unitMap.remove(unit);
    }


}
