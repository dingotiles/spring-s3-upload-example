package com.dingotiles.s3example;

import com.dingotiles.connector.s3.info.S3ServiceInfo;
import org.springframework.cloud.Cloud;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jcarter on 19/02/16.
 */
@Configuration
public class CloudConfig {

    @Bean
    S3ServiceInfo serviceInfo(Cloud cloud) {
        return (S3ServiceInfo) cloud.getServiceInfo("s3");
    }
}
