package org.study.city;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class Program {
    private static final int PORT = 9500;
    private static String WEB_APP_DIR = "src/webapp/";
    private static String OUT_DIR = "out";

    public static void main(String[] args) throws ServletException, LifecycleException {
        System.setProperty("tomcat.util.scan.StandardJarScanFilter.jarsToSkip", "*.jar");
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);
        Context context = tomcat.addWebapp("", new File(WEB_APP_DIR).getAbsolutePath());

        File classDir = new File(OUT_DIR);
        WebResourceRoot resourceRoot = new StandardRoot(context);
        resourceRoot.addPreResources(new DirResourceSet(resourceRoot, "/WEB-INF/classes",
                classDir.getAbsolutePath(), "/"));
        context.setResources(resourceRoot);
        tomcat.getConnector();
        tomcat.start();
        tomcat.getServer().await();

    }

}
