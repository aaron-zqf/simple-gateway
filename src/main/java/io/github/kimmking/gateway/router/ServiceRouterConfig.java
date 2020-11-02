package io.github.kimmking.gateway.router;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceRouterConfig {

    private static ConcurrentHashMap routeMap = new ConcurrentHashMap<>();

    public static void initRouterTable(){
        Locale locale;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("router", Locale.getDefault());
        Enumeration<String> keys = resourceBundle.getKeys();
        while(keys.hasMoreElements()){
            String uri = keys.nextElement();
            String targetHost = resourceBundle.getString(uri);
            routeMap.put(uri,targetHost);
        }
    }

}
