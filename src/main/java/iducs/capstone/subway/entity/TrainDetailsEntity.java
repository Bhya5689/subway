package iducs.capstone.subway.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "trainsDetail")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TrainDetailsEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    private String subwayId;                //지하철 호선 ID
    private String statnNm;                 //지하철역명
    private String ordkey;                  //도착예정열차순번(상하행코드(1자리), 순번(첫번째, 두번째 열차 , 1자리)
    //첫번째 도착예정 정류장 - 현재 정류장(3자리), 목적지 정류장, 급행여부(1자리))

    private String bstatnNm;                //종착 지하철역명
    private String btrainSttus;             //열차종류(급행,ITX)
    private String statnFid;                //이전지하철ID
    private String statnTid;                //다음지하철ID
    private String barvlDt;                 //열차도착예정시간(단위:초)
    private String arvlMsg2;                //첫번째도착메세지 (전역 진입, 전역 도착 등)


}
