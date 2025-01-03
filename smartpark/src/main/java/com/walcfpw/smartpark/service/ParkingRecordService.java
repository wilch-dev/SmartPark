package com.walcfpw.smartpark.service;

import com.walcfpw.smartpark.data.dto.ParkingRecordDto;

import java.util.List;

public interface ParkingRecordService {

    ParkingRecordDto timeIn(ParkingRecordDto parkingRecordDto) throws Exception;
    ParkingRecordDto timeOut(ParkingRecordDto parkingRecordDto) throws Exception;
    List<ParkingRecordDto> getAllParkingRecords() throws Exception;
    List<ParkingRecordDto> getAllRecordsCurrentlyParkedInLot(ParkingRecordDto parkingRecordDto) throws Exception;


    void getAllParkingRecordsThatArentOutIn15MinsAndTimeThemOut()throws Exception;
}
