public class Main {
    public static void main(String[] args) {
        int option = 0;

        Menu.llegirJSON();

    do {
        option =  Menu.escollirOpcio();
        switch (option) {
            case 1 -> Menu.consultarRecepta();
            case 2 -> Menu.cercaxIngredient();
            case 3 -> System.exit(1);
        }
    }while (true);
    }
}