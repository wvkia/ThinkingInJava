package AnnotationPackage;

public class Testable {
    public void execute(){
        System.out.println("Executin...");
    }
    @Test
    void testExecute(){
        execute();
    }
}
