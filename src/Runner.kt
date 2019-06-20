import handler.*
import calculator.Calculator

class Runner(_inputHandler: InputHandler, _outputHandler: OutputHandler) {
  constructor(handler : IOHandler) : this(handler, handler)

  private var inputHandler = _inputHandler
  private var outputHandler = _outputHandler

  private val calc: Calculator = Calculator()

  fun isConfigurationInput(rawInput: String) : Boolean {
    val input = rawInput.trim()
    if (input.length > 7) {
      return (input.substring(0, 7) == "config:")
    } 

    return false
  }

  fun configure(rawInput: String) {
    try {
      val input = rawInput.trim()
      when (input) {
        "config:input:advanced" -> inputHandler = AdvancedReader()
        "config:input:basic" -> inputHandler = BasicHandler()
        "config:output:beauty" -> outputHandler = BeautyPrinter()
        "config:output:basic" -> outputHandler = BasicHandler()
        else -> {
          throw Exception("unexpected configuration")
        }
      }
      formattedPrint("Info", "successfully configured")
    } catch(e: Exception) {
      formattedPrint("Error", e.message)
    }
  }

  private fun formattedPrint(type: String?, message: String?) {
    println("--- " + type + ": " + message + " ---")
  }

  fun executeInput(input: String) {
    try {
      inputHandler.processInput(calc, input)
      if (calc.resultBuffer != null) {
        outputHandler.print(calc.resultBuffer.toString())
      }
    } catch(e: Exception) {
      formattedPrint("Error", e.message)
    }
  }

  fun run() {
    println("Calculator is running!")
    println()

    var input: String? = null

    while (input != "Q") {
      if (input != null) {
        if (isConfigurationInput(input)) {
          configure(input)
        } else {
          executeInput(input)
        }
      }

      input = readLine()
    }
  }
}
