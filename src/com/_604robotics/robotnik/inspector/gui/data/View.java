package com._604robotics.robotnik.inspector.gui.data;

import com._604robotics.robotnik.inspector.model.Section;
import com._604robotics.robotnik.inspector.model.collection.SectionCollection;
import com._604robotics.robotnik.inspector.model.map.DataMap;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public abstract class View extends JPanel {
    public static View fromSection (Section section) {
        if (section instanceof SectionCollection) {
            return new SectionCollectionView((SectionCollection) section);
        } else if (section instanceof DataMap) {
            return new DataMapView((DataMap) section);
        } else {
            return new InvalidView();
        }
    }
    
    public View () {
        this.setLayout(new BorderLayout());
    }
}
