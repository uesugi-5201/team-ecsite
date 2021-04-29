package jp.co.internous.eagle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.eagle.model.domain.MstUser;
import jp.co.internous.eagle.model.mapper.MstUserMapper;
import jp.co.internous.eagle.model.session.LoginSession;



//MVCモデルを使って受け取ったDBをｈｔｍｌファイルに返す
//@Controllerと@Autowiredを使用して、変数を取得してｈｔｍｌファイルに返す。
@Controller
@RequestMapping("/eagle/mypage")
public class MyPageController {
	
	//@Autowiredを使用して、自動で初期化される@Autowiredフィールドクラスを持ってくる
	@Autowired
	private MstUserMapper userMapper;
	
	//@Autowiredを使用して、自動で初期化される@Autowiredフィールドクラスを持ってくる
	@Autowired
	private LoginSession loginSession;
	
	//@RequestMapping("/"),modelを使用して、取得したloginSessionとuserMapperをmy_pageに返す。
	
	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		m.addAttribute("user", user);
		m.addAttribute("loginSession", loginSession);
		return "my_page";
	}

}
