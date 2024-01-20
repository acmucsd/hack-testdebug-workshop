package Solution;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        cart = new ShoppingCart();
        product1 = new Product("Item1", 10.0);
        product2 = new Product("Item2", 15.0);
    }

    @Test
    public void testAddItemToCart() {
        cart.addItem(product1);
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testRemoveItemFromCart() {
        cart.addItem(product1);
        cart.removeItem(product1);
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void testCalculateTotal() {
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(25.0, cart.calculateTotal(), 0.01);
    }

    @Test
    public void testEmptyCartTotalIsZero() {
        assertEquals(0.0, cart.calculateTotal(), 0.01);
    }

    @Test
    public void testAddMultipleItems() {
        cart.addItem(product1);
        cart.addItem(product2);
        assertEquals(2, cart.getItemCount());
    }

    @Test
    public void testRemoveNonexistentItem() {
        cart.addItem(product1);
        cart.removeItem(product2); // Trying to remove a product not in the cart
        assertEquals(1, cart.getItemCount());
    }

    @Test
    public void testClearCart() {
        cart.addItem(product1);
        cart.addItem(product2);
        cart.clearCart();
        assertTrue(cart.isEmpty());
    }
}
