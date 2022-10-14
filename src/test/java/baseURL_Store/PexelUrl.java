package baseURL_Store;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PexelUrl {

    protected String pexelBase_Url = "https://api.pexels.com/v1/";

    protected RequestSpecification specPexel;

    @Before
    public void setUp(){

        specPexel=new RequestSpecBuilder()
                .setBaseUri(pexelBase_Url)
                .build();

    }
}
