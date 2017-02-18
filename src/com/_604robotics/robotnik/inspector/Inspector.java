package com._604robotics.robotnik.inspector;

import com._604robotics.robotnik.inspector.gui.InspectorWindow;
import com._604robotics.robotnik.inspector.gui.LoadingWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inspector {
    public static void main (String[] args) {
        final LoadingWindow loadingWindow = new LoadingWindow();
        loadingWindow.setVisible(true);
        
        NetworkTable.setClientMode();
        NetworkTable.setTeam(604);
        
        final NetworkTable table = NetworkTable.getTable("robotnik");
        
        while (!table.isConnected()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(InspectorWindow.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        loadingWindow.setVisible(false);
        
        final InspectorWindow inspectorWindow = new InspectorWindow(table);
        inspectorWindow.setVisible(true);
    }
}
