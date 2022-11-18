package iducs.capstone.subway.controller;

import iducs.capstone.subway.entity.TrainEntity;
import iducs.capstone.subway.service.TrainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {
    private final TrainService trainService;

    public APIController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/line9")
    public List<TrainEntity> trainList(){
        System.out.println("ddd");
        List<TrainEntity> entities = trainService.getTListBySubId("1009");
        System.out.println(entities);
        return entities;
    }
}
