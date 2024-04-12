package com.calculator.calculatordemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calculator")
@RestController
public class CalculatorController {
    private final CalculatorServiceInterface calculatorService;

    public CalculatorController(CalculatorServiceInterface calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping
    public String hello() {
        return calculatorService.hello();
    }

    @RequestMapping(path = "/plus")
    public String addition(@RequestParam(required = false, value = "num1") Integer num1, @RequestParam(required = false, value = "num2") Integer num2) {
        return calculatorService.addition(num1, num2);
    }

    @RequestMapping(path = "/minus")
    public String subtraction(@RequestParam(required = false, value = "num1") Integer num1, @RequestParam(required = false, value = "num2") Integer num2) {
        return calculatorService.subtraction(num1, num2);
    }

    @RequestMapping(path = "/multiply")
    public String multiplication(@RequestParam(required = false, value = "num1") Integer num1, @RequestParam(required = false, value = "num2") Integer num2) {
        return calculatorService.multiplication(num1, num2);
    }

    @RequestMapping(path = "/divide")
    public String division(@RequestParam(required = false, value = "num1") Integer num1, @RequestParam(required = false, value = "num2") Integer num2) {
        return calculatorService.division(num1, num2);
    }
}
