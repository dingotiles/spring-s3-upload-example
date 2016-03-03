# Example spring application
This application consumes s3 credentials supplied via the [s3-cf-service-broker](https://github.com/cloudfoundry-community/s3-cf-service-broker).

## Run the app
```
cf create-service aws-s3-cf-service-broker basic s3-example-bucket
cf push --no-start
cf bind-service spring-s3-upload-example s3-example-bucket
cf set-env spring-s3-upload-example S3_SERVICE_NAME s3-example-bucket
cf start spring-s3-upload-example
```
