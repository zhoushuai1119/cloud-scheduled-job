FROM openjdk:11-jre

MAINTAINER zhoushuai zs195310@aliyun.com

VOLUME /temp

ADD cloud-scheduled-job-admin.jar /app/cloud-scheduled-job-admin.jar

EXPOSE 19090

CMD java ${JAVA_OPTS} -jar /app/cloud-scheduled-job-admin.jar
