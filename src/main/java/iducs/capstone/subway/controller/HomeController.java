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

}
