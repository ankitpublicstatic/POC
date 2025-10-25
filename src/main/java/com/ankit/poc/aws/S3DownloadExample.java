package com.ankit.poc.aws;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class S3DownloadExample {
  static String bucket = "my-bucket";
  static String key = "folder/big-file.zip";
  static Path destination = Paths.get("/tmp/big-file.zip");

  public static void main(String[] args) {

    S3Client s3 = S3Client.builder().region(Region.AP_SOUTHEAST_1) // choose appropriate
        .credentialsProvider(DefaultCredentialsProvider.create()).build();

    GetObjectRequest getReq = GetObjectRequest.builder().bucket(bucket).key(key).build();

    // This streams directly to file and is efficient for large files
    s3.getObject(getReq, ResponseTransformer.toFile(destination));

    System.out.println("Downloaded to: " + destination.toAbsolutePath());
    s3.close();
  }

  void getStream() {
    S3Client s3 = S3Client.builder().region(Region.AP_SOUTHEAST_1) // choose appropriate
        .credentialsProvider(DefaultCredentialsProvider.create()).build();

    GetObjectRequest req = GetObjectRequest.builder().bucket(bucket).key(key).build();

    ResponseBytes<GetObjectResponse> respBytes = s3.getObject(req, ResponseTransformer.toBytes());

    try (OutputStream out = Files.newOutputStream(destination, StandardOpenOption.CREATE)) {
      out.write(respBytes.asByteArray());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      s3.close();
    }

  }
}
