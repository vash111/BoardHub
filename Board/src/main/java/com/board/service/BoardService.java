package com.board.service;

import com.board.model.BoardVO;
import java.util.List;

public interface BoardService {
    void create(BoardVO board);
    BoardVO read(Long id);
    void update(BoardVO board);
    void delete(Long id);
    List<BoardVO> getAll();
    
    // 페이징 처리된 게시물 목록
    List<BoardVO> getAllWithPaging(int offset, int limit);
}
