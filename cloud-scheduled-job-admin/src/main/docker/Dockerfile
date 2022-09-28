FROM apache/skywalking-java-agent:8.12.0-java11

MAINTAINER zhoushuai zs11195310@163.com

ENV SW_AGENT_NAME cloud-scheduled-job-admin

ENV AGENT_JAR_DIR /skywalking/agent/skywalking-agent.jar

ADD cloud-scheduled-job-admin.jar /app/cloud-scheduled-job-admin.jar

EXPOSE 19090

CMD java -javaagent:$AGENT_JAR_DIR $JAVA_OPTS -jar /app/cloud-scheduled-job-admin.jar
