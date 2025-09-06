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
@ApiModel(value = "Inventory", description = "库存信息实体")
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库存ID", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "关联产品ID", example = "1")
    private Long product_id;

    @ApiModelProperty(value = "关联仓库ID", example = "1")
    private Long warehouse_id;

    @ApiModelProperty(value = "关联库存数量", example = "100")
    private Integer quantity;


}
