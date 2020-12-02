public class ContactApp extends App{

    public static void main() {
        boolean loop = true;
        TaskList listTasks = new TaskList();
        while (loop) {
            printOptionsMainMenu();
            switch (getInput()) {
                case 1:
                    listTasks = new TaskList();
                    listOperationMenu(listTasks);
                    break;
                case 2:
                    if (performLoad(listTasks))
                        listOperationMenu(listTasks);
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input, please try again");
            }
        }
    }

}
