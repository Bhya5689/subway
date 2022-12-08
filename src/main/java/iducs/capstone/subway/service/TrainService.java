package iducs.capstone.subway.service;

import iducs.capstone.subway.domain.Train;
import iducs.capstone.subway.entity.TrainEntity;

import java.util.List;

public interface TrainService {
    public void load_save();
    public void register(TrainEntity trainEntity);
    public List<TrainEntity> getTListBySubId(String subId);

}
