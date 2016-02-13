package com._604robotics.robotnik.inspector.data.action;

import com._604robotics.robotnik.inspector.model.collection.NetworkSectionCollection;
import com._604robotics.robotnik.inspector.model.map.NetworkDataMap;
import edu.wpi.first.wpilibj.tables.ITable;

public class ActionFieldsBinding extends NetworkSectionCollection {
    public ActionFieldsBinding (ITable table) {
        super("Fields", table);
    }

    @Override
    protected void bindSubTable (String name, ITable table) {
        this.addSection(new NetworkDataMap(name, table.getSubTable(name)));
    }
}
