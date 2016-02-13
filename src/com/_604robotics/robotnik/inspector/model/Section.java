package com._604robotics.robotnik.inspector.model;

public abstract class Section {
    private final String name;
    
    public Section (String name) {
        this.name = name;
    }
    
    public String getName () {
        return this.name;
    }
}
