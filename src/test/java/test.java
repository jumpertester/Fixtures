import data.Fixtures;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class test {

    Fixtures fixtures = new Fixtures();

    @Test
    public void getAllFixturesTest() {
        fixtures.getAllFixtures().then().body("fixtureId", Matchers.hasSize(3));
    }

    @Test
    public void createFixture(){
        fixtures.createFixture();
        Response newFixture = fixtures.getFixture("4");
        long startTime = System.currentTimeMillis();
        while(newFixture.getBody().asString().equals("Fixture not found")
                && (System.currentTimeMillis()-startTime)<10000){
            System.out.println("New fixture not found....");
            newFixture = fixtures.getFixture("4");
        }
        newFixture.then().body("footballFullState.homeTeam", Matchers.is("Bradford City"));
        newFixture.then().body("footballFullState.awayTeam", Matchers.is("Real Madrid"));
        newFixture.then().body("footballFullState.teams.teamId[0]", Matchers.is("HOME"));

        Response deleteResponse = fixtures.deleteFixture("4");
        Assert.assertEquals(deleteResponse.getStatusCode(), 200);
    }
}
