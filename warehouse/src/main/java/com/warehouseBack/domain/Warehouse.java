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
@ApiModel(value = "Warehouse", description = "仓库信息实体")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库ID", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "仓库名称", example = "仓库A")
    private String name;

    @ApiModelProperty(value = "仓库地址", example = "北京市朝阳区")
    private String location;

    @ApiModelProperty(value = "仓库管理员", example = "张三")
    private String manager;


}
