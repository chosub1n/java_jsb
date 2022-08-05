package kr.green.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.spring.service.BoardService;
import kr.green.spring.vo.BoardVO;
import kr.green.spring.vo.MemberVO;

@Controller
//@RequestMapping(value="/board") 이게 있으면 리퀘스트맵핑에 value="/list"만 적어도 가능함.
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list", method=RequestMethod.GET)
	public ModelAndView boardListGet(ModelAndView mv){
		//등록된 게시글을 가져옴(여러 개)
		ArrayList<BoardVO> list = boardService.getBoardList();
		//System.out.println(list);
		mv.addObject("list", list);
	    mv.setViewName("/board/list");
	    return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.GET)
	public ModelAndView boardInsertGet(ModelAndView mv){
	    mv.setViewName("/board/insert");
	    return mv;
	}
	@RequestMapping(value="/board/insert", method=RequestMethod.POST)
	public ModelAndView boardInsertPost(ModelAndView mv, BoardVO board, HttpSession session){
		//화면에서 전송한 데이터가 잘 오는지 확인
		System.out.println(board);
		//로그인한 회원 정보를 확인
		MemberVO user = (MemberVO)session.getAttribute("user");
		//System.out.println(user);
		boardService.insertBoard(board,user);
	    mv.setViewName("redirect:/board/list");
	    return mv;
	}
	
	@RequestMapping(value="/board/select/{bd_num}", method=RequestMethod.GET)
	public ModelAndView boardselectGet(ModelAndView mv, @PathVariable("bd_num")Integer bd_num){
		//게시글 번호에 맞는 게시글 조회수를 증가
		boardService.updateViews(bd_num);
		//게시글 번호에 맞는 게시글 정보를 가져옴
		BoardVO board = boardService.getBoard(bd_num);
		//가져온 게시글을 화면에 전달
		mv.addObject("board", board);
	    mv.setViewName("/board/select");
	    return mv;
	}
}
