# Example spring application
This application consumes s3 credentials supplied via the [dingo-s3](http://www.dingotiles.com/dingo-s3/) service broker.

## Run the app
```
cf create-service dingo-s3 essential s3-example-bucket
cf push --no-start
cf bind-service spring-s3-upload-example s3-example-bucket
cf set-env spring-s3-upload-example S3_SERVICE_NAME s3-example-bucket
cf start spring-s3-upload-example
```
