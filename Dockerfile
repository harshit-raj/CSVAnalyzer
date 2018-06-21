FROM openjdk:8
ADD CSVAnalyzer/target/CSVAnalyzer.jar CSVAnalyzer.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "CSVAnalyzer.jar" ]
