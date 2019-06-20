package handler

import operator.Operator
import calculator.Calculator

class BasicHandler : IOHandler {
  override fun processInput(calculator: Calculator, input: String) {
    try {
      val operand = input.toDouble()
      calculator.processNumber(operand)
    } catch (e : NumberFormatException) {
      val op = Operator.new(input)

      if (op == null) {
        throw Exception("unexpected input")
      }

      calculator.processOperator(op)
    }
  }

  override fun print(output: String) {
    println(output)
  }
}
