package com._604robotics.robotnik.inspector.model.map;

import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import java.util.HashSet;
import java.util.Set;

public class NetworkDataMap extends DataMap implements ITableListener {
    private final Set<String> knownKeys = new HashSet<String>();
    private final ITable table;
    
    public NetworkDataMap (String name, ITable table) {
        super(name);
        
        this.table = table;
        this.table.addTableListener("__index", this, false);
        
        this.scanKeys();
    }
    
    private void scanKeys () {
        final String[] keys = table.getString("__index", "").split(";");

        for (String key : keys) {
            if (!key.equals("") && !this.knownKeys.contains(key)) {
                this.knownKeys.add(key);
                
                try {
                    this.put(key, table.getValue(key).toString());
                } catch (TableKeyNotDefinedException ex) {
                    this.put(key, "");
                }

                table.addTableListener(key, this, false);
            }
        }
    }

    @Override
    public void valueChanged (ITable source, String key, Object value, boolean isNew) {
        if (key.equals("__index")) {
            this.scanKeys();
        } else {
            this.put(key, value.toString());
        }
    }
}
