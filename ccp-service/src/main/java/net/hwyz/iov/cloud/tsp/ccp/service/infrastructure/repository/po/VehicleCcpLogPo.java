package net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import net.hwyz.iov.cloud.framework.mysql.po.BasePo;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * <p>
 * 车辆中央计算平台变更日志表 数据对象
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-23
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_vehicle_ccp_log")
public class VehicleCcpLogPo extends BasePo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 车架号
     */
    @TableField("vin")
    private String vin;

    /**
     * 序列号
     */
    @TableField("sn")
    private String sn;
}
