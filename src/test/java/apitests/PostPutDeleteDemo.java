package apitests;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class PostPutDeleteDemo extends Simulation {

    public String userid = "";
    //protocol
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("https://reqres.in/api");

    //sceanrio
    private ScenarioBuilder Createusers = scenario("Create User").exec(
            http("Create a new User")
                    .post("/users").header("content-type","application/json")
                    .asJson()
                    .body(RawFileBody("data/user.json"))
                    .check(status().is(201),jsonPath("$.name").is("qaautomationhub"),jsonPath("$.id").saveAs("userid"))).pause(1)
            .exec(http("Update the User")
                    .put("/users/${userid}").header("content-type","application/json")
                    .asJson()
                    .body(RawFileBody("Data/user.json"))
            .check(status().is(200),jsonPath("$.name").is("qaautomationhub"))).pause(2).
            exec(http("Get Single User")
                            .get("/users/2").header("content-type","application/json").check(
                                    status().is(200)).
                            check(jsonPath("$.data.first_name").is("Janet"))).pause(1)
            .exec(http("Delete the User")
                            .delete("/users/${userid}").header("content-type","application/json")
                            .check(status().is(204))).pause(1);



    {
        setUp(
                Createusers.injectOpen(atOnceUsers(10)).protocols(httpProtocol))
                .assertions(forAll().responseTime().max().lt(800));
    }
}
