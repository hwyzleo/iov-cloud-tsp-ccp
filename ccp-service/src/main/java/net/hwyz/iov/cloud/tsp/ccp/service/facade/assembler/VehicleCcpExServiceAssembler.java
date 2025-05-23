package net.hwyz.iov.cloud.tsp.ccp.service.facade.assembler;

import net.hwyz.iov.cloud.tsp.ccp.api.contract.VehicleCcpExService;
import net.hwyz.iov.cloud.tsp.ccp.service.infrastructure.repository.po.VehicleCcpPo;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 对外服务车辆中央计算平台转换类
 *
 * @author hwyz_leo
 */
@Mapper
public interface VehicleCcpExServiceAssembler {

    VehicleCcpExServiceAssembler INSTANCE = Mappers.getMapper(VehicleCcpExServiceAssembler.class);

    /**
     * 数据传输对象转数据对象
     *
     * @param vehicleCcpExService 数据传输对象
     * @return 数据对象
     */
    @Mappings({})
    VehicleCcpPo toPo(VehicleCcpExService vehicleCcpExService);

    /**
     * 数据对象转数据传输对象
     *
     * @param vehicleCcpPo 数据对象
     * @return 数据传输对象
     */
    @Mappings({})
    VehicleCcpExService fromPo(VehicleCcpPo vehicleCcpPo);

}
