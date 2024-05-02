package com.boardInCss.board.controller;

import com.boardInCss.board.dto.BoardDTO;
import com.boardInCss.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("save")
    public String save(){
        return "save";
    }

    @PostMapping("/save")
    public String save(BoardDTO boardDto, Model model){
        boardService.save(boardDto);
        model.addAttribute("board", boardDto);
        System.out.println("boardDto = " + boardDto);
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model){
        List<BoardDTO> boardList = boardService.list();
        model.addAttribute("boardList",boardList);
        System.out.println("model = " + model);
        return "list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("board", boardDTO);
        System.out.println("model = " + model);
        return "detail";
    }

    @GetMapping("/update/{id}")
    public String boardUpdate(@PathVariable("id") Long id, Model model){
        BoardDTO boardDTO = boardService.detail(id);
        model.addAttribute("board", boardDTO);
        return "boardUpdate";
    }

    @PostMapping("/update/{id}")
    public String boardUpdate(BoardDTO boardDTO, Model model){
        boardService.boardUpdate(boardDTO);
        BoardDTO boardDto = boardService.detail(boardDTO.getId());
        model.addAttribute("board",boardDto);
        System.out.println("model = " + model);
        return "detail";
    }

    @GetMapping("/delete/{id}")
    public String boardDelete(@PathVariable("id") Long id){
        boardService.delete(id);
        return "redirect:/list";
    }

}
