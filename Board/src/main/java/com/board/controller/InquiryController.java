package com.board.controller;

import com.board.model.InquiryVO;
import com.board.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/inquiry")
public class InquiryController {

	@Autowired
	private InquiryService service;

	// 1대1 문의 목록 페이지 (페이징 처리)
	@GetMapping("/list")
	public String list(@RequestParam(defaultValue = "0") int page, Model model) {
		int limit = 10; // 페이지당 게시물 수
		int offset = page * limit; // 페이지 당 시작 위치
		List<InquiryVO> inquiries = service.getAllWithPaging(offset, limit); // 페이징된 목록 조회
		model.addAttribute("inquiries", inquiries);
		model.addAttribute("currentPage", page);
		return "inquiry/list"; // 목록 페이지
	}

	// 1대1 문의 작성 폼 페이지
	@GetMapping("/create")
	public String createForm() {
		return "inquiry/create";
	}

	// 1대1 문의 작성 처리
	@PostMapping("/create")
	public String create(InquiryVO inquiry) {
		service.create(inquiry);
		return "redirect:/inquiry/list";
	}

	// 1대1 문의 수정 폼 페이지
	@GetMapping("/update/{id}")
	public String updateForm(@PathVariable Long id, Model model) {
		InquiryVO inquiry = service.read(id);
		model.addAttribute("inquiry", inquiry);
		return "inquiry/update";
	}

	// 1대1 문의 수정 처리
	@PostMapping("/update")
	public String update(InquiryVO inquiry) {
		service.update(inquiry);  
		return "redirect:/inquiry/read/" + inquiry.getId();
	}

	// 1대1 문의 상세보기 페이지
	@GetMapping("/read/{id}")
	public String read(@PathVariable Long id, Model model, Principal principal) {
		InquiryVO inquiry = service.read(id);
		model.addAttribute("inquiry", inquiry);

		// 관리자 여부 확인
		boolean isAdmin = principal != null && principal.getName().equals("admin");
		model.addAttribute("isAdmin", isAdmin);

		return "inquiry/read"; // 상세보기 페이지
	}

	// 댓글 작성 (관리자만 가능)
	@PreAuthorize("hasRole('ROLE_ADMIN')") // 관리자만 가능
	@PostMapping("/comment")
	public String addComment(@RequestParam Long id, @RequestParam String comment) {
		service.addComment(id, comment); // 댓글 저장
		return "redirect:/inquiry/read/" + id; // 댓글 작성 후 상세보기 페이지로 리디렉션
	}
}
