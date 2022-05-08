package main;

import Panels.DownloadPanel;

import javax.sound.midi.MidiUnavailableException;
import javax.swing.*;
import java.io.File;

public class MainWindow extends JFrame {
    public static final String home = System.getProperty("user.home");
//    File file = new File(home+"/Downloads/" + file_path);
    public static final String file_path = home+"/Downloads/" +"myFile0.csv";
    public static final String bucket_name = "ocrapplication2fc15f311960a489aa9941e0426f2916d201736-dev";
    public static final String key_name = "myFile0.csv";



    private DownloadPanel downloadPanel;
    public MainWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        downloadPanel = new DownloadPanel();
        add(downloadPanel);
//        pack();
        setSize(400,200);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    new MainWindow();
                }
        );
    }
}
