FROM apache/skywalking-java-agent:8.12.0-java11

MAINTAINER zhoushuai zs195310@aliyun.com

VOLUME /temp

ADD cloud-scheduled-job-admin.jar /app/cloud-scheduled-job-admin.jar

EXPOSE 19090

CMD java -javaagent:/skywalking/agent/skywalking-agent.jar \
-Dskywalking.agent.service_name=cloud-scheduled-job-admin \
${JAVA_OPTS} -jar /app/cloud-scheduled-job-admin.jar
