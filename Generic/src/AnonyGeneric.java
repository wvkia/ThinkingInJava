import GenericInterface.Generator;

class Customer {
    private static long counter = 1;
    private final long id = counter++;
    private Customer() {

    }

    @Override
    public String toString() {
        return "Customer  " + id;
    }

    //匿名类实现泛型接口
    public static Generator<Customer> generator(){
        return new Generator<Customer>() {
            @Override
            public Customer next() {
                return new Customer();
            }
        };
    }
}
public class AnonyGeneric {

}
