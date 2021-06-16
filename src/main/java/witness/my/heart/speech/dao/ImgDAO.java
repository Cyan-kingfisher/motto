package witness.my.heart.speech.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import witness.my.heart.speech.entity.ImgDO;

import java.util.List;

/**
 * @name: AoJin
 * @date: 2021/6/16
 */
@Repository
public interface ImgDAO extends JpaRepository<ImgDO, Integer> {
    List<ImgDO> findAllByImgIsDel(Integer imgIsDel);
}
