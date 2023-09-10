package com.github.mimiknight.panda.mapstruct;

import com.github.mimiknight.panda.model.entity.ArticleEntity;
import com.github.mimiknight.panda.model.response.ArticleVO;
import com.github.mimiknight.panda.model.response.QueryArticleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 公共 MapStruct映射器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Mapper(componentModel = "spring")
public interface CommonMapStruct {

//    CommonMapStruct INSTANCE = Mappers.getMapper(CommonMapStruct.class);

    /**
     * ArticleEntity转Article
     *
     * @param entities 文章实体类集合
     * @return {@link QueryArticleResponse}
     */

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "article", target = "content")
    @Mapping(source = "createdTime", target = "createdTime")
    @Mapping(source = "updatedTime", target = "updatedTime")
    List<ArticleVO> convert(List<ArticleEntity> entities);

}
