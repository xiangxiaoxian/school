package com.ding.demo.service;

import com.ding.common.Result;
import com.ding.demo.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * 服务类
 *
 * @author dhr
 * @since 2021-03-23
 */
public interface CommentService extends IService<Comment> {

  Result updateOrInsertComment(Comment comment);

  Result deletedCommentById(Long commentId);

  Result getAllCommentByVedioId(Long vedioId);

  Result getAllComment();
}
