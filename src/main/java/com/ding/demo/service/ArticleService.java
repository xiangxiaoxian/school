package com.ding.demo.service;

import com.ding.common.Result;
import com.ding.demo.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 服务类
 *
 * @author dhr
 * @since 2021-03-23
 */
public interface ArticleService extends IService<Article> {


  Result updateOrInsertArticle(Article article);

  Result deletedArticleById(Long articleId);
}
