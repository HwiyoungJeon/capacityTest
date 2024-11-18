package com.example.goal.service;
import com.example.goal.dto.ItemRequestDto;
import com.example.goal.dto.ItemResponseDto;
import com.example.goal.entity.Item;
import com.example.goal.exception.GlobalMessage;
import com.example.goal.exception.ItemException;
import com.example.goal.repository.ItemRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final EntityManager entityManager;
    @Transactional(readOnly = true)
    public List<ItemResponseDto> getItems() {
        List<Item> itemsList = itemRepository.findAll();
        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
        for (Item item : itemsList) {
            itemResponseDtoList.add(new ItemResponseDto(item));
        }
        return itemResponseDtoList;
    }
    @Transactional(readOnly = false)
    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        Item item = itemRepository.save(new Item(itemRequestDto));
        return new ItemResponseDto(item);
    }
    @Transactional(readOnly = false)
    public ItemResponseDto updateItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = itemRepository.findById(id).orElseThrow(
                ()-> new ItemException(GlobalMessage.NOT_FOUND, HttpStatus.NOT_FOUND.value())
        );
        item.update(itemRequestDto);
        entityManager.flush();
        return new ItemResponseDto(item);
    }
    @Transactional(readOnly = false)
    public ItemResponseDto deleteProduct(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(
                ()-> new ItemException(GlobalMessage.NOT_FOUND, HttpStatus.NOT_FOUND.value())
        );
        itemRepository.delete(item);
        return new ItemResponseDto(item);
    }
}