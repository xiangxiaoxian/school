package com.ding.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ding.demo.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
public interface CommentMapper extends BaseMapper<Comment> {

    List<Comment> getAllCommentByVedioId(@Param(Constants.WRAPPER) QueryWrapper<Comment> commentQueryWrapper);

    List<Comment> getAllComment(@Param(Constants.WRAPPER) QueryWrapper<Comment> commentQueryWrapper);
}
