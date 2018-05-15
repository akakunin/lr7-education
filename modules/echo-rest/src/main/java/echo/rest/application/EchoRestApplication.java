package echo.rest.application;

import java.util.Collections;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ru.emdev.echo.EchoApi;

/**
 * @author akakunin
 */
@ApplicationPath("/echo")
@Component(immediate = true, service = Application.class)
public class EchoRestApplication extends Application {
	EchoApi echoApi;
	
	@Reference
	void bindEchoApi(EchoApi echoApi) {
		this.echoApi = echoApi;
	}
	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	@Path("/{message}")
	public String echo(
			@PathParam("message") String message) {
		message = echoApi.echo(message);
		return "Echo message:" + message;
	}
}