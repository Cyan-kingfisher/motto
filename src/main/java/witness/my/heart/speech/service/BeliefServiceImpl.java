package witness.my.heart.speech.service;

import org.springframework.stereotype.Service;
import witness.my.heart.speech.dao.BibleDAO;
import witness.my.heart.speech.entity.BibleDO;

import javax.annotation.Resource;

/**
 * @author AoJin
 */
@Service
public class BeliefServiceImpl implements BeliefService {

    @Resource
    private BibleDAO bibleDAO;

    @Override
    public boolean addRecord(String text) {
        if (text.isBlank()) {
            return false;
        }
        BibleDO bibleDO = new BibleDO();
        bibleDO.setBibleText(text);
        bibleDAO.save(bibleDO);
        return true;
    }
}
