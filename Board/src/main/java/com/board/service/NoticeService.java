package com.board.service;

import com.board.model.BoardVO;
import com.board.model.NoticeVO;
import java.util.List;

public interface NoticeService {
	// 공지사항 생성
	void create(NoticeVO notice);

	// 공지사항 읽기
	NoticeVO read(Long id);

	// 공지사항 수정
	void update(NoticeVO notice);

	// 공지사항 삭제
	void delete(Long id);

	// 검색 기능 추가
	List<NoticeVO> searchPosts(String keyword, int offset, int limit);

	// 모든 공지사항 가져오기
	List<NoticeVO> getAll();

	// 페이지네이션을 위한 공지사항 가져오기
	List<NoticeVO> getAllWithPaging(int offset, int limit);
}
