package integrationTest;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class EmbeddedTomcat {

    private Tomcat tomcat = new Tomcat();

    static {
        System.setProperty("spring.profiles.active", "test");
    }

    final String context = System.getProperty("application.context", "SwimmingPool/rest");

    public void start() {
        try {
            String baseDir = ".";
            tomcat.setPort(0);
            tomcat.setBaseDir(baseDir);
            tomcat.getHost().setAppBase(baseDir);
            tomcat.getHost().setDeployOnStartup(true);
            tomcat.getHost().setAutoDeploy(true);
            tomcat.start();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        }

        deploy(context);
    }

    public void stop() {
        try {
            tomcat.stop();
            tomcat.destroy();
        } catch (LifecycleException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deploy(String contextName) {
        tomcat.addWebapp(tomcat.getHost(), "/" + contextName, "src/main/webapp").getPath();
    }

    public String getUrl() {
            return String.format("http://%s:%d/%s", getHost(), getPort(), context);
    }

    public String getHost() {
        return tomcat.getHost().getName();
    }

    public int getPort() {
        return tomcat.getConnector().getLocalPort();
    }
}
