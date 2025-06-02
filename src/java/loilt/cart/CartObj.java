package loilt.cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import loilt.mobile.MobileDTO;

public class CartObj implements Serializable {

    private Map<String, CartItem> items;

    public Map<String, CartItem> getItems() {
        return items;
    }

    public void addToCart(MobileDTO mobile) {
        if (mobile == null) {
            return;
        }

        if (items == null) {
            this.items = new HashMap<>();
        }

        int quantity = 1;
        CartItem item = null;
        if (items.containsKey(mobile.getMobileId())) {
            item = items.get(mobile.getMobileId());
            item.setQuantity(item.getQuantity() + 1);
            items.put(mobile.getMobileId(), item);
            return;
        }
        item = new CartItem(mobile, quantity);
        items.put(mobile.getMobileId(), item);
    }

    public void removeToCart(String id) {
        if (id == null || id.trim().isEmpty()) {
            return;
        }
        items.remove(id);
        if (items.isEmpty()) {
            this.items = null;
        }
    }

    public float getTotalPrice() {
        if (items == null) {
            return 0;
        }
        float total = 0;
        for (CartItem item : items.values()) {
            total += item.getMobile().getQuantity() * item.getMobile().getPrice();
        }
        return total;
    }
}
