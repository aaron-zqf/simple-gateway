package io.github.kimmking.gateway.context;

import io.github.kimmking.gateway.router.ServiceRouterHandler;

/**
 * 初始化系统环境相关配置信息
 * @author aaron
 */
public class EnvironmentConfiguration {

    /**
     * 初始化环境相关配置
     */
    public static void initialization(){
        ServiceRouterHandler.initRouterTable();
    }

}
