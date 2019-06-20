package operator

abstract class Operator {
  companion object {
    fun new(symbol: String) : Operator? {
      when (symbol) {
        "+" -> return Addition()
        "-" -> return Subtraction()
        "*" -> return Multiplication()
        "/" -> return Division()
        else -> return null
      }
    }
  }

  abstract fun calculate(leftOperand: Double, rightOperand: Double) : Double
}
