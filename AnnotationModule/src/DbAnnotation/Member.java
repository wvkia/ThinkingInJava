package DbAnnotation;

@DBTable(name = "MEMBER")
public class Member {
    @SqlString(value=30)String firstName;
    @SqlString(value = 30)String lastName;
    @SqlInteger Integer age;
    @SqlString(value = 30,constraints = @Constraints(primaryKey = true))String handle;
    static int memeberCount;

    @Override
    public String toString() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }

    public static int getMemeberCount() {
        return memeberCount;
    }
}
