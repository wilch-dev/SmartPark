package com.walcfpw.smartpark.service.impl;


//@ActiveProfiles(profiles = "test")
//@SpringBootTest
//@ExtendWith(SpringExtension.class)
public class ParkingLotServiceImplTestIT {

//    private final ParkingLotServiceImpl parkingLotService;
//    private final ParkingLotRepository parkingLotRepository;
//
//    @Autowired
//    public ParkingLotServiceImplTestIT(ParkingLotServiceImpl parkingLotService, ParkingLotRepository parkingLotRepository){
//        this.parkingLotService = parkingLotService;
//        this.parkingLotRepository = parkingLotRepository;
//    }
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
////        when(parkingLotRepository.getReferenceById(initialInputParkingLot.getLotId())).thenReturn(null);
////        when(parkingLotRepository.save(any())).thenReturn(initialInputParkingLotEntityMock);
//
//        ParkingLotDto resultDto = parkingLotService.registerParkingLot(initialInputParkingLot);
//
//        assertNotNull(resultDto);
//
//    }

//    ParkingLotServiceImplTestIT(ParkingLotServiceImpl parkingLotService) {
//        this.parkingLotService = parkingLotService;
//    }

//    @Autowired
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