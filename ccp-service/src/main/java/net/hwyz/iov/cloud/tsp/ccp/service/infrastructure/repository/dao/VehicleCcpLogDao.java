package net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.VehicleCcpLogPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 车辆中央计算平台变更日志表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-23
 */
@Mapper
public interface VehicleCcpLogDao extends BaseDao<VehicleCcpLogPo, Long> {

}
