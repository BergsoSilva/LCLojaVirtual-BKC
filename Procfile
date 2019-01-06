web: java -Dserver.port=$PORT -Dspring.profiles.active=prod $JAVA_OPTS -jar target/lacoscomfita*.jar

release: ./mvnw flyway:migrate
