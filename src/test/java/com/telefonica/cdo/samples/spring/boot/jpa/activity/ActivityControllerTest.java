package com.telefonica.cdo.samples.spring.boot.jpa.activity;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.cdo.samples.spring.boot.jpa.TestSupport;

public class ActivityControllerTest extends TestSupport {

    @Test
    public void test() throws Exception {
        assertEquals(
            "{" + 
                "\"id\":3," + 
                "\"name\":\"Activity 3\"," +
                "\"actions\":" +
                    "[" +
                        "{" +
                            "\"id\":4," + 
                            "\"name\":\"Action 3.1\"" +
                        "}," +
                        "{" +
                            "\"id\":5," + 
                            "\"name\":\"Action 3.2\"" +
                        "}," +
                        "{" +
                            "\"id\":6," + 
                            "\"name\":\"Action 3.3\"" +
                        "}" +
                    "]" +
            "}",
            new ObjectMapper().writeValueAsString(restTemplate.getForEntity("/activities/3", Activity.class).getBody()),
            false
        );
    }

}
