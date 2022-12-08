package iducs.capstone.subway.service;

import iducs.capstone.subway.entity.TrainDetailsEntity;
import iducs.capstone.subway.repository.TrainDetailsRepository;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
@Log4j2
public class TrainDetailServiceImpl implements TrainDetailService {
    private final TrainDetailsRepository trainDetailsRepository;

    public TrainDetailServiceImpl(TrainDetailsRepository trainDetailsRepository) {
        this.trainDetailsRepository = trainDetailsRepository;
    }

    public void load_save(String str) {
        trainDetailsRepository.deleteAll();
        String result = "";
        StringBuilder sb = new StringBuilder();

        byte[] getBytesFromString = str.getBytes(StandardCharsets.UTF_8);
        BigInteger bigInteger = new BigInteger(1, getBytesFromString);

        String convertedResult = String.format("%x", bigInteger);

        char [] charArr = convertedResult.toCharArray();

        for (int i = 0; i < charArr.length; i++){
            if (i%2 == 0){
                sb.append("%");
                sb.append(charArr[i]);
            }
            else {
                sb.append(charArr[i]);
            }
        }
        str = sb.toString();
        System.out.println(str);

        try {

                URL url = new URL("http://swopenapi.seoul.go.kr/api/subway/6a6b5775696b6a6836384766447979/json/realtimeStationArrival/0/30/"+ str);
                BufferedReader bf;
                bf = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                result = bf.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);




                JSONArray infoArr = (JSONArray) jsonObject.get("realtimeArrivalList");

                for (int i = 0; i < infoArr.size(); i++) {
                    JSONObject tmp = (JSONObject) infoArr.get(i);
                    TrainDetailsEntity entity = TrainDetailsEntity.builder()
                            .subwayId((String) tmp.get("subwayId"))
                            .statnNm((String) tmp.get("statnNm"))
                            .ordkey((String) tmp.get("ordkey"))
                            .bstatnNm((String)tmp.get("bstatnNm"))
                            .btrainSttus((String) tmp.get("btrainSttus"))
                            .statnFid((String) tmp.get("statnFid"))
                            .statnTid((String) tmp.get("statnTid"))
                            .barvlDt((String) tmp.get("barvlDt"))
                            .arvlMsg2((String) tmp.get("arvlMsg2"))
                            .build();
                    trainDetailsRepository.save(entity);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    @Override
    public void register(TrainDetailsEntity trainDetailsEntity) {
        trainDetailsRepository.save(trainDetailsEntity);
    }

    @Override
    public List<TrainDetailsEntity> getTListBySubId(String  subId) {
        List<TrainDetailsEntity> entities = trainDetailsRepository.getDetailListBySubId(subId);
        return entities;
    }
}
