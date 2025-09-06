package com.warehouseBack.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@ApiModel(value = "Inventory_record", description = "库存记录信息实体")
public class Inventory_record implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库存记录ID", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "库存记录编号", example = "R001")
    private String record_no;

    @ApiModelProperty(value = "关联产品ID", example = "1")
    private Long product_id;

    @ApiModelProperty(value = "关联仓库ID", example = "1")
    private Long warehouse_id;

    @ApiModelProperty(value = "库存数量正数入库负数出库", example = "100")
    private Integer quantity;

    @ApiModelProperty(value = "库存记录类型", example = "IN")
    private String type;

    @ApiModelProperty(value = "库存记录原因", example = "采购")
    private String reason;

    @ApiModelProperty(value = "操作者人 关联user_id", example = "1")
    private Long operator_id;

    @ApiModelProperty(value = "操作时间", example = "2025-09-06 12:00:00")
    private LocalDateTime operate_time;


}
