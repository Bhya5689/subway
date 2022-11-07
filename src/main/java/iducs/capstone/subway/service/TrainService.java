package iducs.capstone.subway.service;

import iducs.capstone.subway.domain.Train;
import iducs.capstone.subway.entity.TrainEntity;

public interface TrainService {
    public void load_save();
    public void register(TrainEntity trainEntity);

    default TrainEntity DtoToEntity(Train train){
        TrainEntity entity = TrainEntity.builder()
                .seq(train.getSeq())
                .subwayId(train.getSubwayId())
                .statnId(train.getStatnId())
                .updnLine(train.getUpdnLine())
                .statnTnm(train.getStatnTnm())
                .trainSttus(train.getTrainSttus())
                .directAt(train.getDirectAt())
                .build();
        return entity;
    }
    default Train EntityToDto(TrainEntity entity){
        Train train = Train.builder()
                .seq(entity.getSeq())
                .subwayId(entity.getSubwayId())
                .statnId(entity.getStatnId())
                .updnLine(entity.getUpdnLine())
                .statnTnm(entity.getStatnTnm())
                .trainSttus(entity.getTrainSttus())
                .directAt(entity.getDirectAt())
                .build();
        return train;
    }
}
