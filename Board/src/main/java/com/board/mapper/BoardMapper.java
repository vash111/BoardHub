package com.board.mapper;

import com.board.model.BoardVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BoardMapper {
    void create(BoardVO board);
    BoardVO read(Long id);
    void update(BoardVO board);
    void delete(Long id);
    List<BoardVO> getAll();
    
    // 페이징 처리된 게시물 목록
    List<BoardVO> getAllWithPaging(@Param("offset") int offset, @Param("limit") int limit);

    // 검색 기능 추가
    List<BoardVO> searchPosts(@Param("keyword") String keyword, @Param("offset") int offset, @Param("limit") int limit);
}
