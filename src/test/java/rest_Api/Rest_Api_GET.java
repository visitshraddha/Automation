/*
 * Author: Shraddha Jamdade
 * Description- This test is for API test Automation
 * Date: 03-JUL-2018 
 * 
 */


package rest_Api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Rest_Api_GET {
	
	//This test is for verify Get request and returns status code 200 if it pass
		@Test
		public void testStatusCode(){
		int code=get("https://jsonplaceholder.typicode.com/comments").getStatusCode();
		System.out.println("Status Code is" + code);
		Assert.assertEquals(code, 200);
	}
	
	//This test is for verification of 5 elements in response of GET request.
	@Test
		public void verifyPostElements(){
		
		get("https://jsonplaceholder.typicode.com/comments?postId=40").then().assertThat()
		.body("id", hasItems(196, 197, 198, 199, 200));
		
		
	}
		
	
	//This test is to verify JSON string in response of GET request.
	@Test
	public void verifyData(){
		
		given()
        .expect()
        .statusCode(200)
        .body(
             "id", hasItems(199),
             "name", hasItems("pariatur aspernatur nam atque quis"),
             "email", hasItems("Cooper_Boehm@damian.biz"),
             "body", hasItems("veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla")
             ).
        when().
        get("https://jsonplaceholder.typicode.com/comments?postId=40");
		
	}
		
}

	