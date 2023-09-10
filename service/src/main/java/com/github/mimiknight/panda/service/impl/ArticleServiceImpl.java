package com.github.mimiknight.panda.service.impl;

import com.github.mimiknight.panda.mapper.ArticleMapper;
import com.github.mimiknight.panda.model.entity.ArticleEntity;
import com.github.mimiknight.panda.service.standard.ArticleService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * 文章表服务接口实现类
 *
 * @author MiMiKnight victor2015yhm@gmail.com
 * @since 2023-08-18 22:38:11
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Transactional
    @Override
    public void save(String title, String article) {
        String id = UUID.randomUUID().toString().replace("-", "");
        ZonedDateTime now = ZonedDateTime.now();
        articleMapper.save(id, title, article, now, now);
    }

    @Override
    public List<ArticleEntity> queryArticleById(List<String> articleIds) {
        if (CollectionUtils.isEmpty(articleIds)) {
            return Collections.emptyList();
        }
        return articleMapper.queryArticleById(articleIds);
    }

}
