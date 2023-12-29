package com.orderCraftSpringApp.controller;

import com.orderCraftSpringApp.model.classes.Item;
import com.orderCraftSpringApp.service.interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public String viewItems(Model model) {
        List<Item> items = itemService.findAllItems();
        model.addAttribute("items", items);
        return "/items/items";
    }

    @GetMapping("/add")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "/items/item_form";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/update/{itemID}")
    public String showUpdateItemForm(@PathVariable Long itemID, Model model) {
        Item item = itemService.findItemById(itemID);
        model.addAttribute("item", item);
        return "/items/item_form";
    }

    @PostMapping("/update/{itemID}")
    public String updateItem(@ModelAttribute Item item, @PathVariable Long itemID) {
        itemService.updateItem(itemID, item);
        return "redirect:/items";
    }

    @PostMapping("/delete/{itemID}")
    public String deleteItem(@PathVariable Long itemID) {
        itemService.deleteItem(itemID);
        return "redirect:/items";
    }
}