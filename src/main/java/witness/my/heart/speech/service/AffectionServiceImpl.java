package witness.my.heart.speech.service;

import org.springframework.stereotype.Service;
import witness.my.heart.speech.dao.LoveDAO;
import witness.my.heart.speech.entity.LoveDO;

import javax.annotation.Resource;

/**
 * 感情
 *
 * @author AoJin
 */
@Service
public class AffectionServiceImpl implements AffectionService {

    @Resource
    private LoveDAO loveDAO;

    @Override
    public boolean addRecord(String lover, String text, String from) {
        if (lover.isBlank() || text.isBlank() || from.isBlank()) {
            return false;
        } else {
            LoveDO loveDO = new LoveDO();
            loveDO.setLoveFrom(from);
            loveDO.setLoveText(text);
            loveDO.setLoveTwin(lover);
            loveDAO.save(loveDO);
        }
        return true;
    }

}
