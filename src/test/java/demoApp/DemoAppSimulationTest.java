package demoApp;

import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class DemoAppSimulationTest extends Simulation {

  private HttpProtocolBuilder httpProtocol = http
    .baseUrl("http://spree-vapasi.herokuapp.com")
    .disableFollowRedirect()
    .inferHtmlResources(AllowList(), DenyList(".*\\.js", ".*\\.css", ".*\\.gif", ".*\\.jpeg", ".*\\.jpg", ".*\\.ico", ".*\\.woff", ".*\\.woff2", ".*\\.(t|o)tf", ".*\\.png", ".*detectportal\\.firefox\\.com.*"));
  
  private Map<CharSequence, String> headers_0 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_1 = Map.ofEntries(
    Map.entry("If-None-Match", "W/\"0cab0ef220d6a181641d7c68bf30b88d\""),
    Map.entry("X-CSRF-Token", "aC6dcn93BK/ejyPH0z8xv/ELuJKCjc5JBors5YjFRld/H4qdfL4zfmhpn6l6LkQWXiDYrLzmgWlMFCY9/cLUJA=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_2 = Map.ofEntries(
    Map.entry("If-None-Match", "W/\"07bbd9aca829b72cae451c7126fdd55c\""),
    Map.entry("X-CSRF-Token", "aC6dcn93BK/ejyPH0z8xv/ELuJKCjc5JBors5YjFRld/H4qdfL4zfmhpn6l6LkQWXiDYrLzmgWlMFCY9/cLUJA=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_3 = Map.of("If-None-Match", "W/\"2e143c6661dca0359443c757a40f38ca\"");
  
  private Map<CharSequence, String> headers_4 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("Origin", "http://spree-vapasi.herokuapp.com"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_5 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("If-None-Match", "W/\"1721859a591375496390ec265189c96d\""),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_6 = Map.ofEntries(
    Map.entry("If-None-Match", "W/\"07bbd9aca829b72cae451c7126fdd55c\""),
    Map.entry("X-CSRF-Token", "pDkE+S3gy2/gH2ScjVhaCJmJLEjJ+GSQTYigLxmqpW2soKqA5HnJgdcmoiJPxrVSHQngdnXcbbEdCIr1xIlozg=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_7 = Map.ofEntries(
    Map.entry("If-None-Match", "W/\"0cab0ef220d6a181641d7c68bf30b88d\""),
    Map.entry("X-CSRF-Token", "pDkE+S3gy2/gH2ScjVhaCJmJLEjJ+GSQTYigLxmqpW2soKqA5HnJgdcmoiJPxrVSHQngdnXcbbEdCIr1xIlozg=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_9 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
    Map.entry("If-None-Match", "W/\"06d0a4a38c18071243c4a6f23a7973b2\""),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_10 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Fri, 25 Nov 2022 05:08:24 GMT"),
    Map.entry("If-None-Match", "W/\"533b416cb04a47bf799857a54955151e\""),
    Map.entry("X-CSRF-Token", "bOZcTRTTlGOPm7uJGMFgc1pqxZxhqQymeRDdgsnyXjxkf/I03UqWjbiifTfaX48p3uoJot2NBYcpkPdYFNGTnw=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_11 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Fri, 25 Nov 2022 05:09:23 GMT"),
    Map.entry("If-None-Match", "W/\"536e15f91105acb65b99d102f0ce48c0\""),
    Map.entry("X-CSRF-Token", "bOZcTRTTlGOPm7uJGMFgc1pqxZxhqQymeRDdgsnyXjxkf/I03UqWjbiifTfaX48p3uoJot2NBYcpkPdYFNGTnw=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_12 = Map.of("If-None-Match", "W/\"20971a9a2a41bf963f3ae225ad2695a4\"");
  
  private Map<CharSequence, String> headers_13 = Map.ofEntries(
    Map.entry("Accept", "application/json"),
    Map.entry("Content-Type", "application/json"),
    Map.entry("Origin", "http://spree-vapasi.herokuapp.com"),
    Map.entry("X-Spree-Order-Token", "un2IrsM7DEDnwEUZh6GDeQ1669099962130"),
    Map.entry("authorization", "Bearer 61e7b0756528b5360a2dd5281f27d6908784cfb14f5de8e7833925b063778866")
  );
  
  private Map<CharSequence, String> headers_14 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
    Map.entry("If-None-Match", "W/\"518abaa74f28db4194ab24ff52b1dd2d\""),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_15 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Fri, 25 Nov 2022 05:09:23 GMT"),
    Map.entry("If-None-Match", "W/\"536e15f91105acb65b99d102f0ce48c0\""),
    Map.entry("X-CSRF-Token", "708KIA4ToZW38ifchLpMyRE6VLKwNtSOS+2Lso60bbbn1qRZx4qje4DL4WJGJKOTlbqYjAwS3a8bbaFoU5egFQ=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_17 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Fri, 25 Nov 2022 05:08:24 GMT"),
    Map.entry("If-None-Match", "W/\"533b416cb04a47bf799857a54955151e\""),
    Map.entry("X-CSRF-Token", "708KIA4ToZW38ifchLpMyRE6VLKwNtSOS+2Lso60bbbn1qRZx4qje4DL4WJGJKOTlbqYjAwS3a8bbaFoU5egFQ=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_19 = Map.ofEntries(
    Map.entry("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"),
    Map.entry("Cache-Control", "max-age=0"),
    Map.entry("Upgrade-Insecure-Requests", "1")
  );
  
  private Map<CharSequence, String> headers_20 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Fri, 25 Nov 2022 05:09:23 GMT"),
    Map.entry("If-None-Match", "W/\"536e15f91105acb65b99d102f0ce48c0\""),
    Map.entry("X-CSRF-Token", "rMmBtCzwEJimoI09CbHg0br+5yAPVeOvmd1Cr03EnPukUC/N5WkSdpGZS4PLLw+LPn4rHrNx6o7JXWh1kOdRWA=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_21 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Fri, 25 Nov 2022 05:09:38 GMT"),
    Map.entry("If-None-Match", "W/\"0e61e86a64e2280d8cba3eabb370bcd5\""),
    Map.entry("X-CSRF-Token", "rMmBtCzwEJimoI09CbHg0br+5yAPVeOvmd1Cr03EnPukUC/N5WkSdpGZS4PLLw+LPn4rHrNx6o7JXWh1kOdRWA=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );
  
  private Map<CharSequence, String> headers_23 = Map.ofEntries(
    Map.entry("If-Modified-Since", "Tue, 02 Apr 2019 08:23:30 GMT"),
    Map.entry("If-None-Match", "W/\"8384f330aa09dd06839d5eef622ec1b7\""),
    Map.entry("X-CSRF-Token", "rMmBtCzwEJimoI09CbHg0br+5yAPVeOvmd1Cr03EnPukUC/N5WkSdpGZS4PLLw+LPn4rHrNx6o7JXWh1kOdRWA=="),
    Map.entry("X-Requested-With", "XMLHttpRequest")
  );

  private String uri1 = "http://spree-vapasi.herokuapp.com";

  ChainBuilder LoginToApplication=exec(
          http("LoginPage").get(uri1 +"/login").headers(headers_0).resources(
                  http("request_1").get(uri1 +"/account_link").headers(headers_1)
                  ,http("request_2").get(uri1 +"/cart_link").headers(headers_2)
                  ,http("request_3")
                          .get(uri1 +"/api_tokens")
                          .headers(headers_3)
                                  .check(bodyBytes().is(RawFileBody("demoApp/demoappsimulationtest/0003_response.bin"))))
//          .pause(1)
//          .exec(http("LoginSuccessful").post(uri1+ "/login")
//                  .headers(headers_4)
//                  .formParam("utf8", "✓")
//                  .formParam("authenticity_token", "aC6dcn93BK/ejyPH0z8xv/ELuJKCjc5JBors5YjFRld/H4qdfL4zfmhpn6l6LkQWXiDYrLzmgWlMFCY9/cLUJA==")
//                  .formParam("spree_user[email]", "tusharvarm@gmail.com")
//                  .formParam("spree_user[password]", "Password123")
//                  .formParam("spree_user[remember_me]", "0")
//                  .formParam("commit", "Login")
//                  .check(status().is(302))
//                  .resources(
//                          http("request_5")
//                                  .get(uri1 +"/")
//                                  .headers(headers_5),
//                          http("request_6")
//                                  .get(uri1 +"/cart_link")
//                                  .headers(headers_6),
//                          http("request_7")
//                                  .get(uri1 +"/account_link")
//                                  .headers(headers_7),
//                          http("request_8")
//                                  .get(uri1 +"/api_tokens")
//                                  .headers(headers_3)
//                                  .check(bodyBytes().is(RawFileBody("demoApp/demoappsimulationtest/0008_response.json"))))
          );

  ChainBuilder NavigateToProductDetails=exec(
          http("ProductDetailsPage").get(uri1 +"/products/ruby-on-rails-stein").resources(
                  http("request_10")
                          .get(uri1 +"/cart_link")
                          .headers(headers_10),
                  http("request_11")
                          .get(uri1 +"/account_link")
                          .headers(headers_11),
                  http("request_12")
                          .get(uri1 +"/api_tokens")
                          .headers(headers_12)
          ));

  ChainBuilder AddToCart=exec(
          http("AddProductToCart").post(uri1 +"/api/v2/storefront/cart/add_item")
          .headers(headers_13)
          .body(RawFileBody("demoApp/demoappsimulationtest/0013_request.dat"))
          .resources(
                  http("request_14")
                          .get(uri1 +"/cart?variant_id=14")
                          .headers(headers_14),
                  http("request_15")
                          .get(uri1 +"/account_link")
                          .headers(headers_15),
                  http("request_16")
                          .get(uri1 +"/api_tokens")
                          .headers(headers_12),
                  http("request_17")
                          .get(uri1 +"/cart_link")
                          .headers(headers_17)
          ));

  private ScenarioBuilder users = scenario("DemoAppSimulation").exec(LoginToApplication
          ,NavigateToProductDetails,AddToCart);
  private ScenarioBuilder users1 = scenario("DemoAppSimulationOneUser").exec(LoginToApplication
          ,NavigateToProductDetails,AddToCart);

  {
    setUp(users.injectOpen(rampUsers(10).during(10)).protocols(httpProtocol)
            ,users1.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }


}
