package reqresApi.specsifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static reqresApi.helper.CustomApiListene.withCustomTemplates;

public class RequestSpecs {
    public static RequestSpecification requestSpecs = with()
            .filter(withCustomTemplates())
            .baseUri("https://reqres.in")
            .log().body()
            .log().uri()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpecs = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.ALL)
            .build();

}
