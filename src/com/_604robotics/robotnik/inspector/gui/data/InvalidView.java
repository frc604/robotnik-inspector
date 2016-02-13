package com._604robotics.robotnik.inspector.gui.data;

import javax.swing.JLabel;

public class InvalidView extends View {
    public InvalidView () {
        this.add(new JLabel("No matching type."));
    }
}
