package EnumMethod;


import EnumPackage.Enums;

public enum  Meal2 {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class);
    private Food[] values;

    private Meal2(Class<? extends Food> kind) {
        this.values = kind.getEnumConstants();
    }

    //食物接口
    public interface Food{
        //枚举值实现接口
        enum Appetizer implements Food {
            SALAD,SOUP;
        }
        enum MainCourse implements Food {
            BURRITO;
        }
        enum Dessert implements Food {
            FRUIT;
        }

    }
    public Food randomSelect(){
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            for (Meal2 meal2 : Meal2.values()) {
                //将enum向上转型为Food接口类型
                Food food = meal2.randomSelect();
                System.out.println(food);
            }
            System.out.println("-------------------------------------");
        }
    }
}
