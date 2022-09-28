FROM apache/skywalking-java-agent:8.12.0-java11

MAINTAINER zhoushuai zs11195310@163.com

ENV SW_AGENT_NAME cloud-scheduled-mq-executor

ENV AGENT_JAR_DIR /skywalking/agent/skywalking-agent.jar

ADD cloud-scheduled-mq-executor.jar /app/cloud-scheduled-mq-executor.jar

EXPOSE 8767

CMD java -javaagent:$AGENT_JAR_DIR $JAVA_OPTS -jar /app/cloud-scheduled-mq-executor.jar
