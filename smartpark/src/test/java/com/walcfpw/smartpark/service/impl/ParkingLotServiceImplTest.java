package com.walcfpw.smartpark.service.impl;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ParkingLotServiceImplTest {

//    @InjectMocks
//    private ParkingLotServiceImpl parkingLotService;
//
//    @Mock
//    private ParkingLotRepository parkingLotRepository;
//
//
//    ParkingLotDto initialInputParkingLot;
//    ParkingLotEntity initialInputParkingLotEntityMock;
//
//
//    @BeforeEach
//    void setUp() {
//
//        initialInputParkingLot = ParkingLotDto.builder()
//                .lotId("AA-210")
//                .location("BGC")
//                .totalCapacity(45)
//                .costPerMinute(2.0)
//                .build();
//
//        initialInputParkingLotEntityMock = ParkingLotEntity.builder()
//                .lotId("AA-210")
//                .location("BGC")
//                .totalCapacity(45)
//                .currentlyOccupiedSlots(0)
//                .costPerMinute(2.0)
//                .build();
//
//    }
//
//    @Test
//    void whenFirstParkingLotIsValidAndNotInDb_thenInputIsSuccessful() throws CostPerMinuteException, TotalCapacityException, ParkingLotIdExistsException {
//        when(parkingLotRepository.getReferenceById(initialInputParkingLot.getLotId())).thenReturn(null);
//        when(parkingLotRepository.save(any())).thenReturn(initialInputParkingLotEntityMock);
//
//        ParkingLotDto resultDto = parkingLotService.registerParkingLot(initialInputParkingLot);
//
//        assertNotNull(resultDto);
//
//    }
}