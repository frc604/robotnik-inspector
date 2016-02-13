package com._604robotics.robotnik.inspector.data.action;

import com._604robotics.robotnik.inspector.model.collection.SectionCollection;
import com._604robotics.robotnik.inspector.model.map.NetworkDataMap;
import edu.wpi.first.wpilibj.tables.ITable;

public class ActionsBinding extends SectionCollection {
    public ActionsBinding (ITable table) {
        super("Actions");
        
        this.addSection(new NetworkDataMap("Status", table.getSubTable("status")));
        this.addSection(new ActionFieldsBinding(table.getSubTable("data")));
    }
}
