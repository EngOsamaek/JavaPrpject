package FoodMenu;
public class MenuView {
    private int id,cal;
    private double price;
    private String name,desc;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCal() {
        return cal;
    }

    public void setCal(int cal) {
        this.cal = cal;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
    MenuView(){
        this.id=0;
        this.cal=0;
        this.price=0;
        this.name=null;
        this.desc=null;
    }
    MenuView(int id,String name,String desc,double price,int cal){
        this.id=id;
        this.name=name;
        this.desc=desc;
        this.price=price;
        this.cal=cal;
    }
}
