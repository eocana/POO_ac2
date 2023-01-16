import java.util.ArrayList;

public class Recipe {

    private String name;
    //private Ingredient[] ingredients;
    public ArrayList<Paso> pasos = new ArrayList<Paso>();

    private Paso[] pas;

    public ArrayList<Ingredient> listaIngredientes = new ArrayList<>();

    private final boolean celiacos;

    private final String[] intolerancias = {"bread","flour", "oats","rye barley","triticale","spelled","pasta","beer"};

    public Recipe(String name, ArrayList<Ingredient> listaIngredientes, Paso[] pas) {
        this.name = name;
        this.listaIngredientes = (ArrayList<Ingredient>) listaIngredientes.clone();
        this.pas = pas;
        this.celiacos= !tieneGluten();

    }

    private boolean tieneGluten() {
        boolean gluten = false;
        for (Ingredient a : listaIngredientes) {
            for (int i = 0; i < intolerancias.length; i++) {
                if (a.getName().contains(intolerancias[i])){
                    gluten = true;
                    break;
                }
            }
        }
        return gluten;
    }

    private void mostrarIngredientes(){
        for (Ingredient e : listaIngredientes) {
            System.out.print(e.getName());
        }
    }
    public void mostrar(){
        System.out.println(getName());
        System.out.println("Ingredients: " + listaIngredientes.size());
        System.out.println("Pasos: " + this.pas.length);
        System.out.println("Temps d'espera: " + sumarTemps());
        System.out.println("Apte per a celíacs? "+celiacos);
    }

    public int sumarTemps() {
        int a = 0;
        for (Paso paso : pas) {
            a += paso.getTimer();
        }
        return a;
    }

    //GETTER I SETTERS
    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getListaIngredientes() {
        return listaIngredientes;
    }
}
