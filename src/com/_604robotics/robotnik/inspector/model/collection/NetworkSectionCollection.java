package com._604robotics.robotnik.inspector.model.collection;

import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class NetworkSectionCollection extends SectionCollection implements ITableListener {
    private final Set<String> knownKeys = new HashSet<String>();
    
    private final ITable table;
    
    public NetworkSectionCollection (String name, ITable table) {
        super(name);
        
        this.table = table;
        this.table.addTableListener("__index", this, false);
        
        this.scanKeys();
    }
    
    protected abstract void bindSubTable (String name, ITable table);
    
    private void scanKeys () {
        final String[] keys = this.table.getString("__index", "").split(";");
        
        for (String key : keys) {
            if (!key.equals("") && !this.knownKeys.contains(key)) {
                this.knownKeys.add(key);
                
                this.bindSubTable(key, this.table);
            }
        }
    }

    @Override
    public void valueChanged (ITable source, String key, Object value, boolean isNew) {
        this.bindSubTable(key, this.table);
    }
}
