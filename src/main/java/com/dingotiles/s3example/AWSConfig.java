package com.dingotiles.s3example;

import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.Cloud;
import org.cloudfoundry.community.service.storage.S3ServiceInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jcarter on 19/02/16.
 */
@Configuration
public class AWSConfig {

    @Bean
    Cloud cloud() {
        CloudFactory cloudFactory = new CloudFactory();
        return cloudFactory.getCloud();
    }

    @Bean
    S3ServiceInfo serviceInfo(Cloud cloud) {
        return (S3ServiceInfo) cloud.getServiceInfo("s3");
    }
}
