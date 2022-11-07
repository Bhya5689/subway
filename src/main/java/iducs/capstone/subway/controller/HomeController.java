package iducs.capstone.subway.controller;


import iducs.capstone.subway.domain.Train;
import iducs.capstone.subway.entity.TrainEntity;
import iducs.capstone.subway.service.TrainService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Controller // 데이터(처리결과)를 view에게 전달
//@RestController // 자원의 상태(응답)를 클라이언트에 저장
// Restful(Representational State Transfer), OpenAPIs
@RequestMapping
public class HomeController {
    private final TrainService trainService;

    public HomeController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("")
    public String getHome(){
        return "/index.html";
    }

    @GetMapping("/api")
    public String losa() {
        /*String result = "";

        try {

            URL url = new URL("http://swopenapi.seoul.go.kr/api/subway/6a6b5775696b6a6836384766447979/json/realtimePosition/0/100/1%ED%98%B8%EC%84%A0");
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

                trainService.register(entity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        trainService.load_save();
        return "/index.html";
    }

}
