package com._604robotics.robotnik.inspector.gui.data;

import com._604robotics.robotnik.inspector.model.map.DataMap;
import com._604robotics.robotnik.inspector.model.map.IChangeListener;
import java.awt.BorderLayout;
import javax.swing.JTable;

public class DataMapView extends View implements IChangeListener {
    private final JTable table = new JTable();
    
    public DataMapView (DataMap data) {
        this.table.setModel(data.getModel());
        this.add(this.table, BorderLayout.CENTER);
        
        data.addChangeListener(this);
    }

    @Override
    public void valueChanged (String key, String value) {
        this.table.repaint();
    }
}
