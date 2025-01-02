package com.walcfpw.smartpark.data.mapper;

import com.walcfpw.smartpark.data.dto.VehicleDto;
import com.walcfpw.smartpark.data.repository.entities.VehicleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleMapper {

    VehicleMapper INSTANCE = Mappers.getMapper( VehicleMapper.class );
    VehicleDto toDto(VehicleEntity vehicleEntity);
    VehicleEntity toEntity(VehicleDto vehicleDto);

}
