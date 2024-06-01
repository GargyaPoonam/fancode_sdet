package Fancode;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import static org.testng.Assert.assertTrue;
import static io.restassured.RestAssured.given;

import java.util.List;
import org.testng.annotations.Test;
public class toDocheckerTest {
	
	@Test
    public void testFanCodeUsersTodosCompletion() {
     
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";

        // Fetch users data 
        Response usersResponse = given().get("/users");
        JsonPath usersJsonPath = usersResponse.jsonPath();
        List<Integer> userIds = usersJsonPath.getList("id");
        List<Double> userLatitudes = usersJsonPath.getList("address.geo.lat", Double.class);
        List<Double> userLongitudes = usersJsonPath.getList("address.geo.lng", Double.class);

        // for find users in city
        for (int i = 0; i < userIds.size(); i++) {
            double lat = userLatitudes.get(i);
            double lon = userLongitudes.get(i);
            if (lat > -40 && lat < 5 && lon > 5 && lon < 100) {
                int userId = userIds.get(i);
                
                // get todos for the user
                Response todosResponse = given().param("userId", userId).get("/todos");
                JsonPath todosJsonPath = todosResponse.jsonPath();
                List<Boolean> todosCompleted = todosJsonPath.getList("completed");

                long completedCount = todosCompleted.stream().filter(Boolean::booleanValue).count();
                double completedPercentage = (double) completedCount / todosCompleted.size() * 100;

                // verify that the completed percentage is greater than 50%
                assertTrue(completedPercentage > 50, "User ID: " + userId + " has less than 50% todos completed");
            }
        }
    }
}


