package data;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class Fixtures {

    final static String ROOT_URI = "http://localhost:3000";

    private final String fixturePayLoad = "{\n" +
            "\t\"fixtureId\":\"4\",\n" +
            "\t\"fixtureStatus\":\n" +
            "\t{\n" +
            "\t\t\"displayed\":false,\n" +
            "\t\t\"suspended\":true\n" +
            "\t\t\n" +
            "\t},\n" +
            "\t\"footballFullState\":\n" +
            "\t{\n" +
            "\t\t\"homeTeam\":\"Bradford City\",\n" +
            "\t\t\"awayTeam\":\"Real Madrid\",\n" +
            "\t\t\"finished\":false,\n" +
            "\t\t\"gameTimeInSeconds\":950,\n" +
            "\t\t\"goals\":\n" +
            "\t\t[{\n" +
            "\t\t\t\"clockTime\":640,\n" +
            "\t\t\t\"confirmed\":true,\n" +
            "\t\t\t\"id\":678606,\n" +
            "\t\t\t\"ownGoal\":false,\n" +
            "\t\t\t\"penalty\":false,\n" +
            "\t\t\t\"period\":\"FIRST_HALF\",\n" +
            "\t\t\t\"playerId\":560617,\n" +
            "\t\t\t\"teamId\":\"1\"\n" +
            "\t\t}],\n" +
            "\t\t\"period\":\"FIRST_HALF\",\n" +
            "\t\t\"possibles\":[],\n" +
            "\t\t\"corners\":[],\n" +
            "\t\t\"redCards\":[],\n" +
            "\t\t\"yellowCards\":[],\n" +
            "\t\t\"startDateTime\":\"2018-03-20T10:49:38.655Z\",\n" +
            "\t\t\"started\":true,\n" +
            "\t\t\"teams\":\n" +
            "\t\t[{\n" +
            "\t\t\t\"association\":\"HOME\",\n" +
            "\t\t\t\"name\":\"Bradford-FC\",\n" +
            "\t\t\t\"teamId\":\"HOME\"\n" +
            "\t\t},\n" +
            "\t\t{\n" +
            "\t\t\t\"association\":\"AWAY\",\n" +
            "\t\t\t\"name\":\"Madrid-FC\",\n" +
            "\t\t\t\"teamId\":\"AWAY\"\n" +
            "\t\t}]\n" +
            "\t}\n" +
            "}";

    public Response getAllFixtures(){
        return get(ROOT_URI + "/fixtures");
    }

    public Response createFixture(){
        return given().contentType(ContentType.JSON).body(fixturePayLoad).post(ROOT_URI + "/fixture");
    }

    public Response getFixture(String fixtureId){
        return get(ROOT_URI + "/fixture/" + fixtureId);
    }

    public Response deleteFixture(String fixtureId){
        return given().delete(ROOT_URI + "/fixture/" + fixtureId);
    }
}
