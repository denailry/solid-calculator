package operator

class Subtraction : Operator() {
  override fun calculate(leftOperand: Double, rightOperand: Double) : Double {
    return leftOperand - rightOperand
  }
}
