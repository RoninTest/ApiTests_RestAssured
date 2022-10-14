package testData_Store;
import org.json.JSONObject;


public class Pexel_testData {

    public int statusCode=200;
    public String autoh="563492ad6f91700001000001e1d36b2518e04d5787a9ed672185d089";

    public JSONObject expectedData(){
        //Expected
        JSONObject body=new JSONObject();
        body.put("status",404);
        body.put("error","Not Found");


        return body;
    }
/*
    public Map requestBody(){
        Map<String,Object> mapReqData=new HashMap<>();
        mapReqData.put("status",404);
        mapReqData.put("error","Not Found");

        return mapReqData;
    }

 */
}
