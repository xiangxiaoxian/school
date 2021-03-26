package com.ding.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author dhr
 * @since 2021-03-23
 */
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 视频id
     */
    private Long vedioId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 父评论id
     */
    private Long parentId;

    /**
     * 父评论昵称
     */
    private String parentNickName;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    /*
    * 用户数据
    * */
    @TableField(exist = false)
    private User user;


}
