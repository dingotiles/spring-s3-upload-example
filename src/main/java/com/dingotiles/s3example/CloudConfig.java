package com.dingotiles.s3example;

import org.cloudfoundry.community.service.storage.S3ServiceInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jcarter on 19/02/16.
 */
@Configuration
public class CloudConfig {

    @Value("${S3_SERVICE_NAME:s3-example-bucket}")
    private String serviceName;

    @Bean
    Cloud cloud() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        return cloud;
    }

    @Bean
    S3ServiceInfo serviceInfo(Cloud cloud) {
        return (S3ServiceInfo) cloud.getServiceInfo(serviceName);
    }

}
