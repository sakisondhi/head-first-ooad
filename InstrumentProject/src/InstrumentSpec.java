import enums.Builder;
import enums.Type;
import enums.Wood;

import java.util.Iterator;
import java.util.Map;

public class InstrumentSpec {

    Map<Object, Object> propertiesMap;

    public InstrumentSpec(Map<Object, Object> propertiesMap){
        this.propertiesMap = propertiesMap;
    }

    public Map<Object, Object> getPropertiesMap(){
        return propertiesMap;
    }

    public Object getProperty(Object property){
        return propertiesMap.get(property);
    }

    public boolean matches(InstrumentSpec otherSpec){
        for(Iterator i = otherSpec.getPropertiesMap().keySet().iterator(); i.hasNext();){
            String propertyName = (String) i.next();
            if(!propertiesMap.getOrDefault(propertyName, "none").equals(otherSpec.getPropertiesMap().get(propertyName))){
                return false;
            }
        }
        return true;
    }
}
