package com._604robotics.robotnik.inspector.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoadingWindow extends JFrame {
    public LoadingWindow () {
        super("robotnik-inspector");
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLocation(64, 64);
        this.setSize(205, 50);
        
        this.setLayout(new BorderLayout());
        
        this.add(new JLabel(" ... Connecting to 10.6.4.2 ... "), BorderLayout.CENTER);
    }
}
