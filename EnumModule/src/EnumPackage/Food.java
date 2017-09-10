package EnumPackage;

public interface Food {
    enum Appetizer implements Food{
        SALAD,SOUP;
    }
    enum MainCourse implements Food{
        BURRITO;
    }
    enum Dessert implements Food{
        FRUIT;
    }
    enum Coffee implements Food{
        TEA;
    }
}
