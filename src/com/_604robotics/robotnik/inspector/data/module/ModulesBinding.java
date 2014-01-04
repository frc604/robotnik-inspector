package com._604robotics.robotnik.inspector.data.module;

import com._604robotics.robotnik.inspector.model.collection.NetworkSectionCollection;
import edu.wpi.first.wpilibj.tables.ITable;

public class ModulesBinding extends NetworkSectionCollection {
    public ModulesBinding (ITable table) {
        super("Modules", table);
    }

    @Override
    protected void bindSubTable (String name, ITable table) {
        this.addSection(new ModuleBinding(name, table.getSubTable(name)));
    }
}
