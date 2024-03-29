package kr.co.hta.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import kr.co.hta.movies.dao.MemberDao;
import kr.co.hta.movies.dao.MoviediaryDAO;
import kr.co.hta.movies.dao.WatchedMovieDao;
import kr.co.hta.vo.Member;
import kr.co.hta.vo.Reservation;
import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class WatchedMovieController {
	
	MoviediaryDAO movieDiaryDAO = new MoviediaryDAO();
	MemberDao memberDAO = new MemberDao();
	WatchedMovieDao watchedDao = new WatchedMovieDao();
	
	
	@RequestMapping("/member/watchedMovie.jf")
	public ModelAndView watchedMovie(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("semi/member/watchedMovie.jsp");
		HttpSession session = req.getSession();
		Member member = (Member) session.getAttribute("LOGINMEMBER");
		if(member == null) {
			mav.setViewName("redirect:login.jf?result=default");
			return mav;
		}
		String memberId = member.getId();
		int diaryCount = movieDiaryDAO.selectDiaryCountById(memberId);
		int wishListsCount = memberDAO.getCountWishListById(memberId);
		int watchedCount = watchedDao.countAllWatched(memberId);
		
		mav.addAttribute("diaryCount", diaryCount);
		mav.addAttribute("wishListsCount", wishListsCount);
		mav.addAttribute("watchedCount", watchedCount);
		
		List<Reservation> AllWatched = watchedDao.getAllWatchedMovieById(memberId);
		mav.addAttribute("AllWatched", AllWatched);
		
		return mav;
	}
	
}
