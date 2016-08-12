package integrationTest;

import org.junit.BeforeClass;


public abstract class AbstractIntegrationTest {
    protected static EmbeddedTomcat tomcat;


    @BeforeClass
    public static void setUpClass() {
        final String customUrl = System.getProperty("cashier.integration.test.url");
        if (customUrl == null && tomcat == null) {
            tomcat = new EmbeddedTomcat();
            tomcat.start();
        }

    }
}
