package com.github.mimiknight.panda.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 公共 MapStruct映射器
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:39:13
 */
@Mapper
public interface CommonMapStruct {

    CommonMapStruct INSTANCE = Mappers.getMapper(CommonMapStruct.class);

//    /**
//     * ArticleEntity转QueryContentByIdResponse
//     *
//     * @param articleEntity 文章表实体类
//     * @return {@link QueryArticleByIdResponse}
//     */
//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "title", target = "title")
//    @Mapping(source = "article", target = "article")
//    @Mapping(source = "deleted", target = "deleted")
//    @Mapping(source = "createdTime", target = "createdTime")
//    @Mapping(source = "updatedTime", target = "updatedTime")
//    QueryArticleByIdResponse convert(ArticleEntity articleEntity);

}
