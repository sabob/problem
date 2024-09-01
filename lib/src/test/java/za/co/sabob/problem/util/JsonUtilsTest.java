package za.co.sabob.problem.util;

import org.junit.jupiter.api.Test;

public class JsonUtilsTest {

    @Test
    public void testPrettifyJson() {
        String json = "{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}";
        json = JsonUtils.prettifyJson(json).get();
        System.out.println("pretty: " + json);
    }
}
