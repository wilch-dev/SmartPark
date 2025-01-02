package com.walcfpw.smartpark.data.repository;

import com.walcfpw.smartpark.data.repository.entities.ParkingRecordEntity;
import com.walcfpw.smartpark.data.repository.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingRecordRepository extends JpaRepository<ParkingRecordEntity, Long> {
//    ParkingRecordEntity findTopByOrderByInDesc();
//Optional<ParkingRecordEntity> findTopByVehicleEntityOrderByInDesc(VehicleEntity vehicleEntity);
//@Query("SELECT u FROM User u WHERE u.status = 1")
//Collection<User> findAllActiveUsers();
//

    // query designed for H2
@Query(value = "SELECT * FROM parking_record p WHERE p.vehicle=:licensePlate ORDER BY time_in ASC LIMIT 1", nativeQuery = true)
    Optional<ParkingRecordEntity> findLatestIn(@Param("licensePlate") String licensePlate);
}

//@Query("select * from staff where "
//        + " ( name like %:param1% or "
//        + "address like %:param2% or "
//        + "staffNo like %:param3% ) "
//        + "order by name limit 10 offset 0")
//Optional<List<Staff>> findByNameContaining(@Param("param1") String param1,
//                                           @Param("param2") String param2,
//                                           @Param("param3") String param3);
