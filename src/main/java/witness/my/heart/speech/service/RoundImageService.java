package witness.my.heart.speech.service;

import java.util.List;

public interface RoundImageService {
    public boolean addImage(String imgUrl);

    public boolean delImage(String img);

    /**
     * 随机图
     * @return 图
     */
    public String getImage();

    List<Object> getAll();


}
