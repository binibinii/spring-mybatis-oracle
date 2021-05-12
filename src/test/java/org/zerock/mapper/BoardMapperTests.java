package org.zerock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//Java COnfig
//@ContextConfiguration(classes ={org.zerock.config.RootConfig.class})
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;

//	@Test
//	public void testGetList() {
//		log.info("size: ~~~~~~~"+mapper.getList().size());
//		mapper.getList().forEach(board -> log.info(board));
//	}


//	@Test
//	public void testInsert() {
//		for(int i=0;i<20;i++) {
//			BoardVO board = new BoardVO();
//			board.setTitle("새로 작성한는 글"+i);
//			board.setContent("새로 작성하는 내용"+i);
//			board.setWriter("newbie"+i);
//
//			mapper.insert(board);	
//		}
////
////
////		log.info(board);
//	}

	/*
	@Test
	public void testInsertSelectKey() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는글 select key");
		board.setContent("새로 작성하는 내용 select key");
		board.setWriter("newbie");

		mapper.insertSelectKey(board);

		log.info(board);


	}

	@Test
	public void testRead() {
		//존재하는 게시물 번호로 테스트
		BoardVO board = mapper.read((long) 46);

		log.info(board);
	}

	@Test
	public void testDelete() {

		log.info("DELETE COUNT: "+mapper.delete((long) 52));
	}

	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		//실행전 존재하는 번호인지 확인할 것
		board.setBno((long) 59);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user000");

		int count = mapper.update(board);
		log.info("UPDATE COUNT: "+count);

	}
	 */

	@Test
	public void testPaging() {
		Criteria cri = new Criteria();
		//10개씩 3페이지
		cri.setPageNum(10);
		cri.setAmount(20);

		List<BoardVO> list = mapper.getListWithPaging(cri);
		log.info("zzzzzzzzzzzzzzzzzzzzzzzzz"+list.size());
		list.forEach(board -> log.info(board.getBno()));
	}
	
	@Test
	public void testSearch() {
		Criteria cri = new Criteria();
		cri.setKeyword("새로");
		cri.setType("TC");
		
		List<BoardVO> list = mapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	}
}
