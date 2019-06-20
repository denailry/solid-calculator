package operator

class Addition : Operator() {
  override fun calculate(leftOperand: Double, rightOperand: Double) : Double {
    return leftOperand + rightOperand
  }
}
