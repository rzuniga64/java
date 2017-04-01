Strategy Pattern: consequences
* Concrete strategies can be substituted transparently from the Context class.
* Client (or Policy) decides which strategy is best, give current circumstances
  without knowing any internal implementation of the strategy.
* New algorithms can be added without modifying Context or Strategy. Just minor
  changes to Client (Policy).
  
Strategy Pattern: Stock Tracking<br />

Name in Design Pattern  Actual Name (layout mgmt)

Context                 MyContext<br />
Strategy                Strategy<br />
ConcreteStrategy        FirstStrategy<br />
doWork()                Execute()<br />

Strategy Pattern: Sorting<br />

Name in Design Pattern  Actual Name (layout mgmt)

Context                 Collections<br />
Strategy                Comparator<br />
ConcreteStrategy        A class that implements Comparator<br />
doWork()                compare


