package com.ding.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
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
public class Vedio implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 唯一主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 视频地址
     */
    private String vedioAddress;

    /**
     * 视频标题
     */
    private String vedioTitle;

    /**
     * 逻辑删除
     */
    private Integer deleted;


}
