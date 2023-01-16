public class Ingredient {

    private String quantity;
    private String name;
    private String type;


    public Ingredient(String quantity, String name, String type) {
        this.quantity = quantity;
        this.name = name;
        this.type = type;
    }

    public void mostrar(){
        System.out.println(getName()+" "+getQuantity()+" "+getType());
    }

    //GETERS I SETTERS
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
