import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;


public class App {

  public static void main(String[] args) {
    float data;
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/form.vtl" );
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/money", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
    ChangeMachine change1 = new ChangeMachine();
    model.put("input", change1.makeChange(Float.parseFloat(request.queryParams("input"))));
    model.put("template", "templates/money.vtl");
    return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
