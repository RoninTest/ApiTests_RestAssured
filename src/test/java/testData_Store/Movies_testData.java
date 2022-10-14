package testData_Store;

import org.json.JSONObject;

public class Movies_testData {

    public int statusCode=200;

    public JSONObject expectedData(){
        //Expected
        JSONObject reqBody=new JSONObject();
        reqBody.put("Year","2017");
        reqBody.put("Director","James Gunn");
        reqBody.put("Released","05 May 2017");


        return reqBody;
    }

    public JSONObject expected_SearchMovie(){

        JSONObject reqBody=new JSONObject();
        reqBody.put("Response","True");

        return reqBody;
    }
}
