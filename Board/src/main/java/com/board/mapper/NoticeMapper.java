package com.board.mapper;

import com.board.model.NoticeVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NoticeMapper {

	// 공지사항 등록
	void create(NoticeVO notice);

	// 공지사항 조회
	NoticeVO read(Long id);

	// 공지사항 수정
	void update(NoticeVO notice);

	// 공지사항 삭제
	void delete(Long id);

	// 모든 공지사항 가져오기
	List<NoticeVO> getAll();

	// 공지사항 목록 (페이징 처리)
	List<NoticeVO> getAllWithPaging(@Param("offset") int offset, @Param("limit") int limit);
	
	// 검색 기능 추가
    List<NoticeVO> searchPosts(@Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);
}
