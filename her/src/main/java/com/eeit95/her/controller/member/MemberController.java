package com.eeit95.her.controller.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.MsgBean;
import com.eeit95.her.model.service.MemberService;

@Controller
@RequestMapping("/member")
@SessionAttributes(names = { "user_id", "user" })
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean MemberLogin(@RequestBody MemberBean memberBean , HttpSession s) {
		MsgBean msg = new MsgBean();

		if (memberBean.getEmail().trim().length() == 0 || memberBean.getEmail() == null) {
			msg.setMessage("格式錯誤，email不可為空值");
			msg.setSuccess("false");
			return msg;
		}else if  (memberBean.getPassword().trim().length() == 0 || memberBean.getPassword() == null){
			msg.setMessage("格式錯誤，password不可為空值");
			msg.setSuccess("false");				
			return msg;
		
		}else {
			MemberBean mb = memberService.login(memberBean.getEmail(), memberBean.getPassword());
			if (mb != null) {
				s.setAttribute("user", mb);
				msg.setMessage("登入成功");
				msg.setSuccess("true");
				return msg;
			}else{
				msg.setMessage("登入失敗，帳號密碼不符");
				msg.setSuccess("false");
				return msg;
			}
		}
	}
	
	@RequestMapping(value="/getPassword",method=RequestMethod.POST,consumes = "application/json", produces = "application/json" )
	public @ResponseBody MsgBean password(@RequestBody MemberBean memberBean){
		MsgBean msg = new MsgBean();

		memberService.getPassword(memberBean.getEmail());
		msg.setMessage("已寄出");
		msg.setSuccess("true");

		return msg;
	}	
	
	@RequestMapping(value = "/member", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MsgBean MemberQuery(@RequestParam(value="id",required=false) String memberId) {
		System.out.println("id = "+memberId);
		MsgBean msg = new MsgBean();

		if(memberId.trim().length()==0 || memberId.trim().trim() == null){
			System.out.println("member SELECT 1");
			msg.setMessage("格式錯誤，沒有給memberId");
			msg.setSuccess("false");
			return msg;
		}else{
			System.out.println("member SELECT 2");
			MemberBean mb = memberService.findByMemberId(memberId);
			System.out.println("mb ="+mb);
			if(mb!=null){
				List<Object> list = new ArrayList<Object>();
				list.add(mb);
				msg.setMessage("查詢成功");
				msg.setSuccess("true");
				msg.setData(list);
				return msg;
			}else{
				System.out.println("member SELECT 3");
				msg.setMessage("查詢失敗，無該memberId");
				msg.setSuccess("false");
				return msg;
			}
		}
	}
	
	
	

	@RequestMapping(value = "/member", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean MemberInsert(@RequestBody MemberBean memberBean) {
		MsgBean msg = new MsgBean();

		if (memberBean.getEmail().trim().length() == 0 || memberBean.getEmail() == null) {
			msg.setMessage("格式錯誤，Email不可為空值");
			msg.setSuccess("false");
			return msg;
		}else if (memberBean.getPassword().trim().length() == 0 || memberBean.getPassword() == null){
			msg.setMessage("格式錯誤，Password不可為空值");
			msg.setSuccess("false");
			return msg;
		}else {
			MemberBean mb = memberService.insert(memberBean);
			if (mb != null) {
				msg.setMessage("Insert成功");
				msg.setSuccess("true");
				return msg;
			}else{
				msg.setMessage("有重複email，Insert失敗");
				msg.setSuccess("false");
				return msg;
			}
		}
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.PUT,
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean MemberUpdate(@RequestBody MemberBean memberBean) {
		MsgBean msg = new MsgBean();

		if (memberBean.getId().trim().length() == 0 || memberBean.getId() == null) {
			msg.setMessage("格式錯誤，沒有給memberId");
			msg.setSuccess("false");
			return msg;
		} else {
			MemberBean mb = memberService.update(memberBean);
			if (mb != null) {
				msg.setMessage("Update成功");
				msg.setSuccess("true");
				return msg;
			}else{
				msg.setMessage("有重複email，Update失敗");
				msg.setSuccess("false");
				return msg;
			}
		}
	}

}
