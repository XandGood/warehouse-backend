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

    @ApiModelProperty(value = "产品名称", example = "苹果")
    private String name;

    @ApiModelProperty(value = "产品类别", example = "水果")
    private String category;

    @ApiModelProperty(value = "产品规格", example = "1kg")
    private String specification;

    @ApiModelProperty(value = "产品单位", example = "个")
    private String unit;

    @ApiModelProperty(value = "产品预警库存", example = "100")
    private Integer warning_stock;

    @ApiModelProperty(value = "产品状态", example = "1")
    private Integer status;


}
