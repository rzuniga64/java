Name: Abstract Factory Design Pattern
Problem Description: Shield the client from different platforms that provide
different implementations for same set of concepts.

Solution: A platform is represented as a set of AbstractProducts, each
representing a concept (class) that is supported by all platforms.  An
AbstractFactory class declares the operations for creating each individual
product.

A specific platform is then realized by a Concrete Factory and a set of
ConcreteProducts (one for each Abstract Product). A ConcreteFactory depends
only on its related ConcreteProducts.

The Client depends only on the AbstractProducts and the AbstractFactory classes,
making it easy to substitute platforms.

Abstract Factory Pattern: consequences

* Define an interface for creating an object but delegate the crate of the
object to the factory method.
* Client is shielded from concrete product subclasses via the factory method.
* Substituting families at runtime is possible.
* Adding new families (platforms) is fairly easy.
* Add new products is somewhat difficult since new realizations for each factory
must be created. AbstractFactory must be changed.

However you can have default or generic instances of each product that can be
used for any platform.