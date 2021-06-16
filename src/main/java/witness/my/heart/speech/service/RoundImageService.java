package witness.my.heart.speech.service;

import witness.my.heart.speech.entity.ImgDO;

import java.util.List;

public interface RoundImageService {

    public boolean addImage(String imgUrl);

    public boolean delImage(Integer id);

    /**
     * 随机图
     * @return 图
     */
    public String getImage();

    List<ImgDO> getAll();


}
