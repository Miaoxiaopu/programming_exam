package org.example.controller;

import org.example.util.HttpClientUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/voucher")
public class VoucherController {

    @RequestMapping("/getVoucher")
    public Map<String, Object> getVoucher(@RequestParam("voucherCode") String voucherCode) {
        String result = HttpClientUtil.get("https://mynt-exam.mocklab.io/voucher/" + voucherCode + "?key=apikey");
        return new HashMap<String, Object>() {{
            put("result", result);
        }};
    }
}
