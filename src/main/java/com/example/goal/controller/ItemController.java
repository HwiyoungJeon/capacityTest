package com.example.goal.controller;
import com.example.goal.dto.ItemRequestDto;
import com.example.goal.dto.ItemResponseDto;
import com.example.goal.exception.GlobalMessage;
import com.example.goal.exception.SuccessResponse;
import com.example.goal.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping("")
    public ResponseEntity<SuccessResponse<ItemResponseDto>>createItem(@RequestBody ItemRequestDto itemRequestDto){
        ItemResponseDto itemResponse = itemService.createItem(itemRequestDto);
        SuccessResponse<ItemResponseDto> response = new SuccessResponse<>(GlobalMessage.SUCCESS, HttpStatus.OK.value(), itemResponse);
        return ResponseEntity.ok(response);
    }
    @GetMapping("")
    public ResponseEntity<SuccessResponse<List<ItemResponseDto>>>getItems(){
        List<ItemResponseDto> itemResponse = itemService.getItems();
        SuccessResponse<List<ItemResponseDto>> response = new SuccessResponse<>(GlobalMessage.SUCCESS, HttpStatus.OK.value(), itemResponse);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<ItemResponseDto>> updateItem(@PathVariable Long id,
                                                                       @RequestBody ItemRequestDto itemRequestDto) {
        ItemResponseDto itemResponse = itemService.updateItem(id, itemRequestDto);
        SuccessResponse<ItemResponseDto> response = new SuccessResponse<>(GlobalMessage.SUCCESS, HttpStatus.OK.value(), itemResponse);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<ItemResponseDto>> deleteProduct(@PathVariable Long id) {
        ItemResponseDto itemResponse = itemService.deleteProduct(id);
        SuccessResponse<ItemResponseDto> response = new SuccessResponse<>(GlobalMessage.DELETED, HttpStatus.OK.value(), null);
        return ResponseEntity.ok(response);
    }
}