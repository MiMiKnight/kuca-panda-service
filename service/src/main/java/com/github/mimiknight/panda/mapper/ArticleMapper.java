package com.github.mimiknight.panda.mapper;

import com.github.mimiknight.panda.model.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 文章表持久化类
 * <p>
 * query：查询
 * <p>
 * save：增加
 * <p>
 * update：修改或者更新
 * <p>
 * delete：逻辑删除
 * <p>
 * remove：物理删除
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Mapper
public interface ArticleMapper {

    /**
     * 根据文章主键查找审核中的文章
     *
     * @param articleIds 文章主键id集合
     * @return {@link List}<{@link ArticleEntity}>
     */
    List<ArticleEntity> selectAuditingArticleByIds(@Param("articleIds") List<String> articleIds);

    /**
     * 文章审核
     *
     * @param articleIds  文章主键id集合
     * @param auditResult 审核状态
     */
    void audit(@Param("articleIds") List<String> articleIds, @Param("auditResult") int auditResult);

    ArticleEntity getEntityById(@Param("id") String id);

    void updateArticleById(@Param("id") String id, @Param("title") String title, @Param("article") String article, @Param("updatedTime") ZonedDateTime updatedTime);

    void save(@Param("id") String id, @Param("title") String title, @Param("article") String article, @Param("createdTime") ZonedDateTime createdTime, @Param("updatedTime") ZonedDateTime updatedTime);
}
