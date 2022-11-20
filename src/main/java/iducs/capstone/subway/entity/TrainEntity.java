package iducs.capstone.subway.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "trains")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class TrainEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;               //키값

    private String subwayId;          //지하철호선 ID
    private String statnId;           //지하철역 ID
    //private String recptnDt; //최종수신시간
    private String updnLine;          //상하행선구분 (2호선(1:내선 0:외선), 0:상행 1:하행)
    @Column(length=30, nullable=false)
    private String statnTnm;        //종착지하철역명
    private String trainSttus;        //열차상태구분 (0:진입 1:도착, 0,1외 나머지는:출발)
    private String directAt;          //급행여부 (1:급행, 0:아님)


}
