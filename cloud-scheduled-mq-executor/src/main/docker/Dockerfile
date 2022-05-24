FROM openjdk:11-jre

MAINTAINER zhoushuai zs195310@aliyun.com

VOLUME /temp

ADD cloud-scheduled-mq-executor.jar /app/cloud-scheduled-mq-executor.jar

EXPOSE 8767

CMD java ${JAVA_OPTS} -jar /app/cloud-scheduled-mq-executor.jar
