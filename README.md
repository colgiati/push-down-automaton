# push-down-automaton
Exercise 5b, task 2, THIN ZHAW, Group 77, olgiacar & schmilu6

---

The class **RPNChecker** is built like a Keller automaton. It checks if a sequence of D (digit) and O (operation) is a valid reverse polnish annotation expression.

The class **RPNCalculator** heirs from RPN checker and calculates the result for a given RPN expression. This class also contains a main method with examples for valid and invalid sequences of both 'D' and 'O', and digits and operators (screenshots below).

The class **IntegerStack** is a 'cheap' implementation of a stack using an int array. RPNCalculator and RPNChecker take advantage of the fact, that chars can be stored in int arrays (their unicode value).

In the class **RPNTest** you can find the tests a to c that are requested in the excercise. 

---

![Main method](/images/main_method_screenshot.PNG)

![Main method results](/images/main_method_output_screenshot.PNG)
