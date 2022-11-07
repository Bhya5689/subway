package iducs.capstone.subway.service;

import iducs.capstone.subway.domain.Train;
import iducs.capstone.subway.entity.TrainEntity;
import iducs.capstone.subway.repository.TrainRepository;

import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;

@Service
@Log4j2
public class TrainServiceImpl implements TrainService {
    private final TrainRepository trainRepository;

    public TrainServiceImpl(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Scheduled(cron = "0/30 * * * * *", zone = "Asia/Seoul")
    @Override
    public void load_save() {
        trainRepository.deleteAll();
        String result = "";

        for (int j = 1; j<10; j++)
            try {

                URL url = new URL("http://swopenapi.seoul.go.kr/api/subway/6a6b5775696b6a6836384766447979/json/realtimePosition/0/100/"+j+"%ED%98%B8%EC%84%A0");
                BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                result = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);




                JSONArray infoArr = (JSONArray) jsonObject.get("realtimePositionList");

                for (int i = 0; i < infoArr.size(); i++) {
                    JSONObject tmp = (JSONObject) infoArr.get(i);
                    TrainEntity entity = TrainEntity.builder()
                            .subwayId((String) tmp.get("subwayId"))
                            .statnId((String) tmp.get("statnId"))
                            .updnLine((String) tmp.get("updnLine"))
                            .statnTnm((String)tmp.get("statnTnm"))
                            .trainSttus((String) tmp.get("trainSttus"))
                            .directAt((String) tmp.get("directAt"))
                            .build();
                    trainRepository.save(entity);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    @Override
    public void register(TrainEntity trainEntity) {
        trainRepository.save(trainEntity);
    }
}
