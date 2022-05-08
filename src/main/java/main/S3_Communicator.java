package main;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

import java.io.File;

public class S3_Communicator {

    public void downloadFile(String file_path, String bucket_name, String key_name){
        File f = new File(file_path);
        TransferManager xfer_mgr = TransferManagerBuilder.standard().build();
        try {
            Download xfer = xfer_mgr.download(bucket_name, key_name, f);
            //loop with Transfer.isDone()
            XferMgrProgress.showTransferProgress(xfer);
            //or block with Transfer.waitForCompletion()
            XferMgrProgress.waitForCompletion(xfer);
        } catch (AmazonServiceException e) {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        xfer_mgr.shutdownNow();
    }

}
