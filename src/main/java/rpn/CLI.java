package rpn;

public class CLI {
    public static void main(String[] args) {
        InMemoryBus bus = new InMemoryBus();

        bus.subscribe("expression", new TokenizerConsumer(bus));
        bus.subscribe("+", new TokenizerConsumer(bus));
        bus.subscribe("-", new TokenizerConsumer(bus));
        bus.subscribe("*", new TokenizerConsumer(bus));
        bus.subscribe("/", new TokenizerConsumer(bus));

        bus.publish(new ExpressionMessage(args[0]));
    }
}