package com.nikita.springboot.controller;


import com.nikita.springboot.BaseResponse;
import com.nikita.springboot.PaymentRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final String shareKey = "SHADER_KEY";
    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;


    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, 1);

    }

    @PostMapping("/pay")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody PaymentRequest paymentRequest) {
        final BaseResponse baseResponse;

        if (shareKey.equalsIgnoreCase(key)) {
            int useId = paymentRequest.getUserId();
            String itemId = paymentRequest.getItemId();
            double discount = paymentRequest.getDiscount();

            baseResponse = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            baseResponse = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return baseResponse;
    }
}
