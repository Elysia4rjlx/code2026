package com.elyjah._026_09_29springmvc4;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc")
public class CalcController {

    @RequestMapping(value = "/calculate")
    public String calculate(Integer num1, Integer num2, String operator) {

        // 判断参数是否合法
        if (num1 == null || num2 == null || operator == null) {
            return """
                    <h1>参数不合法！！请重新输入</h1>
                    <br>
                    <button onclick="history.back()">返回计算器</button>
                    """;
        }

        Integer result;

        switch (operator) {

            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    return """
                            <h1>除数不能为 0</h1>
                            <br>
                            <button onclick="history.back()">返回计算器</button>
                            """;
                }

                result = num1 / num2;
                break;

            default:
                return """
                        <h1>不支持的运算类型</h1>
                        <br>
                        <button onclick="history.back()">返回计算器</button>
                        """;
        }

        return """
                <h1>计算结果：%d</h1>
                <br>
                <button onclick="history.back()">返回计算器</button>
                """.formatted(result);
    }
}