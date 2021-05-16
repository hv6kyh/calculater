package kr.co.doctornow.calculater.controller;

import kr.co.doctornow.calculater.application.CalculateFeeService;
import kr.co.doctornow.calculater.application.Money;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeeController {

    private CalculateFeeService calculateFeeService = new CalculateFeeService();

    @PostMapping("/fee")
    public ResponsePriceDto calculateFee(@RequestBody RequestPriceDto dto) throws Exception {
        Money finalMoney = this.calculateFeeService.calculateFee(new Money(dto.getPrice()));
        ResponsePriceDto response = new ResponsePriceDto();
        response.setPrice(finalMoney.getAmount());
        return response;
    }
}
