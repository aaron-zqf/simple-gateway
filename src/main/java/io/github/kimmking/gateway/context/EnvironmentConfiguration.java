package io.github.kimmking.gateway.context;

import io.github.kimmking.gateway.router.ServiceRouterConfig;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 初始化系统环境相关配置信息
 * @author aaron
 */
public class EnvironmentConfiguration {

    /**
     * 初始化环境相关配置
     */
    public static void initialization(){
        ServiceRouterConfig.initRouterTable();
    }

}
