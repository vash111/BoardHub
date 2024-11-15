package com.board.service;

import com.board.mapper.NoticeMapper;
import com.board.model.BoardVO;
import com.board.model.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper mapper;
    
    @Override
    public void create(NoticeVO notice) {
        mapper.create(notice);
    }

    @Override
    public NoticeVO read(Long id) {
        return mapper.read(id);
    }

    @Override
    public void update(NoticeVO notice) {
        mapper.update(notice);
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }

    @Override
    public List<NoticeVO> getAll() {
        return mapper.getAll();
    }

    @Override
    public List<NoticeVO> getAllWithPaging(int offset, int limit) {
        return mapper.getAllWithPaging(offset, limit);
    }
    
    @Override
    public List<NoticeVO> searchPosts(String keyword, int offset, int limit) {
        return mapper.searchPosts(keyword, offset, limit);
    }
}
