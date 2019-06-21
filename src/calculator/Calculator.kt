package calculator

import operator.*

const val DEFAULT_INITIAL_VALUE = 0.0

class Calculator() {
  private var currentValue = DEFAULT_INITIAL_VALUE
  private var operation: Operator? = null
  var resultBuffer: Double? = null
    private set

  fun processNumber(value: Double) {
    if (operation == null) {
      currentValue = value;
      resultBuffer = null
    } else {
      currentValue = operation?.calculate(currentValue, value)?:  DEFAULT_INITIAL_VALUE
      resultBuffer = currentValue
      operation = null
    }
  }

  fun processOperator(operation: Operator?) {
    this.operation = operation
    resultBuffer = null
  }
}
