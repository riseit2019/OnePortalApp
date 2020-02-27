import _root_.io.gatling.core.scenario.Simulation
import ch.qos.logback.classic.{Level, LoggerContext}
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import org.slf4j.LoggerFactory

import scala.concurrent.duration._

/**
 * Performance test for the MdmCitizenData entity.
 */
class MdmCitizenDataGatlingTest extends Simulation {

    val context: LoggerContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    // Log all HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("TRACE"))
    // Log failed HTTP requests
    //context.getLogger("io.gatling.http").setLevel(Level.valueOf("DEBUG"))

    val baseURL = Option(System.getProperty("baseURL")) getOrElse """http://localhost:8080"""

    val httpConf = http
        .baseUrl(baseURL)
        .inferHtmlResources()
        .acceptHeader("*/*")
        .acceptEncodingHeader("gzip, deflate")
        .acceptLanguageHeader("fr,fr-fr;q=0.8,en-us;q=0.5,en;q=0.3")
        .connectionHeader("keep-alive")
        .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.10; rv:33.0) Gecko/20100101 Firefox/33.0")
        .silentResources // Silence all resources like css or css so they don't clutter the results

    val headers_http = Map(
        "Accept" -> """application/json"""
    )

    val headers_http_authentication = Map(
        "Content-Type" -> """application/json""",
        "Accept" -> """application/json"""
    )

    val headers_http_authenticated = Map(
        "Accept" -> """application/json""",
        "Authorization" -> "${access_token}"
    )

    val scn = scenario("Test the MdmCitizenData entity")
        .exec(http("First unauthenticated request")
        .get("/api/account")
        .headers(headers_http)
        .check(status.is(401))
        ).exitHereIfFailed
        .pause(10)
        .exec(http("Authentication")
        .post("/api/authenticate")
        .headers(headers_http_authentication)
        .body(StringBody("""{"username":"admin", "password":"admin"}""")).asJson
        .check(header("Authorization").saveAs("access_token"))).exitHereIfFailed
        .pause(2)
        .exec(http("Authenticated request")
        .get("/api/account")
        .headers(headers_http_authenticated)
        .check(status.is(200)))
        .pause(10)
        .repeat(2) {
            exec(http("Get all mdmCitizenData")
            .get("/api/mdm-citizen-data")
            .headers(headers_http_authenticated)
            .check(status.is(200)))
            .pause(10 seconds, 20 seconds)
            .exec(http("Create new mdmCitizenData")
            .post("/api/mdm-citizen-data")
            .headers(headers_http_authenticated)
            .body(StringBody("""{
                "id":null
                , "syspk":null
                , "tempRefId":null
                , "name":"SAMPLE_TEXT"
                , "emailId":"SAMPLE_TEXT"
                , "mobileNumber":null
                , "dateOfBirth":"2020-01-01T00:00:00.000Z"
                , "genderId":"0"
                , "gender":"SAMPLE_TEXT"
                , "houseNumberAdh":"SAMPLE_TEXT"
                , "streetAdh":"SAMPLE_TEXT"
                , "villageAdh":"SAMPLE_TEXT"
                , "districtNameAh":"SAMPLE_TEXT"
                , "subDistrictNameAdh":"SAMPLE_TEXT"
                , "postOfficeAdh":"SAMPLE_TEXT"
                , "stateNameAdh":"SAMPLE_TEXT"
                , "pinCodeAdh":"SAMPLE_TEXT"
                , "districtCodePss":"0"
                , "districtNamePss":"SAMPLE_TEXT"
                , "districtCode":"SAMPLE_TEXT"
                , "mandalCode":"SAMPLE_TEXT"
                , "villageCode":"SAMPLE_TEXT"
                , "districtName":"SAMPLE_TEXT"
                , "mandalName":"SAMPLE_TEXT"
                , "villageName":"SAMPLE_TEXT"
                , "houseHoldId":"SAMPLE_TEXT"
                , "relationshipWithHoh":"SAMPLE_TEXT"
                , "buildingNamePss":"SAMPLE_TEXT"
                , "houseNameWardNoDivPss":"SAMPLE_TEXT"
                , "areaWardColonyStreetPss":"SAMPLE_TEXT"
                , "villageTownPss":"SAMPLE_TEXT"
                , "pinCodePss":"SAMPLE_TEXT"
                , "religionId":"0"
                , "religion":"SAMPLE_TEXT"
                , "casteId":"0"
                , "caste":"SAMPLE_TEXT"
                , "subCasteId":"0"
                , "subCaste":"SAMPLE_TEXT"
                , "motherTongueId":"0"
                , "motherTongue":"SAMPLE_TEXT"
                , "householdOwnershipId":"0"
                , "householdOwnership":"SAMPLE_TEXT"
                , "educationId":"0"
                , "education":"SAMPLE_TEXT"
                , "occupationId":"0"
                , "occupation":"SAMPLE_TEXT"
                , "occupationCategoryId":"0"
                , "occupationCategory":"SAMPLE_TEXT"
                , "martialStatusId":"0"
                , "martialStatus":"SAMPLE_TEXT"
                , "physicalhandicappedTypeId":"0"
                , "physicalhandicappedStatus":"SAMPLE_TEXT"
                , "physicalhandicappedPercentage":"0"
                , "votersCardNo":"SAMPLE_TEXT"
                , "kissanCardAvailable":"SAMPLE_TEXT"
                , "annualIncome":"SAMPLE_TEXT"
                , "rationId":"SAMPLE_TEXT"
                , "createdBy":"SAMPLE_TEXT"
                , "updatedBy":"SAMPLE_TEXT"
                , "recordInsertTime":"2020-01-01T00:00:00.000Z"
                , "createTime":"2020-01-01T00:00:00.000Z"
                , "updateTime":"2020-01-01T00:00:00.000Z"
                , "aadhaarVerified":"SAMPLE_TEXT"
                , "aadhaarVerifiedDate":"2020-01-01T00:00:00.000Z"
                , "emailVerified":"SAMPLE_TEXT"
                , "phoneNoVerified":"SAMPLE_TEXT"
                , "citizenActiveStatus":"SAMPLE_TEXT"
                , "sourceOfRegistrationId":"0"
                , "sourceOfRegistration":"SAMPLE_TEXT"
                , "ssoId":"SAMPLE_TEXT"
                , "operatorId":"SAMPLE_TEXT"
                , "aadhaarRefId":null
                , "careOfAdh":"SAMPLE_TEXT"
                , "assistedModeOperatorId":"SAMPLE_TEXT"
                , "uidReferenceKeyAponline":null
                , "uidToken":"SAMPLE_TEXT"
                , "volunteerSecretariatEmailId":"SAMPLE_TEXT"
                , "volunteerSecretariatMobile":null
                , "volunteerSecretariatId":"SAMPLE_TEXT"
                }""")).asJson
            .check(status.is(201))
            .check(headerRegex("Location", "(.*)").saveAs("new_mdmCitizenData_url"))).exitHereIfFailed
            .pause(10)
            .repeat(5) {
                exec(http("Get created mdmCitizenData")
                .get("${new_mdmCitizenData_url}")
                .headers(headers_http_authenticated))
                .pause(10)
            }
            .exec(http("Delete created mdmCitizenData")
            .delete("${new_mdmCitizenData_url}")
            .headers(headers_http_authenticated))
            .pause(10)
        }

    val users = scenario("Users").exec(scn)

    setUp(
        users.inject(rampUsers(Integer.getInteger("users", 100)) during (Integer.getInteger("ramp", 1) minutes))
    ).protocols(httpConf)
}
