package com.boardInCss.board.service;

import com.boardInCss.board.dto.BoardDTO;
import com.boardInCss.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDTO boardDto) {
        boardRepository.save(boardDto);
    }


    public List<BoardDTO> list() {
        return boardRepository.list();
    }

    public BoardDTO detail(Long id) {
        return boardRepository.detail(id);
    }

    public void boardUpdate(BoardDTO boardDTO) {
        boardRepository.boardUpdate(boardDTO);
    }

    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
