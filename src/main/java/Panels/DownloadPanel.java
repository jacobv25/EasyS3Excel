package Panels;

import main.S3_Communicator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static main.MainWindow.*;

public class DownloadPanel extends JPanel {
    JButton downloadCSVButton;
    public DownloadPanel(){
        downloadCSVButton = new JButton("Download");
        init();
        add(downloadCSVButton);
        setVisible(true);
    }

    private void init(){
        downloadCSVButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                downloadFile();
            }
        });
    }

    private void downloadFile(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                S3_Communicator s3_communicator = new S3_Communicator();
                s3_communicator.downloadFile(file_path, bucket_name, key_name);
                return null;
            }
        };

        worker.execute();

    }
}
