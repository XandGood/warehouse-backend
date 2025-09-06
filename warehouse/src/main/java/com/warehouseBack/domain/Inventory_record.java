package com.warehouseBack.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
public class Inventory_record implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String record_no;

    private Long product_id;

    private Long warehouse_id;

    private Integer quantity;

    private String type;

    private String reason;

    private Long operator_id;

    private LocalDateTime operate_time;


}
