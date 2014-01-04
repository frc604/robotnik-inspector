package com._604robotics.robotnik.inspector.model.collection;

import com._604robotics.robotnik.inspector.model.Section;
import java.util.ArrayList;
import java.util.List;

public abstract class SectionCollection extends Section {
    private final List<Section> sections = new ArrayList<Section>();
    private final List<ISectionListener> listeners = new ArrayList<ISectionListener>();
    
    public SectionCollection (String name) {
        super(name);
    }
    
    protected void addSection (Section section) {
        this.sections.add(section);
        
        for (ISectionListener listener : this.listeners) {
            listener.newSection(section);
        }
    }
    
    public Section[] getSections () {
        return this.sections.toArray(new Section[this.sections.size()]);
    }
    
    public void addListener (ISectionListener listener) {
        this.listeners.add(listener);
    }
}
