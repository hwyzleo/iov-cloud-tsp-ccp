package net.hwyz.iov.cloud.tsp.ccp.service.facade.assembler;

import net.hwyz.iov.cloud.tsp.ccp.api.contract.CcpExService;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.CcpPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 对外服务中央计算平台信息转换类
 *
 * @author hwyz_leo
 */
@Mapper
public interface CcpExServiceAssembler {

    CcpExServiceAssembler INSTANCE = Mappers.getMapper(CcpExServiceAssembler.class);

    /**
     * 数据传输对象转数据对象
     *
     * @param ccpExService 数据传输对象
     * @return 数据对象
     */
    @Mappings({})
    CcpPo toPo(CcpExService ccpExService);

    /**
     * 数据对象转数据传输对象
     *
     * @param ccpPo 数据对象
     * @return 数据传输对象
     */
    @Mappings({})
    CcpExService fromPo(CcpPo ccpPo);

    /**
     * 数据对象列表转数据传输对象列表
     *
     * @param ccpExServiceList 数据传输对象列表
     * @return 数据对象列表
     */
    List<CcpPo> toPoList(List<CcpExService> ccpExServiceList);

}
