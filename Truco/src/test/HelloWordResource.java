package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/helloword")
public class HelloWordResource {
	// The Java method will process HTTP GET requests
	 @GET
	 // The Java method will produce content identified by the MIME Media
	 // type "text/plain"
	 @Produces("text/plain")
	 public String getClichedMessage() {
	 // Return some cliched textual content
	 return "Hello World";
	 }

}
