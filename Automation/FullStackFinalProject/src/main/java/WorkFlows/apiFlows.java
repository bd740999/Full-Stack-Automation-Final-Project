package WorkFlows;

import Extensions.apiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class apiFlows extends CommonOps
{
    @Step("Get Team From Grafana")
    public static String getTeamProperty(String jPath)
    {
        Response response = apiActions.get("/api/teams/search?perpage=50&page=1");
        return apiActions.extractFromJSON(response,jPath);
    }

    @Step("Create New Team in Grafana")
    public static void postTeam(String name, String email)
    {
        requestParams.put("name", name);
        requestParams.put("email", email);
        apiActions.post(requestParams, "/api/teams");
    }

    @Step("Update Team in Grafana")
    public static void updateTeam(String name, String email, String id)
    {
        requestParams.put("name", name);
        requestParams.put("email", email);
        apiActions.put(requestParams, "/api/teams/" + id);
    }

    @Step("Delete Team in Grafana")
    public static void deleteTeam(String id)
    {
        apiActions.delete(id);
    }
}
