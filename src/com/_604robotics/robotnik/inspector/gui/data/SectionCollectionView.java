package com._604robotics.robotnik.inspector.gui.data;

import com._604robotics.robotnik.inspector.model.Section;
import com._604robotics.robotnik.inspector.model.collection.SectionCollection;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

public class SectionCollectionView extends View {
    private final JTabbedPane tabs = new JTabbedPane();
    
    public SectionCollectionView (SectionCollection data) {
        for (Section section : data.getSections()) {
            this.tabs.add(section.getName(), View.fromSection(section));
        }
        
        this.add(this.tabs, BorderLayout.CENTER);
    }
}
