package calculator

import operator.*

class Calculator() {
  private var currentValue = 0.0
  private var op: Operator? = null
  var resultBuffer: Double? = null
    private set

  fun processNumber(value: Double) {
    if (op == null) {
      currentValue = value;
      resultBuffer = null
    } else {
      currentValue = op!!.calculate(currentValue, value)
      resultBuffer = currentValue
      op = null
    }
  }

  fun processOperator(op: Operator?) {
    this.op = op
    resultBuffer = null
  }
}
