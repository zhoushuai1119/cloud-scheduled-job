FROM openjdk:11-jre

MAINTAINER zhoushuai zs195310@aliyun.com

VOLUME /temp

# 复制agent 到容器/agent目录
COPY agent /agent/

ADD cloud-scheduled-job-admin.jar /app/cloud-scheduled-job-admin.jar

EXPOSE 19090

CMD java -javaagent:/agent/skywalking-agent.jar ${JAVA_OPTS} -jar /app/cloud-scheduled-job-admin.jar
