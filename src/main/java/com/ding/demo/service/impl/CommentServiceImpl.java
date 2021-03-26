package com.ding.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ding.common.Result;
import com.ding.demo.entity.Comment;
import com.ding.demo.mapper.CommentMapper;
import com.ding.demo.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务实现类
 *
 * @author dhr
 * @since 2021-03-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

  @Resource private CommentMapper commentMapper;

  // 更新评论
  @Override
  public Result updateOrInsertComment(Comment comment) {
    if (ObjectUtils.isEmpty(comment.getId())) {
      // 插入评论
      int len = commentMapper.insert(comment);
      if (0 == len) {
        return Result.error(400, "数据错误");
      }
      return Result.success("success", len);
    }
    int len = commentMapper.updateById(comment);
    if (0 == len) {
      return Result.error(400, "修改失败");
    }
    return Result.success("success", len);
  }

  // 删除数据
  @Override
  public Result deletedCommentById(Long commentId) {
    int len = commentMapper.deleteById(commentId);
    if (0 == len) {
      return Result.error(400, "找不到该数据");
    }
    return Result.success("success", len);
  }

  // 按视频id查询评论
  @Override
  public Result getAllCommentByVedioId(Long vedioId) {
    QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
    commentQueryWrapper.eq("c.deleted", 0).eq("c.vedio_id", vedioId);
    List<Comment> comments = commentMapper.getAllCommentByVedioId(commentQueryWrapper);
    return Result.success("success", comments);
  }

  @Override
  public Result getAllComment() {
    QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
    commentQueryWrapper.eq("c.deleted", 0).orderByDesc("c.id");
    List<Comment> comments = commentMapper.getAllComment(commentQueryWrapper);
    return Result.success("success",comments);
  }
}
