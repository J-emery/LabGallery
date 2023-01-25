import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {
    Customer customer;
    Gallery gallery;
    Artist michael = new Artist("Michelangelo");
    Artwork david= new Artwork("David",michael,100,2);
    Artwork sistineChapel = new Artwork("Ceiling of the Sistine Chapel",michael,600000,3);

    @BeforeEach
    public void setUp(){
        customer = new Customer("Wilson",500000);
        gallery = new Gallery("Tate",500000);
    }

    @Test
    public void canAddArtwork(){
        assertThat(customer.getArtCollection().size()).isEqualTo(0);
        customer.addArtwork(david);
        assertThat(customer.getArtCollection().size()).isEqualTo(1);
    }

    @Test
    public void canRemoveMoney(){
        customer.removeMoney(david);
        assertThat(customer.getWallet()).isEqualTo(499900);
    }

    @Test
    public void canTakeStock(){
        gallery.addArtwork(david);
        gallery.addArtwork(sistineChapel);
        assertThat(gallery.takeStock()).isEqualTo(600100);
    }

    @Test
    public void canRemoveArtwork(){
        gallery.addArtwork(david);
        gallery.addArtwork(sistineChapel);
        assertThat(gallery.getStockList().size()).isEqualTo(2);
        gallery.removeArtwork(david);
        assertThat(gallery.getStockList().size()).isEqualTo(1);
    }

    @Test
    public void canSell(){
        gallery.addArtwork(david);
        gallery.sale(david,customer);
        assertThat(gallery.getTill()).isEqualTo(500100);
        assertThat(customer.getWallet()).isEqualTo(499900);
        assertThat(gallery.getStockList().size()).isEqualTo(0);
        assertThat(customer.getArtCollection().size()).isEqualTo(1);
    }

}
