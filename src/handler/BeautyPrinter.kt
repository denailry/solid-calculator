package handler

import operator.Operator

class BeautyPrinter : OutputHandler {
  override fun print(output: String) {
    println("> Result: " + output)
  }
}