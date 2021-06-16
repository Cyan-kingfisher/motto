package witness.my.heart.speech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import witness.my.heart.speech.entity.LoveDO;

import java.util.List;

/**
 * @name: AoJin
 * @date: 2021/6/16
 */
@Repository
public interface LoveDAO extends JpaRepository<LoveDO, Integer> {
    List<LoveDO> findAllByLoveIsDel(Integer loveIsDel);
}
