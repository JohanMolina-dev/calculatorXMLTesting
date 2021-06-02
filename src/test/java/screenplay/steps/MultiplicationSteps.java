package screenplay.steps;

import co.com.sofka.testing.data.BodyXML;
import co.com.sofka.testing.data.HeadersXML;
import co.com.sofka.testing.data.ResultXML;
import co.com.sofka.testing.questions.ResponseCode;
import co.com.sofka.testing.task.PostRequest;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import net.thucydides.core.util.EnvironmentVariables;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;

import static java.lang.Integer.parseInt;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MultiplicationSteps {
    private static final Faker faker = Faker.instance(new Locale("es", "CO"), new SecureRandom());
    private final int number1 = faker.number().randomDigit();
    private final int number2 = faker.number().randomDigit();
    private final int multiplyEvaluation = number1 * number2;
    Actor actor;
    EnvironmentVariables variables;
    HeadersXML headersXML = new HeadersXML();
    BodyXML bodyXML = new BodyXML();
    private final String body = bodyXML.bodyXML(number1, number2);
    ResultXML resultXml = new ResultXML();
    @Given("a {string} wants to multiplication two numbers")
    public void aWantsToMultiplicationTwoNumbers(String name) {
        actor =Actor.named(name);
        actor.whoCan(CallAnApi.at(variables.getProperty("baseUrl")));
    }

    @When("the application performs the multiplication of the two numbers")
    public void theApplicationPerformsTheMultiplicationOfTheTwoNumbers() {
        HashMap<String, Object> header = headersXML.placeHeader(variables.getProperty("pathMultiply"));
        actor.attemptsTo(PostRequest.execute(header,variables.getProperty("pathCalculator"),body));
    }

    @Then("the application returns the result of the multiplication, responds with status {string}")
    public void theApplicationReturnsTheResultOfTheMultiplicationRespondsWithStatus(String statusCode) {
        actor.should(
                seeThat("The API responded with the expected code",
                        ResponseCode.was(),equalTo(parseInt(statusCode))));
        try {
            JSONObject objectXMLToJSON = XML.toJSONObject(LastResponse.received().answeredBy(actor).asString());

            assertThat(multiplyEvaluation).isEqualTo(parseInt(resultXml.resultXml(objectXMLToJSON)));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
