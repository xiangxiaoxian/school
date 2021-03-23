package com.ding.demo.service.impl;

import com.ding.demo.entity.Comment;
import com.ding.demo.mapper.CommentMapper;
import com.ding.demo.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
