package kr.co.hta.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.hta.movies.dao.AdminMovieDao;
import kr.co.hta.movies.dao.MovieDao;
import kr.co.hta.util.CommonUtils;
import kr.co.hta.vo.Criteria;
import kr.co.hta.vo.Movie;
import kr.co.hta.vo.Pagination;
import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class AdminMovieController {
	
	private AdminMovieDao adminMovieDao = new AdminMovieDao();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	MovieDao movieDao = new MovieDao();
	
	//상영종료 
	@RequestMapping("/admin/closemovie.jf")
	public ModelAndView updatemovielist(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		int mno = Integer.parseInt(req.getParameter("mno"));
		int pno = Integer.parseInt(req.getParameter("pno"));
		
		adminMovieDao.closeMovie(mno);
		mav.setViewName("redirect:movielist.jf?pno=" + pno);
		return mav;
	}
	//관리자페이지
	@RequestMapping("/admin/adminform.jf")
	public ModelAndView adminform(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("semi/admin/adminform.jsp");
		
		return mav;
	}
	
	//영화정보등록페이지
	@RequestMapping("/admin/movieform.jf")
	public ModelAndView movieform(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("semi/admin/movieform.jsp");

		return mav;
	}
	
	//영화등록하기
	@RequestMapping("/admin/insertMovie.jf")
	public ModelAndView insertMovie(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:movielist.jf?pno=1");

		String saveDirectory = "C:\\projects\\web_workspace\\jf\\WebContent\\photos\\movieposters";
		
		MultipartRequest mr = new MultipartRequest(req, saveDirectory, 1024*1024*50, "utf-8", new DefaultFileRenamePolicy());
		
		Movie movie = new Movie();
		
		String korTitle = mr.getParameter("korTitle");
		String engTitle = mr.getParameter("engTitle");
		String director = mr.getParameter("director");
		String actors = mr.getParameter("actors");
		String country = mr.getParameter("country");
		String releaseDate = mr.getParameter("releaseDate"); 
		int runningTime = Integer.parseInt(mr.getParameter("runningTime"));
		String genre = mr.getParameter("genre");

		String poster = mr.getFilesystemName("poster");
		String steelCut = mr.getParameter("steelCut");
		int  ageLimit = Integer.parseInt(mr.getParameter("ageLimit"));
		String info = mr.getParameter("info");
		
		movie.setKorTitle(korTitle);
		movie.setEngTitle(engTitle);
		movie.setDirector(director);
		movie.setActors(actors);
		movie.setCountry(country);
		movie.setReleaseDate(sdf.parse(releaseDate));
		movie.setRunningTime(runningTime);
		movie.setGenre(genre);
		movie.setPoster(poster);
		movie.setSteelCut(steelCut);
		movie.setAgeLimit(ageLimit);
		movie.setInfo(info);
	
		adminMovieDao.insertMovie(movie);
		return mav;
	}
	//영화수정하기
		@RequestMapping("/admin/updateMovie.jf")
		public ModelAndView updateMovieByNo(HttpServletRequest req, HttpServletResponse res) throws Exception {
			ModelAndView mav = new ModelAndView();
			
			String saveDirectory = "C:\\projects\\web_workspace\\jf\\WebContent\\photos\\movieposters";
			
			MultipartRequest mr = new MultipartRequest(req, saveDirectory, 1024*1024*50, "utf-8");
			int pno = Integer.parseInt(mr.getParameter("pno"));
			mav.setViewName("redirect:movielist.jf?pno=" + pno);
			
			int mno = Integer.parseInt(mr.getParameter("mno"));
			String korTitle = mr.getParameter("korTitle");
			String engTitle = mr.getParameter("engTitle");
			String director = mr.getParameter("director");
			String actors = mr.getParameter("actors");
			String country = mr.getParameter("country");
			String releaseDate = mr.getParameter("releaseDate"); 
			int runningTime = Integer.parseInt(mr.getParameter("runningTime"));
			String genre = mr.getParameter("genre");
			String steelCut = mr.getParameter("steelCut");
			int  ageLimit = Integer.parseInt(mr.getParameter("ageLimit"));
			String info = mr.getParameter("info");
		
			System.out.println(korTitle);
			System.out.println(engTitle);
			System.out.println(director);
			System.out.println(actors);
			System.out.println(country);
			System.out.println(releaseDate);
			System.out.println(runningTime);
			System.out.println(genre);
			System.out.println(steelCut);
			System.out.println(ageLimit);
			System.out.println(info);
			
			Movie movie = movieDao.getMovieByNo(mno);
			
			movie.setKorTitle(korTitle);
			movie.setEngTitle(engTitle);
			movie.setDirector(director);
			movie.setActors(actors);
			movie.setCountry(country);
			movie.setReleaseDate(sdf.parse(releaseDate));
			movie.setRunningTime(runningTime);
			movie.setGenre(genre);
			movie.setSteelCut(steelCut);
			movie.setAgeLimit(ageLimit);
			movie.setInfo(info);
			
			movieDao.updateMovieByNo(movie);
			return mav;
		}
	
	
	//영화정보수정페이지
	@RequestMapping("/admin/movieupdateform.jf")
	public ModelAndView movieupdateform(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		int mno = Integer.parseInt(req.getParameter("mno"));
		Movie movie = movieDao.getMovieByNo(mno);
		
		mav.setViewName("semi/admin/movieupdateform.jsp");
		mav.addAttribute("movie", movie);
		return mav;
	}
	//영화리스트페이지
	@RequestMapping("/admin/movielist.jf")
	public ModelAndView movielist(HttpServletRequest req, HttpServletResponse res) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("semi/admin/movielist.jsp");
		int size = CommonUtils.stringToNumber(req.getParameter("size"), 10);
	
		int pno = 1;
		try {
			pno = Integer.parseInt(req.getParameter("pno"));
		} catch (NumberFormatException e) {}
		
		String opt = req.getParameter("opt");
		String keyword = req.getParameter("keyword");
		
		Criteria c = new Criteria();
		
		if (keyword != null && !keyword.isEmpty()) {			
			c.setOption(opt);
			c.setKeyword(keyword);
			
		}
		c.setBegin((pno-1)*8+1);
		c.setEnd(pno*8);
		c.setBeginIndex((pno - 1)*size + 1);
		c.setEndIndex(pno*size);
		List<Movie> movies = adminMovieDao.adminMovieListByRange(c);
		
		int records = adminMovieDao.movieTotalCount(c);
		Pagination pagination = new Pagination(pno, size, records);
		
		mav.addAttribute("movies", movies);
		mav.addAttribute("pagination", pagination);
		mav.addAttribute("records", records);
		
		return mav;
	}
}
