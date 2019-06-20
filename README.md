# About
This is calculator program. It is created to demonstrate software design which follows SOLID design principles.

# How to Use
You can input 3 types of input:
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
- Install kotlin compiler

# Build
> ./build

# Run
> ./run