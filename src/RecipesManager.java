import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;

public class RecipesManager {
    public static ArrayList<Recipe> recipesList = new ArrayList<>();
    public static ArrayList<Paso> listaPasos = new ArrayList<>();
    public static ArrayList<Ingredient> ingredients = new ArrayList<>();

    public static void fromJson(String jsonString){

        Gson gson = new Gson();
        int c = 0;

        JsonArray jsonArray = JsonParser.parseString(jsonString).getAsJsonArray();
        //System.out.println(jsonArray.size());

        for (int i = 0; i < jsonArray.size(); i++){

            String name = jsonArray.get(i).getAsJsonObject().get("name").getAsString();

            JsonArray ingArray = jsonArray.get(i).getAsJsonObject().get("ingredients").getAsJsonArray();
            Ingredient[] ingredients = gson.fromJson(ingArray, Ingredient[].class);

            RecipesManager.ingredients.addAll(Arrays.asList(ingredients));

            JsonArray stepsArray = jsonArray.get(i).getAsJsonObject().get("steps").getAsJsonArray();
            JsonArray timersArray = jsonArray.get(i).getAsJsonObject().get("timers").getAsJsonArray();

            int[] timers =  gson.fromJson(timersArray, int[].class);
            String[] steps = gson.fromJson(stepsArray, String[].class);

            Paso[] pas = new Paso[steps.length];

            for (int j = 0; j < steps.length; j++) {
                pas[j] = new Paso(steps[j]);
                pas[j].setTimer(timers[j]);

            }
            for (Paso a: pas) {
                //System.out.println(a.getStep());
            }
            for (String a: steps) {
                listaPasos.add(new Paso(a));
            }

            for (int a:timers) {
                listaPasos.get(c).setTimer(a);
                //System.out.println(listaPasos.get(c).getStep()+" timer: "+listaPasos.get(c).getTimer());
                c++;
            }

            recipesList.add(new Recipe(name, RecipesManager.ingredients, pas));

            listaPasos.clear();
            RecipesManager.ingredients.clear();
            c=0;
        }

    }

    public static void mostrarReceta(int id) {
        recipesList.get(id-1).mostrar();
    }

    public static void buscarIngredient(String buscar) {
        boolean match = false;
        int aux = 0;

        for (Recipe e: recipesList) {
            for (int i = 0; i < e.getListaIngredientes().size(); i++) {
                if (e.getListaIngredientes().get(i).getName().contains(buscar)){
                    if (aux == 0){System.out.println(e.getName());}
                    System.out.println("\t"+e.getListaIngredientes().get(i).getName()+": "+e.getListaIngredientes().get(i).getQuantity());
                    match = true;
                    aux++;
                }
            }
            aux=0;
        }

        if (!match){
            System.out.println("No recipes found");
        }

    }
}
