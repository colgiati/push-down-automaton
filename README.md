# push-down-automaton
Exercise 5b, task 2, THIN ZHAW

The class RPNChecker is built like a Keller automaton. It checks if a sequence of D (digit) and O (operation) is a valid reverse polnish annotation expression.

The class RPN calculator heirs from RPN checker and calculates the result for a given RPN expression.

The class IntegerStack is a 'cheap' implementation of a stack using an int array. RPNCalculator and RPNChecker take advantage of the fact, that chars can be stored in int array (their unicode value).

In the class RPNTest you can find the tests a to c that are requested in the excercise. 
