package EnumPackage;

import sun.awt.FontDescriptor;

public enum  Course {
    APPETIZER(Food.Appetizer.class),
    DESSERT(Food.MainCourse.class);
    private Food[] values;
    private Course(Class<? extends Food> kind){
        values = kind.getEnumConstants();
    }
    public Food randomSelection(){
        return Enums.random(values);
    }
}
