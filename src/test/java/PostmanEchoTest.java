import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PostmanEchoTest {

    @Test
    public void testGet() {
        Response response = RestAssured
                .given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .get("https://postman-echo.com/get");

        assertEquals(response.getStatusCode(), 200);

        // Проверка параметров
        assertEquals(response.jsonPath().getString("args.foo1"), "bar1");
        assertEquals(response.jsonPath().getString("args.foo2"), "bar2");

        // Можно добавить дополнительные проверки
        assertEquals(response.jsonPath().getString("url"),
                "https://postman-echo.com/get?foo1=bar1&foo2=bar2");
    }

    @Test
    public void testPost() {
        String payload = "{\"foo\":\"bar\"}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload)
                .post("https://postman-echo.com/post");

        assertEquals(response.getStatusCode(), 200);

        // Проверка данных запроса
        assertEquals(response.jsonPath().getString("data"), payload);
        assertEquals(response.jsonPath().getMap("json").get("foo"), "bar");
        assertEquals(response.jsonPath().getString("headers['content-type']"), "application/json");
    }

    @Test
    public void testPut() {
        String payload = "{\"update\":\"value\"}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload)
                .put("https://postman-echo.com/put");

        assertEquals(response.getStatusCode(), 200);

        assertEquals(response.jsonPath().getString("data"), payload);
        assertEquals(response.jsonPath().getMap("json").get("update"), "value");
    }

    @Test
    public void testPatch() {
        String payload = "{\"patch\":\"patched\"}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(payload)
                .patch("https://postman-echo.com/patch");

        assertEquals(response.getStatusCode(), 200);

        assertEquals(response.jsonPath().getString("data"), payload);
        assertEquals(response.jsonPath().getMap("json").get("patch"), "patched");
    }

    @Test
    public void testDelete() {
        Response response = RestAssured
                .given()
                .queryParam("del", "value")
                .delete("https://postman-echo.com/delete");

        assertEquals(response.getStatusCode(), 200);

        // DELETE тоже возвращает поле args
        assertEquals(response.jsonPath().getString("args.del"), "value");
    }

}
