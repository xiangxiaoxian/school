package com.ding.demo.service;

import com.ding.common.Result;
import com.ding.demo.entity.Article;
import com.ding.demo.entity.Carousel;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
public interface CarouselService extends IService<Carousel> {

    Result updateOrInsertCarousel(Carousel carousel);

    Result deletedCarouselById(Long carouselId);
}
