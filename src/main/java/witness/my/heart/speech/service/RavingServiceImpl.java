package witness.my.heart.speech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import witness.my.heart.speech.dao.RavingDAO;
import witness.my.heart.speech.entity.RavingDO;

/**
 * @name: AoJin
 * @date: 2021/10/22
 */
@Service
public class RavingServiceImpl implements RavingService {

    @Autowired
    private RavingDAO ravingDAO;

    @Override
    public boolean addRecord(String text) {
        if (text.isBlank()) {
            return false;
        }
        RavingDO ravingDO = new RavingDO();
        ravingDO.setRavingText(text);
        ravingDAO.save(ravingDO);
        return true;
    }
}
