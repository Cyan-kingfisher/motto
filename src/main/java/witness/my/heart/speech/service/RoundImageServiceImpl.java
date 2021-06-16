package witness.my.heart.speech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witness.my.heart.speech.common.Content;
import witness.my.heart.speech.dao.ImgDAO;
import witness.my.heart.speech.entity.ImgDO;
import witness.my.heart.speech.util.RedisUtil;

import java.util.List;

/**
 * @name: AoJin
 * @date: 2021/6/16
 */
@Service
public class RoundImageServiceImpl implements RoundImageService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ImgDAO imgDAO;

    @Override
    public boolean addImage(String imgUrl) {
        ImgDO imgDO = new ImgDO();
        imgDO.setImgUrl(imgUrl);
        imgDAO.save(imgDO);
        return true;
    }

    @Override
    public boolean delImage(Integer id) {
        ImgDO imgDO = imgDAO.getOne(id);
        imgDO.setImgIsDel(1);
        imgDAO.save(imgDO);
        return true;
    }

    /**
     * 随机图
     *
     * @return 图
     */
    @Override
    public String getImage() {
        List<ImgDO> list = imgDAO.findAllByImgIsDel(0);
        int size = list.size();
        int res = (int) (size * Math.random());
        if (redisUtil.hasKey(Content.REDIS_QUEUE_IMG)) {
            int flag = (Integer) redisUtil.get(Content.REDIS_QUEUE_IMG);
            while (res == flag) {
                res = (int) (size * Math.random());
            }
        }
        redisUtil.set(Content.REDIS_QUEUE_IMG, res);
        return list.get(res).getImgUrl();
    }

    @Override
    public List<ImgDO> getAll() {
        return imgDAO.findAllByImgIsDel(0);
    }
}
