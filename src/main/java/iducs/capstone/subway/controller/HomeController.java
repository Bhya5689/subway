package iducs.capstone.subway.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 데이터(처리결과)를 view에게 전달
//@RestController // 자원의 상태(응답)를 클라이언트에 저장
// Restful(Representational State Transfer), OpenAPIs
@RequestMapping
public class HomeController {
    @GetMapping("")
    public String getHome(){
        return "/index.html";
    }
}
