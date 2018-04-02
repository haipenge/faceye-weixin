#!/bin/bash
mvn clean compile package install -D maven.test.skip=true -P product
echo '>>Finish faceye-weixin-manager install'
