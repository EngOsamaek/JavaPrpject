package mkyong;

public class InvoiceTable {
    private int Bill,ID,Total;

    public int getBill() {
        return Bill;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setBill(int bill) {
        Bill = bill;
    }
    InvoiceTable(){
        this.Bill=0;
        this.ID=0;
        this.Total=0;
    }
    InvoiceTable(int Bill,int ID,int Total){
        this.Bill=Bill;
        this.ID=ID;
        this.Total=Total;
    }
}
