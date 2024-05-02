package com.boardInCss.board.repository;

import com.boardInCss.board.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final SqlSessionTemplate sql;

    public void save(BoardDTO boardDto) {
        sql.insert("Board.save",boardDto);
    }


    public List<BoardDTO> list() {
        return sql.selectList("Board.list");
    }

    public BoardDTO detail(Long id) {
        return sql.selectOne("Board.detail", id);
    }

    public void boardUpdate(BoardDTO boardDTO) {
        sql.update("Board.boardUpdate", boardDTO);
    }

    public void delete(Long id) {
        sql.delete("Board.delete", id);
    }
}
