package API_Tests;

import io.gatling.javaapi.core.ChainBuilder;
import io.gatling.javaapi.core.FeederBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class Get_API_Test extends Simulation {
    FeederBuilder<String> feeder = csv("user.csv").random();

    //protocol
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://reqres.in/api");

    //sceanrio
    private ScenarioBuilder GetUsers = scenario("Get list of Users")
            .feed(feeder)
            .exec(
                    http("Create Login successful")
                            .post("/login")
                            .header("content-type", "application/json")
                            .body(StringBody("{\"email\": \"#{email}\",\"password\":\"#{password}\"}"))
                            .check(status().is(200), jsonPath("$.token").exists(), jsonPath("$.token").saveAs("strToken"), bodyString().saveAs("responseBody"))).pause(1)
            .exec(session -> {
                System.out.println(session.get("email").toString());
                System.out.println(session.get("password").toString());
                System.out.println(session.get("responseBody").toString());
                return session;
            });

    {
        setUp(
                GetUsers.injectOpen(constantUsersPerSec(50).during(5)).protocols(httpProtocol)
//                ,GetUsers.injectOpen(atOnceUsers(50)).protocols(httpProtocol)
//                ,GetUsers.injectOpen(rampUsers(50).during(10)).protocols(httpProtocol)
//                ,GetUsers.injectOpen(rampUsersPerSec(50).to(100).during(5)).protocols(httpProtocol)
//                ,GetUsers.injectOpen(stressPeakUsers(100).during(5)).protocols(httpProtocol)
        );
    }
}
