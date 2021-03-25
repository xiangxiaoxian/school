package com.ding.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ding.common.Result;
import com.ding.demo.entity.Article;
import com.ding.demo.mapper.ArticleMapper;
import com.ding.demo.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jdk.nashorn.internal.ir.ReturnNode;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * 服务实现类
 *
 * @author dhr
 * @since 2021-03-23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;


  // 更新文章
  @Override
  public Result updateOrInsertArticle(Article article) {
      if (ObjectUtils.isEmpty(article.getId())){
          //实体id为空，插入数据
          int len=articleMapper.insert(article);
          if (0==len){
              return Result.error(400,"数据错误，新增失败");
          }
          return Result.success("新增成功",len);
      }
      int len = articleMapper.updateById(article);
      if (0==len){
          return Result.error(400,"更新失败");
      }
      return Result.success("success",len);
  }

  // 删除文章
  @Override
  public Result deletedArticleById(Long articleId) {
      int len = articleMapper.deleteById(articleId);
      if (0==len){
          return Result.error(400,"数据不存在");
      }
      return Result.success("success",len);
  }
}
