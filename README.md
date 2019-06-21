# About
This is calculator program. It is created to demonstrate software design which follows SOLID design principles.
- **Single Responsibility Principle**. Each class designed to do only single functionality of the program. Overall, each functionality in the program is handled by different entities: Runner, Handler, Calculator, and Operator.
- **Open-Closed Principle**. Part of the program which most likely need to be extended is calculation which is handled by Operator. Adding new calculation method only requires creating new class which extends the abstract Operator class and registering the new class inside switch-case flow in Operator class.
- **Liskov Substitution Principle**. Each subclass is properly inherited and no unused implementation. It is also related to the next principle. For example, each handler implement the right interface which they are supposed to implement.
- **Interface Segregation Princinple**. Interfaces are designed to be small with related functionality. Bigger interfaces only need to implement the smaller interfaces. Handler classess are the example for this.
- **Dependency Inversion Principle**. Instead of using fixed input/output handler, Runner depends on the abstraction of input/output handler. So, input/output handler can be dynamically changed at runtime.

# How to Use
You can give 3 types of input:
1. **Number**. Inputing number will set the current value or evaluating the number depending on what is the input before.
2. **Operator**. Known operators are addition (+), subtraction (-), multiplication (*), and division (/).
3. **Configuration**. You can configure different types of input handler and ouput handler. Look at section below.

# Configuration
You can give one of below input:
- `config:input:basic` to change the input handler to Basic Handler.
- `config:input:advanced` to change the input handler to Advanced Reader. It can ignore unnecessary words in the input and search for the valid one.
- `config:output:basic` to change the output handler to Basic Handler.
- `config:output:beauty` to change the ouptut handler to Beauty Printer. It just make a little difference of how the result will be printed.

# Development Setup
- Kotlin compiler version **1.3.31** to build the source code.
- JDK version **12.0.1** to run the jar.

# Build and Run
Script for building and running have already provided in this project.
- To build: `./build`
- To run: `./run`
