package iducs.capstone.subway.service;

import iducs.capstone.subway.domain.Train;
import iducs.capstone.subway.domain.TrainDetails;
import iducs.capstone.subway.entity.TrainDetailsEntity;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface TrainDetailService {
    public void load_save(String str);
    public void register(TrainDetailsEntity trainDetailsEntity);
    public List<TrainDetailsEntity> getTListBySubId(String subId);

}
