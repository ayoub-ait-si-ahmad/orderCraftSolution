package com.orderCraftSpringApp.service.implementations;

import com.orderCraftSpringApp.model.classes.Item;
import com.orderCraftSpringApp.repository.ItemRepository;
import com.orderCraftSpringApp.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item findItemById(Long itemID) {
        Optional<Item> itemOptional = itemRepository.findById(itemID);
        if (itemOptional.isPresent()) {
            return itemOptional.get();
        }
        return null;
    }

    @Override
    public Item saveItem(Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

    @Override
    public Item updateItem(Long itemID, Item item) {
        Optional<Item> itemOptional = itemRepository.findById(itemID);
        if (itemOptional.isPresent()) {
            Item itemUpdated = itemOptional.get();
            itemUpdated.setItemName(item.getItemName());
            itemUpdated.setItemDescription(item.getItemDescription());
            itemUpdated.setItemPrice(item.getItemPrice());
            itemUpdated.setQuantity(item.getQuantity());
            // save the updated item
            itemRepository.save(itemUpdated);
            return itemUpdated;
        }
        else {
            throw new RuntimeException("Item not found!");
        }
    }

    @Override
    public boolean deleteItem(Long itemID) {
        Optional<Item> itemOptional = itemRepository.findById(itemID);
        if (itemOptional.isPresent()) {
            itemRepository.deleteById(itemID);
            return true;
        }
        return false;
    }

    @Override
    public List<Item> findAllItems() {
        List<Item> items = itemRepository.findAll();
        return items;
    }
}
