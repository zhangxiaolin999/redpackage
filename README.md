1  启用docker
 创建数据库容器：
 docker run --name redpack -e MYSQL_ROOT_PASSWORD=123456 -p 3306:3306 -d mysql:latest
  
  