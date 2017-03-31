Bridge Pattern consequences
* Client is shielded from abstract and concrete implementations.
* Abstractions and implementations can be refined independently.
  The implementation can be chosen (or changed) at runtime.
* Improved extensibility: you can extend Abstraction and Implementor hierarchies
  independently.
  
Where does teh Bridge Pattern use inheritance?
Where does it use delegetation?

Differences between Strategy and Bridge Pattern.
* Bridge is a structural pattern. Strategy is a behaviorial pattern.
* Bridge implmentations are subsystems. Strategy encapsulates algorithms.
* Bridge implementation often create at system initialization. Strategies 
  created on the fly. 
* Bridge abstraction sets up its own implementation via delegation. Strategy
  context is usually configured by another object (Policy).