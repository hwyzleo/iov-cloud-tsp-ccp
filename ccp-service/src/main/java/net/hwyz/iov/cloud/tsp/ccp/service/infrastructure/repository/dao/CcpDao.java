package net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.dao;

import net.hwyz.iov.cloud.framework.mysql.dao.BaseDao;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.CcpPo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 中央计算平台信息表 DAO
 * </p>
 *
 * @author hwyz_leo
 * @since 2025-05-14
 */
@Mapper
public interface CcpDao extends BaseDao<CcpPo, Long> {

    /**
     * 根据序列号查询中央计算平台信息
     *
     * @param sn 序列号
     * @return 中央计算平台信息
     */
    CcpPo selectBySn(String sn);

}
