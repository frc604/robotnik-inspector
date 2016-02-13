package com._604robotics.robotnik.inspector.model.map;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class KeyValueModel extends AbstractTableModel {
    private final Vector<String> keys = new Vector<String>();
    private final Vector<String> values = new Vector<String>();
    
    protected void put (String key, String value) {
        if (this.keys.contains(key)) {
            this.values.set(keys.indexOf(key), value);
        } else {
            this.keys.add(key);
            this.values.add(value);
        }
    }
    
    @Override
    public int getRowCount () {
        return this.keys.size();
    }

    @Override
    public int getColumnCount () {
        return 2;
    }

    @Override
    public Object getValueAt (int row, int column) {
        if (column == 0) {
            return this.keys.get(row);
        } else {
            return this.values.get(row);
        }
    }
}
