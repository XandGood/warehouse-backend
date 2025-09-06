package com.warehouseBack.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author XAG
 * @since 2025-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Product", description = "产品信息实体")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品ID", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "产品编码", example = "P001")
    private String code;

    private String name;

    private String category;

    private String specification;

    private String unit;

    private Integer warning_stock;

    private Integer status;


}
