FROM maven

WORKDIR /build
COPY src ./src
COPY pom.xml ./
RUN mvn package
EXPOSE 4001
CMD java -jar target/kumuluzee-graphql-federation-compatibility-*.jar
