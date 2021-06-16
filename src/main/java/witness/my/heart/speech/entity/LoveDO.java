package witness.my.heart.speech.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @name: AoJin
 * @date: 2021/6/16
 */
@Entity(name = "love")
@Data
public class LoveDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String loveTwin;

    private String loveText;

    private String loveFrom;

    @Column(insertable = false)
    private Integer loveIsDel;

    @Column(insertable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(insertable = false, updatable = false)
    private LocalDateTime updateTime;

}
