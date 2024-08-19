package com.kitkat.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService { // 비즈니스 로직 담는 클래스는 Service라고 부름

    private final ItemRepository itemRepository;

    public  void saveItem(@RequestParam Map<String, String> formData) {
        Item newItem = new Item();
        newItem.setTitle(formData.get("title"));
        newItem.setPrice(Integer.valueOf(formData.get("price")));
        itemRepository.save(newItem);
    }
}
