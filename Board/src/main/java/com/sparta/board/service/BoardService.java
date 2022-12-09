package com.sparta.board.service;


import com.sparta.board.dto.BoardRequestDto;
import com.sparta.board.dto.BoardResponseDto;
import com.sparta.board.entity.Board;
import com.sparta.board.rerpository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class BoardService {


    private final BoardRepository boardRepository;



    @Transactional
    public Board createBoard(BoardRequestDto requestDto) {
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return board;
    }

    @Transactional
    public List<Board> getBoards() {
        return boardRepository.findAllByOrderByModifiedAtDesc();
    }



    public BoardResponseDto selectBoard(Long id){
        Board findPost = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없음"));
        return new BoardResponseDto(findPost);
    }



    @Transactional
    public Long update(Long id, BoardRequestDto requestDto) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        board.update(requestDto);
        return board.getId();
    }

    @Transactional
    public Long deleteBoard(Long id) {
        boardRepository.deleteById(id);
        return id;
    }

    public List<Board> getBoard() {
        return null;
    }

   
}
