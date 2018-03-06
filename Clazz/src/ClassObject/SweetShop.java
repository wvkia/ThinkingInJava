package ClassObject;

class Candy {
    static {
        System.out.println("loading candy");
    }
}

class Gum {
    static {
        System.out.println("loading gum");
    }
}

class Cookie {
    static {
        System.out.println("loading cookie");
    }
}

public class SweetShop {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Candy();
        System.out.println("After creating candy");
        try {
            //调用Class.forName,如果类未被加载，则加载
            Class.forName("ClassObject.Gum");
        } catch (ClassNotFoundException e) {
            System.out.println("Error======== : Could't find Gum");
        }
        System.out.println("After Class.forname Gum");
        new Cookie();
        System.out.println("After creating cookie");
    }
}
