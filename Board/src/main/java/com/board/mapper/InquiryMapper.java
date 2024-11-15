package com.board.mapper;

import com.board.model.InquiryVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiryMapper {
	// 문의 등록
	void create(InquiryVO inquiry);

	// 문의 조회
	InquiryVO read(Long id);

	// 문의 목록 (페이징 처리)
	List<InquiryVO> getAllWithPaging(@Param("offset") int offset, @Param("limit") int limit);

	// 댓글 작성 (관리자만 가능)
	void addComment(@Param("id") Long id, @Param("comment") String comment);

	// 문의 수정
	void update(InquiryVO inquiry);
	
	// 검색 기능 추가
    List<InquiryVO> searchPosts(@Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);

}
