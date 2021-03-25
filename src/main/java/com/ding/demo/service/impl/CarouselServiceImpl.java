package com.ding.demo.service.impl;

import com.ding.common.Result;
import com.ding.demo.entity.Carousel;
import com.ding.demo.mapper.CarouselMapper;
import com.ding.demo.service.CarouselService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import javafx.beans.binding.ObjectExpression;
import org.apache.ibatis.annotations.Results;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
@Service
public class CarouselServiceImpl extends ServiceImpl<CarouselMapper, Carousel> implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;
    //更新轮播
    @Override
    public Result updateOrInsertCarousel(Carousel carousel) {
        if (ObjectUtils.isEmpty(carousel.getId())){
            //新增
            int len = carouselMapper.insert(carousel);
            if (0==len){
                return Result.error(400,"数据错误，新增失败");
            }
            return Result.success("success",len);
        }
        int len = carouselMapper.updateById(carousel);
        if (0==len){
            return Result.error(400,"数据错误，修改失败");
        }
        return Result.success("success",len);
    }

    //删除数据
    @Override
    public Result deletedCarouselById(Long carouselId) {
        int len = carouselMapper.deleteById(carouselId);
        if (0==len){
            return Result.error(400,"该数据不存在");
        }
        return Result.success("success",len);
    }
}
