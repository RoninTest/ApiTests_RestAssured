package baseURL_Store;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class MoviesUrl {

    protected String moviesUrl="http://www.omdbapi.com/";
    protected RequestSpecification specMoviesUrl;

    @Before
    public void setUp(){
        specMoviesUrl=new RequestSpecBuilder()
                .setBaseUri(moviesUrl)
                .addParam("apikey","bd0a8710")
                .addFormParam("i","tt3896198")
                .build();

    }
}
