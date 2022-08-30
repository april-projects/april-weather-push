#!/bin/bash

# shellcheck disable=SC2046
docker rm $(docker stop april-proxy)

# 打包
docker build -t april-weather-push:1.0.0 .

# run
docker run -dit --restart=always --name=april-weather-push  -p 8009:8080 -v /etc/localtime:/etc/localtime april-weather-push:1.0.0

# 提交
# docker commit 7227510800df  mobaijun/april-weather-push:1.0.0

# 推送
# docker push mobaijun/april-weather-push:1.0.0