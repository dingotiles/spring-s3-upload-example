package com.dingotiles.s3example;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.Upload;
import com.dingotiles.connector.s3.info.S3ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jcarter on 19/02/16.
 */
@Service
public class UploadService {

    final private S3ServiceInfo s3Info;
    final private AmazonS3 s3Client;

    @Autowired
    public UploadService(S3ServiceInfo s3Info) {
        this.s3Info = s3Info;
        this.s3Client = new AmazonS3Client(new BasicAWSCredentials(s3Info.getAccessKeyId(), s3Info.getSecretAccessKey()));
    }

    public List<String> allFileNames() {

        List<S3ObjectSummary> s3objects = s3Client.listObjects(s3Info.getBucket()).getObjectSummaries();
        List<String> names = new ArrayList<String>();
        s3objects.forEach(object -> names.add(object.getKey()));
        return names;
    }

    public boolean uploadFile(String fileName, InputStream stream) {
        TransferManager transferManager = new TransferManager(
            new BasicAWSCredentials(s3Info.getAccessKeyId(), s3Info.getSecretAccessKey()));

        Upload upload = transferManager.upload(s3Info.getBucket(), fileName, stream, new ObjectMetadata());
        try {
            upload.waitForCompletion();
            return true;
        } catch(AmazonClientException clientException) {
            clientException.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
