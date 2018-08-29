 ####Scalar data types (atomic values)
 
 operations: Which operation is not valid for float?
 '+ - * / % == != < > <= >=' 
 
##### Arithmetic types: Integer
- byte: -128 to 127
- short: -/+ 32768
- int: stores numbers in range of -/+2147483648 
- long: stores numbers in range of -/+9223372036854775808 
 
 #####Floating points
- float: 127 digits after decimal point
- double: 1023 digits after decimal
- long double
 
 #####Strings
 - 0 or more characters surrounded by double quotes - "Hello"
 - is a class, not a built-in type
 - large collection of methods for manipulating strings
 - Strings can be combined with +, the concatenation operator
 - Empty String, "", is a legal String object
 
 #####Character
 - 'a', alphabetic characters store as numeric value (ASCII)

 #####Boolean
 - true/false, built-in data type
 - comparisons: salary > 100
 - repetition: while balance < 100
 
 #####Composite types:
 - Arrays: ordered sequence of values of the same Strings
 
 #####First class objects
 first-class objects can be manipulated in the usual ways without special cases and exceptions.
 -  copy (=, assignment)
 -  comparison (==, <, ...)
 -  input/output (<<, >>)
 -  string class, vector class (standard library), size() member function
 -  ==, <, +
 
 #####Second class objects
 second-class objects can be manipulated only in restricted ways, may have to define operations yourself
 - Usually primitive (built-in) data types
 
 second-class object: C-String (char array)
 - strcpy
 - strlen
 - strcat
 - strcmp
 
 primitive array
 - does not copy elements
 - length undefined
 - ==, <, ... do not perform as expected

 Order of operations:
 - parenthesis
 - exponentiation
 - multiplication, division
 - addition, subtraction