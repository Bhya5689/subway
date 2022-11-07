package iducs.capstone.subway.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "trains")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer")
public class TrainEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;               //키값

    private Long subwayId;          //지하철호선 ID
    private Long statnId;           //지하철역 ID
    private LocalDateTime recptnDt; //최종수신시간
    private Long updnLine;          //상하행선구분 (2호선(1:내선 0:외선), 0:상행 1:하행)
    private String statnTnm;        //종착지하철역명
    private Long trainSttus;        //열차상태구분 (0:진입 1:도착, 0,1외 나머지는:출발)
    private Long directAt;          //급행여부 (1:급행, 0:아님)
}
