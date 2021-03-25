package com.ding.demo.controller;


import com.ding.common.Result;
import com.ding.demo.entity.Article;
import com.ding.demo.entity.Carousel;
import com.ding.demo.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  首页轮播
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
@Api(tags = {"首页轮播"},value = "CarouselController")
@RestController
@RequestMapping("/carousel")
public class CarouselController {
    @Resource
    private CarouselService carouselService;

    @ApiOperation(value = "查询全部轮播")
    @GetMapping
    public Result getAllCarousel() {
        return Result.success("查询成功",carouselService.list());
    }

    @ApiOperation(value = "更新轮播")
    @PutMapping
    public Result updateOrInsertCarousel(@RequestBody Carousel carousel) {
        return carouselService.updateOrInsertCarousel(carousel);
    }

    @ApiOperation(value = "删除数据")
    @DeleteMapping("/{carouselId}")
    public Result deletedCarouselById(@PathVariable() Long carouselId) {
        return carouselService.deletedCarouselById(carouselId);
    }

}
