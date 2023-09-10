package com.github.mimiknight.panda.service.standard;

import com.github.mimiknight.panda.model.entity.ArticleEntity;

import java.util.List;

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

    /**
     * 根据文章主键查询文章
     *
     * @param articleIds 文章主键集合
     * @return {@link List}<{@link ArticleEntity}>
     */
    List<ArticleEntity> queryArticleById(List<String> articleIds);
}
