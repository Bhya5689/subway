package iducs.capstone.subway.repository;

import iducs.capstone.subway.entity.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainRepository extends JpaRepository<TrainEntity, Long>,
        QuerydslPredicateExecutor<TrainEntity> {

    @Query("select t from TrainEntity t where t.subwayId = :subId")
    List<TrainEntity> getTrainListBySubId(@Param("subId") String subId);
}
