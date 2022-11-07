package iducs.capstone.subway.repository;

import iducs.capstone.subway.entity.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TrainRepository extends JpaRepository<TrainEntity, Long>,
        QuerydslPredicateExecutor<TrainEntity> {
}
