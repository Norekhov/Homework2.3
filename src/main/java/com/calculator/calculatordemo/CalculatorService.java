package com.calculator.calculatordemo;

import org.springframework.stereotype.Service;
@Service
public class CalculatorService implements CalculatorServiceInterface {

    public String hello() {
        return "Добро пожаловать в калькулятор";
    }

    public String addition(Integer num1, Integer num2) {
        if (num1 == null || (num2 == null)) {
            return "<b> ОШИБКА, НЕ УКАЗАНО ЧИСЛО(А) </b>";
        } else {
            int addition = num1 + num2;
            return num1 + " + " + num2 + " = " + addition;
        }
    }


    public String subtraction(Integer num1, Integer num2) {
        if (num1 == null || (num2 == null)) {
            return "<b> ОШИБКА, НЕ УКАЗАНО ЧИСЛО(А) </b>";
        } else {
            int subtraction = num1 - num2;
            return num1 + " - " + num2 + " = " + subtraction;
        }
    }

    public String multiplication(Integer num1, Integer num2) {
        if (num1 == null || (num2 == null)) {
            return "<b> ОШИБКА, НЕ УКАЗАНО ЧИСЛО(А) </b>";
        } else {
            int multiplication = num1 * num2;
            return num1 + " * " + num2 + " = " + multiplication;
        }
    }

    public String division(Integer num1, Integer num2) {
        if (num1 == null || (num2 == null)) {
            return "<b> ОШИБКА, НЕ УКАЗАНО ЧИСЛО(А) </b>";
        } else if (num1 == 0 || num2 == 0) {
            return "<b> ОШИБКА, ДЕЛИТЬ НА 0 НЕЛЬЗЯ </b>";
        } else {
            int division = num1 / num2;
            return num1 + " / " + num2 + " = " + division;
        }
    }
}
