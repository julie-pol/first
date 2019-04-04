package ru.open.exam.test.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import ru.open.exam.data.GithubUser;
import ru.open.exam.test.helper.Helper;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GithubTest {

    private RequestSpecification spec;
    private RequestSpecBuilder build;

    private String userForTest = "defunkt";

    private SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void requestSpec() {

        build = new RequestSpecBuilder();
        build.setBaseUri("https://api.github.com/");
        build.setBasePath("users/");

        spec = build.build();
    }

    @Test
    public void apiTest() throws IOException {
        Response response = given()
                .spec(spec)
                .when()
                .get(userForTest);

        GithubUser githubUser = new ObjectMapper().readValue(response.asString(), GithubUser.class);

        softAssert.assertEquals(githubUser.getLogin(), userForTest, "User login not correct");
        Helper.assertNotNull(softAssert, githubUser.getAvatar_url()
                , githubUser.getBio()
                , githubUser.getBlog()
                , githubUser.getCompany()
                , githubUser.getCreated_at()
                , githubUser.getCreated_at()
                , githubUser.getEvents_url()
                , githubUser.getFollowers()
                , githubUser.getFollowers_url()
                , githubUser.getFollowing()
                , githubUser.getFollowing_url()
                , githubUser.getGists_url()
                , githubUser.getHtml_url()
                , githubUser.getId()
                , githubUser.getLocation()
                , githubUser.getName()
                , githubUser.getNode_id()
                , githubUser.getOrganizations_url()
                , githubUser.getPublic_gists()
                , githubUser.getPublic_repos()
                , githubUser.getReceived_events_url()
                , githubUser.getRepos_url()
                , githubUser.getStarred_url()
                , githubUser.getSubscriptions_url()
                , githubUser.getType()
                , githubUser.getUpdated_at()
                , githubUser.getUrl()
                , githubUser.getGravatar_id()
                , githubUser.getEmail()
                , githubUser.getHireable());
        softAssert.assertAll();
    }
}