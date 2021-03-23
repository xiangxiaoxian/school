package com.ding.demo.service.impl;

import com.ding.demo.entity.Article;
import com.ding.demo.mapper.ArticleMapper;
import com.ding.demo.service.ArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
