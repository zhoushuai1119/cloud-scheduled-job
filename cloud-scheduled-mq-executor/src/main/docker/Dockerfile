FROM apache/skywalking-java-agent:8.12.0-java11

MAINTAINER zhoushuai zs195310@aliyun.com

VOLUME /temp

ADD cloud-scheduled-mq-executor.jar /app/cloud-scheduled-mq-executor.jar

EXPOSE 8767

CMD java -javaagent:/skywalking/agent/skywalking-agent.jar \
-Dskywalking.agent.service_name=cloud-scheduled-mq-executor \
${JAVA_OPTS} -jar /app/cloud-scheduled-mq-executor.jar
