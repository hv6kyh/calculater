package kr.co.doctornow.calculater.controller;

import kr.co.doctornow.calculater.application.CalculateFeeService;
import kr.co.doctornow.calculater.application.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeeController {

    private CalculateFeeService calculateFeeService;

    @Autowired
    public FeeController(CalculateFeeService calculateFeeService) {
        this.calculateFeeService = calculateFeeService;
    }

    @PostMapping("/fee")
    public ResponsePriceDto calculateFee(@RequestBody RequestPriceDto dto) throws Exception {
        if (dto.getPrice() < 1000 || dto.getPrice() > 999999) {
            throw new Exception("유효한 범위의 금액을 입력해주세요.");
        }
        Money finalMoney = this.calculateFeeService.calculateFee(new Money(dto.getPrice()));
        ResponsePriceDto response = new ResponsePriceDto();
        response.setPrice(finalMoney.getAmount());
        return response;
    }
}
