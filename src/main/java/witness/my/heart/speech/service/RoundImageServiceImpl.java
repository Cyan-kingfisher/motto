package witness.my.heart.speech.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witness.my.heart.speech.common.Content;
import witness.my.heart.speech.util.RedisUtil;

import java.util.List;

/**
 * @author AoJin
 */
@Service
public class RoundImageServiceImpl implements RoundImageService {

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public boolean addImage(String imgUrl) {
        if (imgUrl == null || imgUrl.equals("")) {
            return false;
        }
        return redisUtil.lSet(Content.REDIS_QUEUE_IMG, imgUrl);
    }

    @Override
    public boolean delImage(String img) {
        if (img == null || img.equals("")) {
            return false;
        }
        redisUtil.lRemove(Content.REDIS_QUEUE_IMG, 0, img);
        return true;
    }

    @Override
    public String getImage() {
        if (!redisUtil.hasKey(Content.REDIS_QUEUE_IMG)) {
            return "error";
        }

        String img = (String) redisUtil.lPop(Content.REDIS_QUEUE_IMG, 1);
        redisUtil.lSet(Content.REDIS_QUEUE_IMG, img);
        return img;
    }

    @Override
    public List<Object> getAll() {
        if (!redisUtil.hasKey(Content.REDIS_QUEUE_IMG)) {
            return null;
        }
        return redisUtil.lGet(Content.REDIS_QUEUE_IMG,0 ,-1);
    }

}
