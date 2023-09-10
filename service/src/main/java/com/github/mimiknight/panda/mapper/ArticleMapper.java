package com.github.mimiknight.panda.mapper;

import com.github.mimiknight.panda.model.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 文章表持久化类
 * <p>
 * query：查询
 * remove：删除
 *
 * @author victor2015yhm@gmail.com
 * @since 2023-05-22 07:33:51
 */
@Mapper
@Repository
public interface ArticleMapper {

    /**
     * 保存
     *
     * @param id          id
     * @param title       标题
     * @param article     文章
     * @param createdTime 创建时间
     * @param updatedTime 更新时间
     */
    void save(@Param("id") String id,
              @Param("title") String title,
              @Param("article") String article,
              @Param("createdTime") ZonedDateTime createdTime,
              @Param("updatedTime") ZonedDateTime updatedTime);

    /**
     * 根据文章主键查询文章
     *
     * @param articleIds 文章主键集合
     * @return {@link List}<{@link ArticleEntity}>
     */
    List<ArticleEntity> queryArticleById(@Param("articleIds") List<String> articleIds);
}
