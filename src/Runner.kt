import handler.*
import calculator.Calculator

class Runner(private var inputHandler: InputHandler, private var outputHandler: OutputHandler) {
  constructor(handler : IOHandler) : this(handler, handler)

  private val calc: Calculator = Calculator()

  fun run() {
    println("Hello, calculator is ready! ^_^")
    println()

    startReceivingInput()

    println("Bye! ^_^")
  }

  private fun startReceivingInput() {
    var input: String? = null

    while (input != "Q") {
      if (input != null) {
        if (isConfiguration(input)) {
          configure(input)
        } else {
          execute(input)
        }
      }

      input = readLine()
    }
  }

  private fun isConfiguration(rawInput: String) : Boolean {
    val input = rawInput.trim()
    
    if (input.length > 7) {
      return (input.substring(0, 7) == "config:")
    } 

    return false
  }

  private fun configure(rawInput: String) {
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

  private fun execute(input: String) {
    try {
      inputHandler.processInput(calc, input)
      if (calc.resultBuffer != null) {
        outputHandler.print(calc.resultBuffer.toString())
      }
    } catch(e: Exception) {
      formattedPrint("Error", e.message)
    }
  }

  private fun formattedPrint(type: String?, message: String?) {
    println("--- " + type + ": " + message + " ---")
  }
}
