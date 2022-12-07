package API_Tests;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;
import jodd.util.RandomString;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class PostPutDeleteDemo extends Simulation {

    Iterator<Map<String, Object>> feeder =
            Stream.generate((Supplier<Map<String, Object>>) ()
                    -> {
                String name = RandomString.get().random(6,"Test");
                return Collections.singletonMap("username", name);
                    }
            ).iterator();

    //protocol
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://reqres.in/api");

    //sceanrio
    private ScenarioBuilder Createusers = scenario("Create User")
            .feed(feeder)
            .exec(
            http("Create a new User")
                    .post("/users")
                    .header("content-type","application/json")
                    .body(StringBody("{\"name\": \"${username}\",\"job\":\"leader\"}"))
                    .check(status().is(201),jsonPath("$.job").is("leader"),jsonPath("$.name").saveAs("Username"))).pause(1)
            .exec(session -> {
                System.out.println(session.get("Username").toString());
                return session;
            });
    {
        setUp(
                Createusers.injectOpen(rampUsers(5).during(5)).protocols(httpProtocol));
    }
}
