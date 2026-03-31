package hw;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chenmx
 * @date 2026-3-15
 **/

public class Test02 {

    public static void main(String[] args) {
        String bankAmountStr = "100.00";
        boolean  isFormula=false;
        String formula="银行流水金额=/1.21*0.21";
        if (formula.startsWith("=")) {
            String body = formula.substring(1).trim();
            if (body.matches("^[/\\*\\+\\-\\(].*")) {
                formula = "银行流水金额" + body;
                isFormula = true;
            } else if (body.contains("银行流水金额")) {
                isFormula = true;
            }
        } else if (formula.contains("银行流水金额")) {

            isFormula = true;
        }

    }
}
