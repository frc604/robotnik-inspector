package com._604robotics.robotnik.inspector.data.module;

import com._604robotics.robotnik.inspector.data.action.ActionsBinding;
import com._604robotics.robotnik.inspector.model.collection.SectionCollection;
import com._604robotics.robotnik.inspector.model.map.NetworkDataMap;
import edu.wpi.first.wpilibj.tables.ITable;

public class ModuleBinding extends SectionCollection {
    public ModuleBinding (String name, ITable table) {
        super(name);
        
        this.addSection(new ActionsBinding(table.getSubTable("actions")));
        this.addSection(new NetworkDataMap("Data", table.getSubTable("data")));
        this.addSection(new NetworkDataMap("Triggers", table.getSubTable("triggers")));
    }
}
