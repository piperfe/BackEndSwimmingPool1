package integrationTest;

import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by macbook on 7/18/15.
 */
public class PlanIntegrationTest extends AbstractIntegrationTest{

    @Test
    public void addPlan() throws Exception {

        Client client = ClientBuilder.newBuilder().build();
        WebTarget target = client.target(tomcat.getUrl() + "/plan/getAll");

        Response response = target.request().get();

        assertThat(response.getStatus(), is(equalTo(404)));

    }

}
