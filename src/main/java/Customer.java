import java.util.ArrayList;

public class Customer {
    private String name;
    private int wallet;
    private ArrayList<Artwork> artCollection;

    public Customer(String name, int wallet){
        this.name = name;
        this.wallet=wallet;
        this.artCollection = new ArrayList<>();
    }

    //Methods

    public void addArtwork(Artwork artwork){
        artCollection.add(artwork);
    }

    public void removeMoney(Artwork artwork){
        wallet -= artwork.getPrice();
    }





    //Getters

    public String getName() {
        return name;
    }

    public int getWallet() {
        return wallet;
    }

    public ArrayList<Artwork> getArtCollection() {
        return artCollection;
    }

    //Setters


    public void setName(String name) {
        this.name = name;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void setArtCollection(ArrayList<Artwork> artCollection) {
        this.artCollection = artCollection;
    }
}
