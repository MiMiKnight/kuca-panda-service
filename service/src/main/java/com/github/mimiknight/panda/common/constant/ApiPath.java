package com.github.mimiknight.panda.common.constant;

/**
 * 接口路径
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
public interface ApiPath {

    /**
     * 项目顶级前缀
     */
    String TOP_PREFIX = "/rest/developer/panda-service";

    /**
     * 模块路径
     */
    interface Module {

        /**
         * 健康检查模块
         */
        String HEALTH = TOP_PREFIX + "/health";

        /**
         * 文章模块
         */
        String ARTICLE = TOP_PREFIX + "/article";

    }
}
