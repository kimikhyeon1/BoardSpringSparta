package com.sparta.board.dto;

import com.sparta.board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {
    private String name;
    private String text;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public BoardResponseDto(Board findPost) {
        this.name =  findPost.getName();
        this.text = findPost.getText();
        this.createdAt = findPost.getCreatedAt();
        this.modifiedAt = findPost.getModifiedAt();
    }
}
