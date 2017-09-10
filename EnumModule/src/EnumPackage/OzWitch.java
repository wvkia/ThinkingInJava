package EnumPackage;

public enum OzWitch {
    WEST("West"),
    NORTH("North"),
    EAST("East"),
    SOUTH("South");
    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch ozWitch : OzWitch.values()) {
            System.out.println(ozWitch+" : "+ozWitch.getDescription());
        }
    }
}
