package com.orderCraftSpringApp.service.interfaces;

import com.orderCraftSpringApp.model.classes.Item;

import java.util.List;

public interface ItemService {
    // the methods that i will need to implement in the service implementation
    // TODO : DON'T FORGET TO DELETE THE METHODS THAT YOU DON'T NEED
    Item findItemById(Long itemID);
    Item saveItem(Item item);
    Item updateItem(Long itemID, Item item);
    boolean deleteItem(Long itemID);
    List<Item> findAllItems();
}
