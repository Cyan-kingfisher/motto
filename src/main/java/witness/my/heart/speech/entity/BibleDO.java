package witness.my.heart.speech.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @name: AoJin
 * @date: 2021/6/16
 */
@Entity(name = "bible")
@Data
public class BibleDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bibleText;

    @Column(insertable = false)
    private Integer bibleIsDel;

    @Column(insertable = false, updatable = false)
    private LocalDateTime createTime;

    @Column(insertable = false, updatable = false)
    private LocalDateTime updateTime;

}
