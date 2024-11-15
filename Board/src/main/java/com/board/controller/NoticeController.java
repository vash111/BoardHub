package com.board.controller;

import com.board.model.BoardVO;
import com.board.model.NoticeVO;
import com.board.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	@Autowired
	private NoticeService service;

	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "0") int page, Model model) {
		int limit = 10;
		int offset = page * limit;
		List<NoticeVO> notices = service.getAllWithPaging(offset, limit);
		model.addAttribute("notices", notices);
		model.addAttribute("currentPage", page);
		return "notice/list";
	}
	
	@GetMapping("/search")
    public String search(@RequestParam("keyword") String keyword, @RequestParam(defaultValue = "0") int page, Model model) {
        int limit = 10;
        int offset = page * limit;
        List<NoticeVO> searchResults = service.searchPosts(keyword, offset, limit);
        model.addAttribute("boardList", searchResults);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "board/searchResults";
    }

	@GetMapping("/create")
	public String createForm() {
		return "notice/create";
	}

	@PostMapping("/create")
	public String create(NoticeVO notice) {
		service.create(notice);
		return "redirect:/notice/list";
	}

	@GetMapping("/read/{id}")
	public String read(@PathVariable Long id, Model model) {
		NoticeVO notice = service.read(id);
		model.addAttribute("notice", notice);
		return "notice/read";
	}

	// 수정 폼
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable Long id, Model model) {

		NoticeVO notice = service.read(id);
		model.addAttribute("notice", notice);
		return "notice/update";
	}

	@PostMapping("/update")
	public String update(NoticeVO notice) {
		service.update(notice);
		return "redirect:/notice/list";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.delete(id);
		return "redirect:/notice/list";
	}
}
