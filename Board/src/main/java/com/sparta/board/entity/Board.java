package com.sparta.board.entity;

import com.sparta.board.dto.BoardRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Board extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String text;
    private String password;

    public Board(BoardRequestDto requestDto) {
        this.name = requestDto.getName();
        this.text = requestDto.getText();
        this.password = requestDto.getPassword();
    }
    public void update(BoardRequestDto boardRequestDto) {
        this.name = boardRequestDto.getName();
        this.text = boardRequestDto.getText();
        this.password = boardRequestDto.getPassword();
    }

}
