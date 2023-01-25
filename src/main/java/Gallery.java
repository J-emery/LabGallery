import java.util.ArrayList;

public class Gallery {
    private String name;
    private int till;
    private ArrayList<Artwork> stockList;

    public Gallery(String name, int till){
        this.name=name;
        this.till=till;
        this.stockList = new ArrayList<>();
    }

    //Methods

    public int takeStock(){
        int sum = 0;
        for(Artwork art : stockList){
            sum += art.getPrice();
        }
        return sum;
    }

    public void addArtwork(Artwork artwork){
        stockList.add(artwork);
    }
    
    public void removeArtwork(Artwork artwork){
        stockList.remove(artwork);
    }

    public void sale(Artwork artwork,Customer customer){
        //deal with painting
        this.stockList.remove(artwork);
        customer.addArtwork(artwork);
        //deal with money
        customer.removeMoney(artwork);
        this.till += artwork.getPrice();
    }

    /**
     * Sale
     * 
     * remove item from gallery's stock  (gallery.removeArtwork())
     * add item to customer's collection (customer.addArtwork())
     *
     * add money to gallery's till          (gallery.setTill(gallery.getTill + artwork.getPrice())
     * remove money from customer's wallet  (customer.removeMoney())
     */

    //Getters

    public String getName() {
        return name;
    }
    public int getTill() {
        return till;
    }
    public ArrayList<Artwork> getStockList() {
        return stockList;
    }

    //Setters

    public void setName(String name) {
        this.name = name;
    }
    public void setTill(int till) {
        this.till = till;
    }
    public void setStockList(ArrayList<Artwork> stockList) {
        this.stockList = stockList;
    }
}
