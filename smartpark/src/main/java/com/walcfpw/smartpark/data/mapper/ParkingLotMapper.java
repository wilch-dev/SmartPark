package com.walcfpw.smartpark.data.mapper;

import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.data.repository.entities.ParkingLotEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ParkingLotMapper {
    ParkingLotMapper INSTANCE = Mappers.getMapper( ParkingLotMapper.class );
    ParkingLotDto toDto(ParkingLotEntity parkingLotEntity);
    ParkingLotEntity toEntity(ParkingLotDto parkingLotDto);
}
