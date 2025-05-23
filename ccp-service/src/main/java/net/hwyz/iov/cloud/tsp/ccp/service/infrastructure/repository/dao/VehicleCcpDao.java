package net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.VehicleCcpPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 车辆中央计算平台表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-23
 */
@Mapper
public interface VehicleCcpDao extends BaseDao<VehicleCcpPo, Long> {

}
