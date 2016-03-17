/**
 * Test for end points.
 */

import com.google.gson.JsonObject;
import com.sun.deploy.config.Config;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Collections;

import static spark.Spark.*;

public class EndpointsTest {
    public static final String ROUTE_BASE = "/";
    public static final String BAR = "bar";


    private static final JsonObject foo = buildJson();
    private static final String VIEW_FILE = "HelloWorld.ftl";

    private static JsonObject buildJson() {
        final JsonObject object = new JsonObject();
        object.addProperty("name", "Bar");
        return object;
    }

    public static void main(String[] args) {
        Spark.staticFileLocation("/public");
        Configuration conf = new Configuration();
        conf.setClassForTemplateLoading(EndpointsTest.class, ROUTE_BASE);
        get(ROUTE_BASE.concat(BAR), (request, response) -> foo);

        get(ROUTE_BASE, (request, response) -> new ModelAndView(Collections.emptyMap(), VIEW_FILE), Engine(conf));
    }

    private static FreeMarkerEngine Engine(Configuration config) {
        return new FreeMarkerEngine(config);
    }
}
