package com.github.mimiknight.panda.service.standard;

/**
 * 文章表服务接口
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:38:50
 */
public interface ArticleService {

    /**
     * 保存文章
     *
     * @param title   标题
     * @param article 文章
     */

    void save(String title, String article);
}
