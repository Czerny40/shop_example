package com.kitkat.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

//    롬북 안쓰면 이 코드 추가해줘야함
//    @Autowired
//    public ItemController(ItemRepository itemRepository, ItemService itemService) {
//        this.itemRepository = itemRepository;
//        this.itemService = itemService;
//    }

    @GetMapping("/list")
    String list(Model model){
        List<Item> result = itemRepository.findAll();
        model.addAttribute("items", result);

        return "list.html";
    }

    /*상품 추가 기능
     * 1. 상품 이름, 가격 작성을 입력할 수 있는 페이지와 폼
     * 2. 전송 버튼 누르면 서버로 전송(POST 요청)
     * 3. 서버에서 검사 후 이상없으면 DB에 저장*/

    @GetMapping("/writeItem")
    String writeItem(){
        return "writeItem.html";
    }

    @PostMapping("/addItem")    // 경로 확인 잘하기
    String addPost(@RequestParam Map<String, String> formData){   // @ModelAttribute 쓰면 더쉽게 가능

        itemService.saveItem(formData);
        return "redirect:/list";    //  list 페이지로 리다이렉트
    }

    @GetMapping("/detail/{id}") // URL 파라미터문법 (/{id}) 사용하면 비슷한 URL의 API 여러개 만들 필요없음
    String detail(@PathVariable Long id, Model model){

//     try {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            model.addAttribute("data", itemOptional.get());
            return "detail";
        } else {
            return "상품없음";
        }
//    } catch (Exception e) {
//        System.out.println(e.getMessage());
//        배포할때는 logging 라이브러리 찾아서 써보셈
//        return "에러남 ㅅㄱ";
    }


}



