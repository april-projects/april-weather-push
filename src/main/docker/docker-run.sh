#!/bin/bash

docker rm $(docker stop april-proxy)

# 打包
docker build -t april-weather-push:1.0.0 .

# run
docker run --restart=always -dit -p 8999:8080 --name april-proxy mobaijun/april-weather-push:1.0.0

# 提交
# docker commit 7227510800df  mobaijun/april-weather-push:1.0.0

# 推送
# docker push mobaijun/april-weather-push:1.0.0