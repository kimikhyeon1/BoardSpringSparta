package com.sparta.board.dto;

import com.sparta.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardRequestDto {
    private String name;
    private String text;
    private String password;


}
