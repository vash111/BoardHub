package com.board.service;

import com.board.model.BoardVO;
import com.board.model.InquiryVO;
import java.util.List;

public interface InquiryService {
	void create(InquiryVO inquiry);

	InquiryVO read(Long id);

	List<InquiryVO> getAllWithPaging(int offset, int limit);

	void addComment(Long id, String comment);

	void update(InquiryVO inquiry);

	// 검색 기능 추가
	List<InquiryVO> searchPosts(String keyword, int offset, int limit);
}
