package iducs.capstone.subway.service;

import iducs.capstone.subway.domain.Train;
import iducs.capstone.subway.domain.TrainDetails;
import iducs.capstone.subway.entity.TrainDetailsEntity;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface TrainDetailService {
    public void load_save(String str) throws UnsupportedEncodingException;
    public void register(TrainDetailsEntity trainDetailsEntity);
    public List<TrainDetailsEntity> getTListByStaNm(String subId);

    default TrainDetailsEntity DtoToEntity(TrainDetails trainDetails){
        TrainDetailsEntity entity = TrainDetailsEntity.builder()
                .seq(trainDetails.getSeq())
                .subwayId(trainDetails.getSubwayId())
                .statnNm(trainDetails.getStatnNm())
                .ordkey(trainDetails.getOrdkey())
                .bstatnNm(trainDetails.getBstatnNm())
                .btrainSttus(trainDetails.getBtrainSttus())
                .statnFid(trainDetails.getStatnFid())
                .statnTid(trainDetails.getStatnTid())
                .barvlDt(trainDetails.getBarvlDt())
                .build();
        return entity;
    }
    default TrainDetails EntityToDto(TrainDetailsEntity entity){
        TrainDetails trainDetails = TrainDetails.builder()
                .seq(entity.getSeq())
                .subwayId(entity.getSubwayId())
                .statnNm(entity.getStatnNm())
                .ordkey(entity.getOrdkey())
                .bstatnNm(entity.getBstatnNm())
                .btrainSttus(entity.getBtrainSttus())
                .statnFid(entity.getStatnFid())
                .statnTid(entity.getStatnTid())
                .barvlDt(entity.getBarvlDt())
                .build();
        return trainDetails;
    }
}
