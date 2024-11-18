package com.example.goal.entity;
import com.example.goal.dto.ItemRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item extends TimeStamp{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private int price;
    public Item(ItemRequestDto itemRequestDto) {
        this.username = itemRequestDto.getUsername();
        this.title = itemRequestDto.getTitle();
        this.content = itemRequestDto.getContent();
        this.price = itemRequestDto.getPrice();
    }
    public void update(ItemRequestDto itemRequestDto) {
        if(itemRequestDto.getUsername() != null) {
            this.username = itemRequestDto.getUsername();
        }
        if(itemRequestDto.getTitle() != null) {
            this.title = itemRequestDto.getTitle();
        }
        if(itemRequestDto.getContent() != null){
            this.content = itemRequestDto.getContent();
        }
        if(itemRequestDto.getPrice() != null){
            this.price = itemRequestDto.getPrice();
        }
    }
}