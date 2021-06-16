package witness.my.heart.speech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import witness.my.heart.speech.common.Result;
import witness.my.heart.speech.service.RoundImageService;

@RestController
public class RoundController {

    @Autowired
    private RoundImageService roundImageService;

    @RequestMapping("/back/addImg")
    public Result tractionAddImg(@NonNull String imgUrl) {
        boolean flag = roundImageService.addImage(imgUrl);
        if (flag) {
            return Result.success();
        } else {
            return Result.fail("301", "未知错误");
        }
    }

    @RequestMapping("/back/DelImg")
    public Result tractionDelImg(@NonNull String imgUrl) {
        boolean flag = roundImageService.delImage(imgUrl);
        if (flag) {
            return Result.success();
        } else {
            return Result.fail("301", "未知错误");
        }
    }

    @RequestMapping("/allImg")
    public Result findAllImg() {
        return Result.success("data", roundImageService.getAll());
    }


}
