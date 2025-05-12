import org.json.JSONObject;

public class Expense {
    private String Name;
    private String Description;
    private int Amount;

    public Expense(String name, String description, int amount) {
        Name = name;
        Description = description;
        this.Amount = amount;
    }



    public JSONObject toJsonObject(){
        JSONObject jo = new JSONObject();
        jo.put("Name", Name);
        jo.put("Description", Description);
        jo.put("Amount", Amount);
        return jo;
    }

}
