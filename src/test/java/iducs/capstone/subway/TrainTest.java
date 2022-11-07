package iducs.capstone.subway;

import iducs.capstone.subway.domain.Train;
import iducs.capstone.subway.entity.TrainEntity;
import iducs.capstone.subway.repository.TrainRepository;
import net.minidev.json.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@SpringBootTest
public class TrainTest {

    @Autowired
    TrainRepository trainRepository;


    TrainEntity DtoToEntity(Train train){
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
    @Test
    public void load_save() {
        for(int i = 1; i<10; i++) {
            try {
                String result = "";
                URL url = new URL("http://swopenapi.seoul.go.kr/api/subway/" +
                        "1667823730345/json/realtimePosition/0/100/" + i +"호선");
                BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                result = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
                JSONObject CardSubwayStatsNew = (JSONObject) jsonObject.get("CardSubwayStatsNew");
                Long totalCount = (Long) CardSubwayStatsNew.get("list_total_count");

                JSONObject subResult = (JSONObject) CardSubwayStatsNew.get("RESULT");
                JSONArray infoArr = (JSONArray) CardSubwayStatsNew.get("row");

                for (int j = 0; j < infoArr.size(); j++) {
                    JSONObject tmp = (JSONObject) infoArr.get(i);
                    Train infoObj = null;
                    infoObj.setSubwayId((Long)tmp.get("subwayId"));
                    infoObj.setStatnId((Long)tmp.get("statnId"));
                    infoObj.setUpdnLine((Long)tmp.get("updnLine"));
                    infoObj.setStatnTnm((String)tmp.get("statnTnm"));
                    infoObj.setTrainSttus((Long)tmp.get("trainSttus"));
                    infoObj.setDirectAt((Long)tmp.get("directAt"));
                    TrainEntity entity = DtoToEntity(infoObj);
                    trainRepository.save(entity);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
