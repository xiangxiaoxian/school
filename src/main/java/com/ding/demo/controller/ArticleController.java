package com.ding.demo.controller;

import com.ding.common.Result;
import com.ding.demo.entity.Article;
import com.ding.demo.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 前端控制器
 *
 * @author dhr
 * @since 2021-03-23
 */
@Api(tags = {"文章相关接口"} ,value = "ArticleController")
@RestController
@RequestMapping("/article")
public class ArticleController {

  @Resource private ArticleService articleService;

  @ApiOperation(value = "查询全部文章")
  @GetMapping
  public Result getAllArticle() {
    return Result.success("查询成功",articleService.list());
  }

  @ApiOperation(value = "更新文章")
  @PutMapping
  public Result updateOrInsertArticle(@RequestBody Article article) {
    return articleService.updateOrInsertArticle(article);
  }

  @ApiOperation(value = "删除数据")
  @DeleteMapping("/{articleId}")
  public Result deletedArticleById(@PathVariable() Long articleId) {
    return articleService.deletedArticleById(articleId);
  }
}
