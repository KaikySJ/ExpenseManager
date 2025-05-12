import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ExpenseManager expenseManager = new ExpenseManager();
        Scanner input = new Scanner(System.in);
        System.out.println("------------------------WELCOME TO YOUR EXPENSE MANAGER, PLEASE SELECT WHICH ACTION YOU WANT TO DO------------------------");
        int actionChoice;
        while (true){
        System.out.println("""
                1-VISUALIZE EXPENSES
                2-ADD EXPENSES
                3-TOTAL AMOUNT OF EXPENSES
                4-UPDATE EXPENSE
                5-REMOVE EXPENSE
                6-CLOSE APPLICATION
                """);


            actionChoice = input.nextInt();
            switch (actionChoice){
                case 1:
                    expenseManager.visualizeArray();
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.println("Insert the name:");
                    String name = input.next();
                    input.nextLine();
                    System.out.println("Insert the description:");
                    String description = input.nextLine();

                    System.out.println("Insert the amount:");
                    int amount = input.nextInt();
                    input.nextLine();
                    expenseManager.addObjectToExpensesArray(new Expense(name, description, amount));
                    break;

                case 3:
                    expenseManager.totalExpenseValues();
                    break;
                case 4:
                    System.out.println("Insert the ID");
                    int index = input.nextInt()-1;

                    System.out.println("""
                INSERT THE VARIABLE YOU'D LIKE TO CHANGE:
                1-NAME/DESCRIPTION
                2-AMOUNT
                """);
                    int action = input.nextInt();
                    switch (action){
                        case 1:
                            System.out.println("WHICH WOULD YOU LIKE TO CHANGE");
                            System.out.println("""
                1-NAME
                2-DESCRIPTION
                """);
                            int NameOrDesc = input.nextInt();
                            System.out.println("INSERT THE NEW VALUE:");
                            String newValue = input.next();
                            expenseManager.updateExpense(NameOrDesc, index,newValue);
                            break;
                        case 2:
                            System.out.println("INSERT THE NEW VALUE:");
                            int newAmount = input.nextInt();
                            expenseManager.updateExpense(index, newAmount);
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Insert the ID");
                    int removeIndex = input.nextInt()-1;
                    expenseManager.removeObject(removeIndex);
                case 6:
                    input.close();
                    System.out.println("CLOSING APPLICATION...");
                    return;

            }

        }


    }
}
