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

    @GetMapping("/line1")
    public List<TrainEntity> trainList1(){
        List<TrainEntity> entities = trainService.getTListBySubId("1001");
        System.out.println(entities);
        return entities;
    }

    @GetMapping("/line2")
    public List<TrainEntity> trainList2(){
        List<TrainEntity> entities = trainService.getTListBySubId("1002");
        System.out.println(entities);
        return entities;
    }

    @GetMapping("/line3")
    public List<TrainEntity> trainList3(){
        List<TrainEntity> entities = trainService.getTListBySubId("1003");
        System.out.println(entities);
        return entities;
    }

    @GetMapping("/line4")
    public List<TrainEntity> trainList4(){
        List<TrainEntity> entities = trainService.getTListBySubId("1004");
        System.out.println(entities);
        return entities;
    }

    @GetMapping("/line5")
    public List<TrainEntity> trainList5(){
        List<TrainEntity> entities = trainService.getTListBySubId("1005");
        System.out.println(entities);
        return entities;
    }

    @GetMapping("/line6")
    public List<TrainEntity> trainList6(){
        List<TrainEntity> entities = trainService.getTListBySubId("1006");
        System.out.println(entities);
        return entities;
    }

    @GetMapping("/line7")
    public List<TrainEntity> trainList7(){
        List<TrainEntity> entities = trainService.getTListBySubId("1007");
        System.out.println(entities);
        return entities;
    }

    @GetMapping("/line8")
    public List<TrainEntity> trainList8(){
        List<TrainEntity> entities = trainService.getTListBySubId("1008");
        System.out.println(entities);
        return entities;
    }

    @GetMapping("/line9")
    public List<TrainEntity> trainList(){
        List<TrainEntity> entities = trainService.getTListBySubId("1009");
        System.out.println(entities);
        return entities;
    }
}
