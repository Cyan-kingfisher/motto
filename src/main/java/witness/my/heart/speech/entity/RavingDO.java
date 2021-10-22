package witness.my.heart.speech.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @name: AoJin
 * @date: 2021/10/22
 */
@Entity(name = "raving")
@Data
public class RavingDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ravingText;

    @Column(insertable = false)
    private Integer ravingIsDel;

    @Column(insertable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(insertable = false, updatable = false)
    private LocalDateTime updateTime;
}
