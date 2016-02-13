package com._604robotics.robotnik.inspector.gui;

import com._604robotics.robotnik.inspector.data.module.ModulesBinding;
import com._604robotics.robotnik.inspector.gui.data.View;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.awt.BorderLayout;
import javax.swing.JFrame;

public class InspectorWindow extends JFrame {
    public InspectorWindow (NetworkTable table) {
        super("robotnik-inspector");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLocation(64, 64);
        this.setSize(800, 600);
        
        this.setLayout(new BorderLayout());
        
        this.add(View.fromSection(new ModulesBinding(table.getSubTable("modules"))), BorderLayout.CENTER);
    }
}
