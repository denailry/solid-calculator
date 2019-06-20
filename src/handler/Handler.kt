package handler

import calculator.Calculator

interface IOHandler : InputHandler, OutputHandler

interface InputHandler {
  fun processInput(calculator: Calculator, input: String)
}

interface OutputHandler {
  fun print(output: String)
}
