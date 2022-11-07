package iducs.capstone.subway.domain;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class Train {
    private Long seq;
    private String subwayId;              //지하철 호선 ID
    //private String subwayNm;            //지하철 호선명
    private String statnId;               //지하철역 ID
    //private String statnNm;             //지하철역명
    //private Long trainNo;               //열차번호
    //private LocalDate lastRecptnDt;     //최종수신날짜
    //private String recptnDt;     //최종수신시간
    private String updnLine;              //상하행선 구분 (2호선(1:내선 0:외선), 0:상행 1:하행)
    //private Long statnTid;              //종착 지하철역 ID
    private String statnTnm;            //종착 지하철역명
    private String trainSttus;            //열차상태구분 (0:진입 1:도착, 0,1외 나머지는:출발)
    private String directAt;              //급행여부 (1:급행, 0:아님)
    //private Long lstcarAt;              //막차여부 (1:막차, 0:아님)

}
