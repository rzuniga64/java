 Adapter pattern consequences
 * Client and Adaptee work together without any modification to either.
 * Adapter works with Adaptee and all of it's subclasses
 * A new Adapter needs to be written for each specialization (subclass) of
   Target.
 
 How is it different from the Bridge pattern?<br/>
 
 Similarities:
 * Both are used to hide the details of the underlying implementation.<br/>
 
 Difference:
 * The adapter pattern is geared towards makig unrelated components work
   together.
 * Applied to systems after they're designed (reengineering, interface
   engineering)
 * Inheritance followed by delegation.
 
 A bridge on the other hand is used up-front in a design to let abstractions
 and implementations vary independently.
 * New "beasts" can be added to the "object zoo", even if these are not known
   at analysis or system design time.
 * Delegation followed by inheritance.