import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void llegirJSON(){

        String jsonString ="";

        try {
            jsonString = Files.readString(Paths.get("./src/Recipes.json"));
        } catch (Exception e) {
            System.out.println("Err: no s'ha trobat l'arxiu");
        }
        //return jsonString;
        RecipesManager.fromJson(jsonString);
    }
    public static void  mostrarMenuPrincipal(){

        System.out.println("----------");
        System.out.println("1 - Consultar recepta");
        System.out.println("2 - Cerca per ingredient");
        System.out.println("3 - Sortir");
        System.out.println("----------");
        //System.out.println(jsonString);
    }

    public static int escollirOpcio(){
        boolean isValid = false;
        Scanner entradaEscaner = new Scanner (System.in);
        int option = 0;
        while (!isValid){
            mostrarMenuPrincipal();

            try{
                option = entradaEscaner.nextInt();
                isValid = true;
            } catch (InputMismatchException ex){
                System.out.println("Error: ingresa un numero, entre 1~3!");
                entradaEscaner.next();
            }
        }
        //entradaEscaner.close();
        return option;
    }

    public static void consultarRecepta() {
        boolean isValid = false;
        Scanner in = new Scanner (System.in);
        int id = 0;
        while (!isValid){
            System.out.println("Quina recepta vols consultar?");

            try{
                id = in.nextInt();
                isValid = true;
                try{
                    RecipesManager.mostrarReceta(id);
                } catch (Exception e) {
                    System.out.println("Ingresa un numero entre 1 ~ "+RecipesManager.recipesList.size());
                    isValid = false;
                }
            } catch (InputMismatchException ex){
                System.out.println("Error: ingresa un numero");
                in.next();
            }
        }
        //entradaEscaner.close();
    }

    public static void cercaxIngredient() {
        boolean isValid = false;
        Scanner input = new Scanner (System.in);
        String ing = "";
        while (!isValid){

            System.out.println("Quin ingredient vols cercar?");

            try{
                ing = input.nextLine();
                isValid = true;
            } catch (InputMismatchException ex){
                System.out.println("Error: ingresa un numero");
                input.next();
            }
        }
        RecipesManager.buscarIngredient(ing);
    }
}
