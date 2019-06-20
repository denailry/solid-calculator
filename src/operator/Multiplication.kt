package operator

class Multiplication : Operator() {
  override fun calculate(leftOperand: Double, rightOperand: Double) : Double {
    return leftOperand * rightOperand
  }
}
