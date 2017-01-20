 ####Scalar data types (atomic values)
 
##### Arithmetic types: Integer
 * short
 * int
 * long
 
 #####Floating points
 * float
 * double
 * long double
 
 #####Composite types:
 * Arrays: ordered sequence of values of the same Strings
 
 #####First class objects
 first-class objects can be manipulated in the usual ways without special cases 
 and exceptions.
 *  copy (=, assignment)
 *  comparison (==, <, ...)
 *  input/output (<<, >>)
 *  string class, vector class (standard library), size() member function
 *  ==, <, +
 
 #####Second class objects
 second-class objects can be manipulated only in restricted ways, may have 
 to define operations yourself
 * Usually primitive (built-in) data types
 
 second-class object: C-String (char array)
 * strcpy
 * strlen
 * strcat
 * strcmp
 
 primitive array
 * does not copy elements
 * length undefined
 * ==, <, ... do not perform as expected

 Order of operations:
 * parenthesis
 * exponentiation
 * multiplication, division
 * addition, subtraction