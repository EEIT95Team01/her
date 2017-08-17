package com.eeit95.her.controller.Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.eeit95.her.model.card.MsgBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.service.AdminService;
import com.eeit95.her.model.service.AdminTagService;
import com.eeit95.her.model.tag.MsgSelectTagBean;
import com.eeit95.her.model.tag.TagBean;
import com.eeit95.her.model.tag.TagSelectBean;



@Controller
@RequestMapping("/admin")
public class AdminTagController { // implements CardServiceInterface
	
	
	@InitBinder
	public void initializePropertyEditor(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(Double.class, true));

	}

	@Autowired
	private AdminTagService ATS;
	
	// tag
	@RequestMapping(value = "/tag", method = RequestMethod.GET , produces = "application/json")
	public @ResponseBody MsgSelectTagBean tagselect(TagSelectBean tagSelectBean) {
		System.out.println("tagSelectBean~~~ ="+tagSelectBean.toString());
		MsgSelectTagBean msg = new MsgSelectTagBean();
		msg.setMessage("Success");
		msg.setSuccess("true");
		msg.setData(ATS.select(tagSelectBean));
		System.out.println("setData~~~ ="+ATS.select(tagSelectBean).toString());
		System.out.println("setData~~~ ="+msg.toString());
		return msg;
	}


	@RequestMapping(value = "/tag", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean cardinsert(@RequestBody TagBean tagBean) {
		System.out.println("111111111111 tagBean :" + tagBean.toString());

		MsgBean msg = new MsgBean();
		// 驗證資料
		if (tagBean.getId() != 0 ) {
			msg.setMessage("error");
			msg.setSuccess("false");
			return msg;
		}
		
		boolean result = ATS.insert(tagBean);
		// 判斷回傳值是否正確
		if (result) {
			msg.setMessage("Success");
			msg.setSuccess("true");
		} else {
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}

	@RequestMapping(value = "/tag", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean cardupdate(@RequestBody TagBean tagBean) {
		System.out.println("111111111111  tagBean:" + tagBean.toString());
		MsgBean msg = new MsgBean();
		// 驗證資料
		if (tagBean.getId() == 0) {
			System.out.println("222222222222");
			msg.setMessage("格式錯誤");
			msg.setSuccess("false");
			System.out.println("333333333333");
			return msg;
			
		}
		
		boolean result = ATS.update(tagBean);
		// 判斷回傳值是否正確
		if (result) {
			System.out.println("boolean result = true");
			msg.setMessage("Success");
			msg.setSuccess("true");
		} else {
			System.out.println("boolean result = false");
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}

}
