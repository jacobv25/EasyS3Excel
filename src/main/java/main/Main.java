package main;

public class Main {
    public static void main(String[] args) {
        String file_path = "myFile0.csv";
        String bucket_name = "ocrapplication2fc15f311960a489aa9941e0426f2916d201736-dev";
        String key_name = "myFile0.csv";
        S3_Communicator s3_communicator = new S3_Communicator();
        s3_communicator.downloadFile(file_path, bucket_name, key_name);
    }
}
