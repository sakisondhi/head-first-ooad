import com.sun.jmx.snmp.EnumRowStatus;
import enums.Builder;
import enums.InstrumentType;
import enums.Type;
import enums.Wood;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FindInstrument {

    public void initializeInventory(Inventory inventory){
        Map<Object, Object> propertiesMap = new HashMap<>();
        propertiesMap.put("instrumentType", InstrumentType.GUITAR);
        propertiesMap.put("builder", Builder.GIBSON);
        propertiesMap.put("backWood", Wood.MAPLE);
        InstrumentSpec instrumentSpec = new InstrumentSpec(propertiesMap);
        inventory.addInstrument("1234567r5tfh78", 6999.0, instrumentSpec);

        propertiesMap.clear();
        propertiesMap.put("instrumentType", InstrumentType.GUITAR);
        propertiesMap.put("builder", Builder.COLLINGS);
        propertiesMap.put("model", "CJ");
        propertiesMap.put("type", Type.ACCOUSTIC);
        propertiesMap.put("numStrings", 6);
        propertiesMap.put("backWood", Wood.INDIAN_ROSEWOOD);
        propertiesMap.put("topWood", Wood.SPRUCE);
        inventory.addInstrument("#11277", 3999.95, new InstrumentSpec(propertiesMap));

        propertiesMap.clear();
        propertiesMap.put("instrumentType", InstrumentType.GUITAR);
        propertiesMap.put("builder", Builder.MARTIN);
        propertiesMap.put("model", "D-18");
        propertiesMap.put("type", Type.ACCOUSTIC);
        propertiesMap.put("numStrings", 6);
        propertiesMap.put("backWood", Wood.MAHOGANY);
        propertiesMap.put("topWood", Wood.SPRUCE);
        inventory.addInstrument("#122784", 5495.95, new InstrumentSpec(propertiesMap));

        propertiesMap.clear();
        propertiesMap.put("instrumentType", InstrumentType.GUITAR);
        propertiesMap.put("builder", Builder.GIBSON);
        propertiesMap.put("model", "SG'61");
        propertiesMap.put("type", Type.ELECTRIC);
        propertiesMap.put("numStrings", 6);
        propertiesMap.put("backWood", Wood.MAHOGANY);
        propertiesMap.put("topWood", Wood.MAHOGANY);
        inventory.addInstrument("#82765501", 1890.95, new InstrumentSpec(propertiesMap));

        propertiesMap.clear();
        propertiesMap.put("instrumentType", InstrumentType.MANDOLINS);
        propertiesMap.put("builder", Builder.GIBSON);
        propertiesMap.put("model", "F5-G");
        propertiesMap.put("type", Type.ACCOUSTIC);
        propertiesMap.put("backWood", Wood.MAPLE);
        propertiesMap.put("topWood", Wood.MAPLE);
        inventory.addInstrument("#9019920", 5495.99, new InstrumentSpec(propertiesMap));

        propertiesMap.clear();
        propertiesMap.put("instrumentType", InstrumentType.BANJOS);
        propertiesMap.put("builder", Builder.GIBSON);
        propertiesMap.put("model", "RB-3");
        propertiesMap.put("type", Type.ACCOUSTIC);
        propertiesMap.put("numStrings", 5);
        propertiesMap.put("backWood", Wood.MAPLE);
        inventory.addInstrument("#8900231", 2945.95, new InstrumentSpec(propertiesMap));
    }
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        new FindInstrument().initializeInventory(inventory);

        Map<Object, Object> properties = new HashMap<>();
        properties.put("builder", Builder.GIBSON);
        properties.put("backWood", Wood.MAPLE);

        InstrumentSpec clientSpec = new InstrumentSpec(properties);

        List matchingInstruments = inventory.search(clientSpec);
        if(!matchingInstruments.isEmpty()){
            System.out.println("You might like these Instruments: ");
            for (Iterator i = matchingInstruments.iterator(); i.hasNext(); ){
                Instrument instrument = (Instrument) i.next();
                InstrumentSpec instrumentSpec = instrument.getSpec();
                System.out.println(" We have an Instrument : " +
                        instrumentSpec.getProperty("instrumentType") + " with following properties: ");
                for (Iterator j = instrumentSpec.getPropertiesMap().keySet().iterator(); j.hasNext();){
                    String propertyName = (String) j.next();
                    if(propertyName.equals("instrumentType")) continue;

                    System.out.println("   " + propertyName + " : " + instrumentSpec.getProperty(propertyName));
                }
                System.out.println("This Instrument is of price: " + instrument.getPrice() + "\n----");
            }
        }
        else{
            System.out.println("Sorry, We have nothing for you..!");
        }
    }


}
