package com.board.controller;

import com.board.model.BoardVO;
import com.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/list")
    public String list(@RequestParam(defaultValue = "0") int page, Model model) {
        int limit = 10;  
        int offset = page * limit;
        List<BoardVO> boards = service.getAllWithPaging(offset, limit);
        model.addAttribute("boards", boards);
        model.addAttribute("currentPage", page);
        return "board/list";
    }

	@GetMapping("/create")
	public String createForm() {
		return "board/create";
	}

	@PostMapping("/create")
	public String create(BoardVO board) {
		// 제목 유효성 검사
		if (board.getTitle() == null || board.getTitle().trim().isEmpty()) {
			board.setTitle("제목 없음"); 
		}
		service.create(board);
		return "redirect:/board/list";
	}

	@GetMapping("/read/{id}")
	public String read(@PathVariable Long id, Model model) {
		BoardVO board = service.read(id);
		model.addAttribute("board", board);
		return "board/read";
	}

	// 수정 화면을 위한 메서드
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		BoardVO board = service.read(id);
		model.addAttribute("board", board);
		return "board/edit";
	}

	@PostMapping("/update")
	public String update(BoardVO board) {
		// 제목 유효성 검사
		if (board.getTitle() == null || board.getTitle().trim().isEmpty()) {
			board.setTitle("제목 없음");
		}
		if (board.getContent() == null || board.getContent().trim().isEmpty()) {
			board.setContent("내용 없음");
		}
		service.update(board);
		return "redirect:/board/list";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/board/list";
	}
}
