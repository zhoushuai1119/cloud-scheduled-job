FROM apache/skywalking-java-agent:8.12.0-java11

MAINTAINER zhoushuai zs11195310@163.com

ENV SW_AGENT_NAME cloud-scheduled-job-admin

ADD cloud-scheduled-job-admin.jar /app/cloud-scheduled-job-admin.jar

EXPOSE 19090

CMD java $JAVA_TOOL_OPTIONS $JAVA_OPTS -jar /app/cloud-scheduled-job-admin.jar
