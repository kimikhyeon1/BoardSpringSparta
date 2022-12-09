package com.sparta.board.controller;

import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.entity.Board;
import com.sparta.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }


    @GetMapping("/api/posts") //조회하기
    public List<Board> getBoards(){
        return boardService.getBoards();
    }


    @GetMapping("/api/posts/{id}") // 특정 글 조회하기
    public BoardResponseDto selectBoards(@PathVariable("id") Long id){return boardService.selectBoard(id);}


    @PostMapping("/api/posts") //생성하기
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {
        return boardService.createBoard(requestDto);
    }

    @PutMapping("/api/posts/{id}") //변경하기
    public Long updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/posts/{id}")
    public Long deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}


