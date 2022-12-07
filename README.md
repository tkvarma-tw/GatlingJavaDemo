# Gatling demo for Java

Command to Run recorder
"mvn gatling:recorder"

Command to Run tests 
"mvn gatling:test -Dgatling.simulationClass=apitests.API_Test01" (Provide Class name for gatling test you want to run)




# branch-1  --Create Maven Project & Add gatling conf, recorder conf and gatling Dependency in pom.xml, 
# branch-2. -- Added gatling script for 10 ramp users and 1 user at once for Demo app
# branch-3. -- Added gatling script for API for CRUD operation with simulation assertions
# branch-4. -- Added the feeder which generates random string in Post Call for ReqRes.in
# branch-5. -- Added test case to include CSV feeder in the Post call for Login Successful in reqres application
