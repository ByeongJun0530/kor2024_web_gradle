package day65task.controller;

import day65task.model.dto.OrderDto;
import day65task.model.entity.OrderEntity;
import day65task.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {
    @Autowired private MemberService memberService;
    // 특정 제품 주문 등록
    @PostMapping("/order/regist")
    public boolean myOrderRegist(@RequestBody OrderDto orderDto){
        return memberService.myOrderRegist(orderDto);
    }

    // 특정 제품 주문 조회
    @GetMapping("/order/print")
    public List<OrderDto> myOrderPrint(@RequestParam int mno){
        return memberService.myOrderPrint(mno);
    }
}
