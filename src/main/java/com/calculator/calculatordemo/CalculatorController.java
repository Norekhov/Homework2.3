package com.calculator.calculatordemo;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping(path = "/plus")
    public String addition(@RequestParam(required = false, value = "num1") Integer num1,
                           @RequestParam(required = false, value = "num2") Integer num2) {
        String checkResult = checkParametrs(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "+" + num2 + "=" + (num1 + num2);
        }
    }


    @GetMapping(path = "/minus")
    public String subtraction(@RequestParam(required = false, value = "num1") Integer num1,
                              @RequestParam(required = false, value = "num2") Integer num2) {
        String checkResult = checkParametrs(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "-" + num2 + "=" + (num1 - num2);
        }
    }


    @GetMapping(path = "/multiply")
    public String multiplication(@RequestParam(required = false, value = "num1") Integer num1,
                                 @RequestParam(required = false, value = "num2") Integer num2) {
        String checkResult = checkParametrs(num1, num2);
        if (checkResult != null) {
            return checkResult;
        } else {
            return num1 + "*" + num2 + "=" + (num1 * num2);
        }
    }

    @GetMapping(path = "/divide")
    public String division(@RequestParam(required = false, value = "num1") Integer num1,
                           @RequestParam(required = false, value = "num2") Integer num2) {
        String checkResult = checkParametrs(num1, num2);
        if (checkResult != null) {
            return checkResult;
        }else if (num2 == 0) {
                return "<b> ОШИБКА, ДЕЛИТЬ НА 0 НЕЛЬЗЯ </b>";
        } else {
            return num1 + "/" + num2 + "=" + (num1 / num2);
        }
    }

    private String checkParametrs(Integer num1, Integer num2) {
        if (num1 == null) {
            return "<b> ОШИБКА, НЕ УКАЗАНО ЧИСЛО 1 </b>";
        } else if (num2 == null) {
            return "<b> ОШИБКА, НЕ УКАЗАНО ЧИСЛО 2 </b>";
        }
        return null;
    }

    private String process (Integer num1, Integer num2, String operation) {
        String checkResult = checkParametrs(num1, num2);
        if (checkResult != null) {
            return checkResult;
        }
        int result = switch (operation) {
            case "-" -> calculatorService.subtraction(num1, num2);
            case "*" -> calculatorService.multiplication(num1, num2);
            case "/" -> calculatorService.division(num1, num2);
            default -> calculatorService.addition(num1, num2);
        };
        return "%d %s %d = %d".formatted(num1, operation, num2, result);
    }
}