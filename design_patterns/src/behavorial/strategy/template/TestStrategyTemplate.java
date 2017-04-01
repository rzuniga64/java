package behavorial.strategy.template;

/**
 * TestStrategyTemplate class.
 */
public class TestStrategyTemplate {

    public static void main(final String[] args) {

        MyContext context;

        context = new MyContext(new FirstStrategy());
        context.setStrategy();

        context = new MyContext(new SecondStrategy());
        context.setStrategy();;

        context = new MyContext((new ThirdStrategy()));
        context.setStrategy();
    }
}
