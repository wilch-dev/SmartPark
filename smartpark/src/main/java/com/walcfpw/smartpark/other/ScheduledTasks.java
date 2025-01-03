package com.walcfpw.smartpark.other;

import com.walcfpw.smartpark.service.ParkingRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ScheduledTasks {

    private final ParkingRecordService parkingRecordService;

    //    @Scheduled(cron = "*/10 * * * * *") // Execute 10 seconds
    @Scheduled(cron = "0 * * * * *") // Execute every minute
    public void task1() throws Exception {
        parkingRecordService.getAllParkingRecordsThatArentOutIn15MinsAndTimeThemOut();
    }

}
