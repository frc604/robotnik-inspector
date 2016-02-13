package com._604robotics.robotnik.inspector.model.map;

import com._604robotics.robotnik.inspector.model.Section;
import java.util.ArrayList;
import java.util.List;

public class DataMap extends Section {
    private final KeyValueModel map = new KeyValueModel();
    private final List<IChangeListener> changeListeners = new ArrayList<IChangeListener>();
    
    public DataMap (String name) {
        super(name);
    }
    
    public KeyValueModel getModel () {
        return this.map;
    }
    
    public void put (String key, String value) {
        this.map.put(key, value);
        
        for (IChangeListener changeListener : this.changeListeners) {
            changeListener.valueChanged(key, value);
        }
    }
    
    public void addChangeListener (IChangeListener changeListener) {
        this.changeListeners.add(changeListener);
    }
}
