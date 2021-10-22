package witness.my.heart.speech.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import witness.my.heart.speech.entity.LoveDO;
import witness.my.heart.speech.service.RoundImageService;
import witness.my.heart.speech.service.RoundLiteratureService;

/**
 * @author AoJin
 */
@Controller
@Slf4j
public class BaseController {

    @Autowired
    private RoundImageService roundImageService;

    @Autowired
    private RoundLiteratureService roundLiteratureService;

    @RequestMapping("/up/affection")
    public String situation() {
        return "upLover";
    }

    @RequestMapping("/up/belief")
    public String belief() {
        return "upFaith";
    }

    @RequestMapping("up/upRaving")
    public String raving() {return "upRaving";}

    @RequestMapping("/404")
    public String error() {
        return "404";
    }

    @RequestMapping("/ravingg")
    public String ravingInd(Model model) {

        String img = roundImageService.getImage();
        log.info("faith img: " + img);
        if ("error".equals(img)) {
            return "404";
        }
        model.addAttribute("img", img);

        String text = roundLiteratureService.roundRaving();
        log.info("text:" + text);
        model.addAttribute("text", text);

        return "ravingIndex";
    }

    @RequestMapping("/index")
    public String indexFi(Model model) {
        String img = roundImageService.getImage();
        log.info("faith img: " + img);
        if ("error".equals(img)) {
            return "404";
        }
        model.addAttribute("img", img);
        String text = roundLiteratureService.roundText();
        log.info("text:" + text);
        model.addAttribute("text", text);
        return "faithIndex";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/step")
    public String startStep() {
        return "step";
    }

    @RequestMapping("/lover")
    public String indexSi(Model model) {
        String img = roundImageService.getImage();
        log.info("lover img: " + img);
        if ("error".equals(img)) {
            return "404";
        }
        model.addAttribute("img", img);
        LoveDO affection = roundLiteratureService.roundLover();
        if (null == affection) {
            return "404";
        }
        model.addAttribute("lover", affection);
        return "situationIndex";
    }

}
