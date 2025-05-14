package net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.CcpLogPo;
import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 中央计算平台信息变更日志表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-14
 */
@Mapper
public interface CcpLogDao extends BaseDao<CcpLogPo, Long> {

}
