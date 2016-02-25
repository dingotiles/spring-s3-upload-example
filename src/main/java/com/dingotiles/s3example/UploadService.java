package com.dingotiles.s3example;

import com.dingotiles.cloudfoundry.connector.s3.info.S3ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jcarter on 19/02/16.
 */
@Service
public class UploadService {

    final private S3ServiceInfo s3ServiceInfo;

    @Autowired
    public UploadService(S3ServiceInfo s3ServiceInfo) {
        this.s3ServiceInfo = s3ServiceInfo;
    }

    public void uploadFile() {

    }
}
