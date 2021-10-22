package witness.my.heart.speech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witness.my.heart.speech.common.Content;
import witness.my.heart.speech.dao.BibleDAO;
import witness.my.heart.speech.dao.LoveDAO;
import witness.my.heart.speech.dao.RavingDAO;
import witness.my.heart.speech.entity.BibleDO;
import witness.my.heart.speech.entity.LoveDO;
import witness.my.heart.speech.entity.RavingDO;
import witness.my.heart.speech.util.RedisUtil;

import java.util.List;

/**
 * 文案随机
 *
 * @author AoJin
 */
@Service
public class RoundLiteratureServiceImpl implements RoundLiteratureService {

    @Autowired
    private BibleDAO bibleDAO;

    @Autowired
    private LoveDAO loveDAO;

    @Autowired
    private RavingDAO ravingDAO;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String roundText() {
        List<BibleDO> list = bibleDAO.findAllByBibleIsDel(0);
        int size = list.size();
        int res = (int) (size * Math.random());
        if (redisUtil.hasKey(Content.REDIS_QUEUE_TEXT)) {
            int flag = (Integer) redisUtil.get(Content.REDIS_QUEUE_TEXT);
            while (res == flag) {
                res = (int) (size * Math.random());
            }
        }
        redisUtil.set(Content.REDIS_QUEUE_TEXT, res);
        return list.get(res).getBibleText();
    }

    @Override
    public String roundRaving() {
        List<RavingDO> list = ravingDAO.findAllByRavingIsDel(0);
        int size = list.size();
        int res = (int) (size * Math.random());
        if (redisUtil.hasKey(Content.REDIS_QUEUE_RAVING)) {
            int flag = (Integer) redisUtil.get(Content.REDIS_QUEUE_RAVING);
            while (res == flag) {
                res = (int) (size * Math.random());
            }
        }
        redisUtil.set(Content.REDIS_QUEUE_RAVING, res);
        return list.get(res).getRavingText();
    }

    @Override
    public LoveDO roundLover() {
        List<LoveDO> list = loveDAO.findAllByLoveIsDel(0);
        int size = list.size();
        int res = (int) (size * Math.random());
        if (redisUtil.hasKey(Content.REDIS_QUEUE_LOVER)) {
            int flag = (Integer) redisUtil.get(Content.REDIS_QUEUE_LOVER);
            while (res == flag) {
                res = (int) (size * Math.random());
            }
        }
        redisUtil.set(Content.REDIS_QUEUE_LOVER, res);
        return list.get(res);
    }

}
