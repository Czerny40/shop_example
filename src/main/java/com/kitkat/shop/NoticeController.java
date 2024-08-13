package com.kitkat.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {
    private final ItemRepository itemRepository;


    @GetMapping("/notice")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);

        return "notice.html";
    }


}
