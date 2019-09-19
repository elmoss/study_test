import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class JettyServer {

    static final String absloute_path = "/Users/xinfei/work/study_test";

    public static void main(String[] args) throws Exception {
        Server server = buildNormalServer(9988, "/");
        Connector connector = server.getConnectors()[0];
        connector.setMaxIdleTime(500000);
        server.addConnector(connector);
        server.start();

    }

    /**
     * 创建用于正常运行调试的Jetty Server，以src/main/webapp为Web应用目录。
     */
    public static Server buildNormalServer(int port, String contextPath) {
        Server server = new Server(port);
        WebAppContext webContext = new WebAppContext(absloute_path + "/src/main/webapp", contextPath);
        webContext.setClassLoader(Thread.currentThread().getContextClassLoader());
        webContext.setDefaultsDescriptor(absloute_path + "/src/test/resources/jettyCustom.xml");
        webContext.setMaxFormContentSize(100000000);
        server.setHandler(webContext);
        server.setStopAtShutdown(true);
        return server;
    }
}
