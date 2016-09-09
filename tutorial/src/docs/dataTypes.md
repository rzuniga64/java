Data Type:
- defines the proper use of an identifier or an expression
− what type of data can be stored in an identifier or written in an expression
− set of operations can be performed on an identifier or expression
 
operations: Which operation is not valid for float?
+ - * / % == != < > <= >= 
 
Scalar data types (atomic values)
Arithmetic types (whole numbers)
INTEGER 
- byte: -128 to 127
- short: -/+ 32768
- int: stores numbers in range of -/+2147483648 
- long: stores numbers in range of -/+9223372036854775808 
 
FLOATING POINT
Use double is the standard fp type in Java
- float: 127 digits after decimal point
- double: 1023 digits after decimal
- long double

STRINGS:  
- 0 or more characters surrounded by double quotes - "Hello"
- is a class, not a built-in type
- large collection of methods for manipulating strings
- Strings can be combined with +, the concatenation operator
- Empty String, "", is a legal String object
CHARACTER:  'a', alphabetic characters store as numeric value (ASCII)
BOOLEAN: 
- true/false, built-in data type
- comparisons: salary > 100
- repetition: while balance < 100

Composite types:
ARRAYS: ordered sequence of values of the same type
 
FIRST CLASS OBJECTS
first-class objects can be manipulated in the usual ways without special cases and exceptions
- copy (=, assignment)
- comparison (==, <, ...)
- input/output (<<, >>)
 
 first-class object: string class, vector class (standard library)
 size() member function
 ==, <, +
 
 SECOND CLASS OBJECTS
 second-class objects can be manipulated only in restricted ways, may have to define operations yourself
 - Usually primitive (built-in) data types
 
 second-class object: C-String (char array)
 - strcpy
 - strlen
 - strcat
 - strcmp
 
 PRIMATIVE ARRAY
 = does not copy elements
 - length undefined
 - ==, <, ... do not perform as expected
 