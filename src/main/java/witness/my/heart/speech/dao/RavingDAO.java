package witness.my.heart.speech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import witness.my.heart.speech.entity.RavingDO;

import java.util.List;

/**
 * @name: AoJin
 * @date: 2021/10/22
 */
@Repository
public interface RavingDAO extends JpaRepository<RavingDO, Integer> {
    List<RavingDO> findAllByRavingIsDel(Integer ravingIsDel);
}
