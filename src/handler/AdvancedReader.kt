package handler

import operator.Operator
import calculator.Calculator

class AdvancedReader : InputHandler {
  val INPUT_UNKNOWN: Int = 0
  val INPUT_NUMBER: Int = 1
  val INPUT_OPERATOR: Int = 2

  override fun processInput(calculator: Calculator, input: String) {
    val cleanedInputs = input.trim().split(" ").toTypedArray()

    for (s in cleanedInputs) {
      val inputType = getInputType(s)
      
      if (inputType != INPUT_UNKNOWN) {
        if (inputType == INPUT_NUMBER) {
          val operand = s.toDouble()
          calculator.processNumber(operand)
        } else {
          calculator.processOperator(Operator.new(s))
        }

        return
      }
    }

    throw Exception("unexpected input")
  }

  private fun getInputType(input: String) : Int {
    if (isNumber(input)) {
      return INPUT_NUMBER
    } else if (Operator.new(input) != null) {
      return INPUT_OPERATOR
    }
    return INPUT_UNKNOWN
  }

  private fun isNumber(s: String) : Boolean {
    try {
      s.toDouble()
      return true
    } catch (e : NumberFormatException) {
      return false
    }
  }
}