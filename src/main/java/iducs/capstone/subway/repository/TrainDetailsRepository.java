package iducs.capstone.subway.repository;

import iducs.capstone.subway.entity.TrainDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainDetailsRepository extends JpaRepository<TrainDetailsEntity, Long>,
        QuerydslPredicateExecutor<TrainDetailsEntity> {

    @Query("select t from TrainDetailsEntity t where t.subwayId = :subId")
    List<TrainDetailsEntity> getDetailListBySubId(@Param("subId") String subId);
}
