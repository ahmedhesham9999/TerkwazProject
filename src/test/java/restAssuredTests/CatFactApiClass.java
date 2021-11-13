package restAssuredTests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CatFactApiClass {

    @Test
    public static void getResponseBody(){
        ResponseBody response = RestAssured.get("https://cat-fact.herokuapp.com/facts/random").getBody();
        JsonPath jsonPath = response.jsonPath();
        String text = jsonPath.get("text");
        Assert.assertTrue(!text.isEmpty());
    }
}
