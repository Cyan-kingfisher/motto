package witness.my.heart.speech.controller;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import witness.my.heart.speech.service.AffectionService;
import witness.my.heart.speech.service.BeliefService;

import java.io.IOException;
import java.util.Objects;

@Controller
@Slf4j
public class BackController {

    @Autowired
    private AffectionService affectionService;

    @Autowired
    private BeliefService beliefService;

    @Autowired
    private OkHttpClient okHttpClient;

    @RequestMapping("/stepStart")
    public String stepStart(String step) throws IOException {
        FormBody.Builder form = new FormBody.Builder();
        FormBody formBody = form.build();
        final Request request = new Request.Builder().post(formBody).url("http://114.215.82.150:444/mi?phoneNumber=13174280930&password=20000930tanqin&steps=" + step).build();
        Call call = okHttpClient.newCall(request);
        String code = Objects.requireNonNull(call.execute().body()).string();
        if (code.contains("200")) {
            return "index";
        }
        return "404";

    }

    @RequestMapping("/situation")
    public String situation(@NonNull String lover, @NonNull String text, @NonNull String from) {
        log.info(text);
        boolean flag = affectionService.addRecord(lover, text, from);
        if (flag) {
            return "lover";
        } else {
            return "404";
        }
    }

    @RequestMapping("/faith")
    public String belief(@NonNull String text) {
        boolean flag = beliefService.addRecord(text);
        if (flag) {
            return "index";
        } else {
            return "404";
        }
    }


}
