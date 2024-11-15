package com.board.service;

import com.board.mapper.InquiryMapper;
import com.board.model.BoardVO;
import com.board.model.InquiryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private InquiryMapper mapper;

	@Override
	public void create(InquiryVO inquiry) {
		mapper.create(inquiry);
	}

	@Override
	public InquiryVO read(Long id) {
		return mapper.read(id);
	}

	@Override
	public List<InquiryVO> getAllWithPaging(int offset, int limit) {
		return mapper.getAllWithPaging(offset, limit);
	}

	@Override
	public void addComment(Long id, String comment) {
		mapper.addComment(id, comment);
	}

	@Override
	public void update(InquiryVO inquiry) {
		mapper.update(inquiry);
	}

	@Override
    public List<InquiryVO> searchPosts(String keyword, int offset, int limit) {
        return mapper.searchPosts(keyword, offset, limit);
    }
}
