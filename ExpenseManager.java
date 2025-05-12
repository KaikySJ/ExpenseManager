import org.json.JSONArray;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExpenseManager {
        private final String File = "C:\\Users\\kaiky\\IdeaProjects\\ExpenseProject\\src\\main\\java\\json\\ExpenseData.json";
        private JSONArray ExpenseArray;


    public ExpenseManager() throws IOException {
            LoadFromJsonFile();
    }

    public void LoadFromJsonFile() throws IOException {
        FileReader reader = new FileReader(File);
        Scanner scanner = new Scanner(reader);
        StringBuilder content = new StringBuilder();

        //Se ao ler o arquivo encontrar texto ele colocará esse texto dentro do SB content
        while (scanner.hasNext()){
            content.append(scanner.nextLine());
        }
        scanner.close();
        reader.close();
        ExpenseArray = new JSONArray(content.toString());
    }

        //METODO PARA INSERIR O OBJETO CRIADO NO ARQUIVO JSON
    public void WriteInJson() throws IOException {

        FileWriter fileWriter = new FileWriter(File, false);

        fileWriter.write(ExpenseArray.toString());
        fileWriter.flush();
        fileWriter.close();

    }


       //MÉTODOS PARA GERENCIAR


    public void addObjectToExpensesArray(Expense expense) throws IOException {
            ExpenseArray.put(expense.toJsonObject());
            WriteInJson();
            System.out.println("Expense added!");
        }


    public void visualizeArray(){
        for (int i = 0; i < ExpenseArray.length(); i++) {
            System.out.printf("Expense ID-%s: %s\n",i+1, ExpenseArray.getJSONObject(i));
        }
    }

    public void totalExpenseValues(){
        int Total = 0;
        for (int i = 0; i < ExpenseArray.length(); i++) {
            Total += ExpenseArray.getJSONObject(i).getInt("Amount");
        }
        System.out.printf("Your expenses total will be: %s$\n", Total);
    }

    public void updateExpense(int action, int expIndex, String newValue) throws IOException {
        if (action == 1){
        ExpenseArray.getJSONObject(expIndex).put("Name", newValue);
        WriteInJson();
        System.out.println("Expense name has been updated!");}
        else if (action == 2) {
            ExpenseArray.getJSONObject(expIndex).put("Description", newValue);
            WriteInJson();
            System.out.println("Expense description has been updated!");
        }
    }

    public void updateExpense(int expIndex, int newAmount) throws IOException{
        ExpenseArray.getJSONObject(expIndex).put("Amount", newAmount);
        WriteInJson();
        System.out.println("Expense amount has been updated!");
    }


    public void removeObject(int expIndex) throws IOException {
        ExpenseArray.remove(expIndex);
        WriteInJson();
        System.out.println("Expense removed!\n");


    }


}
