package com.ding.demo.controller;

import com.ding.common.Result;
import com.ding.demo.entity.Comment;
import com.ding.demo.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 评论
 *
 * @author dhr
 * @since 2021-03-23
 */
@Api(
    tags = {"视频评论"},
    value = "CommentController")
@RestController
@RequestMapping("/comment")
public class CommentController {
  @Resource private CommentService commentService;

  @ApiOperation(value = "查询全部评论")
  @GetMapping
  public Result getAllComment() {
    return Result.success("查询成功", commentService.getAllComment());
  }

  @ApiOperation(value = "更新评论")
  @PutMapping
  public Result updateOrInsertComment(@RequestBody Comment comment) {
    return commentService.updateOrInsertComment(comment);
  }

  @ApiOperation(value = "删除数据")
  @DeleteMapping("/{commentId}")
  public Result deletedCommentById(@PathVariable() Long commentId) {
    return commentService.deletedCommentById(commentId);
  }

  @ApiOperation(value = "按视频id查询评论")
  @GetMapping("/{vedioId}")
  public Result getAllCommentByVedioId(@PathVariable Long vedioId) {
    return commentService.getAllCommentByVedioId(vedioId);
  }
}
