package com.board.service;

import com.board.mapper.BoardMapper;
import com.board.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;
    
    @Override
    public void create(BoardVO board) {
        mapper.create(board);
    }

    @Override
    public BoardVO read(Long id) {
        return mapper.read(id);
    }

    @Override
    public void update(BoardVO board) {
        mapper.update(board);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }

    @Override
    public List<BoardVO> getAll() {
        return mapper.getAll();
    }

    @Override
    public List<BoardVO> getAllWithPaging(int offset, int limit) {
        return mapper.getAllWithPaging(offset, limit);
    }

    @Override
    public List<BoardVO> searchPosts(String keyword, int offset, int limit) {
        return mapper.searchPosts(keyword, offset, limit);
    }
}
