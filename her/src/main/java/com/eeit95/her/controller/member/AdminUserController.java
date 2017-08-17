package com.eeit95.her.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eeit95.her.model.card.MsgBean;
import com.eeit95.her.model.member.AdminUserBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.service.AdminUserService;


@Controller
@RequestMapping("/api")
@SessionAttributes(names = {"adminUser"})
public class AdminUserController {
	@InitBinder
	public void initializePropertyEditor(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(Double.class, true));

	}

	@Autowired
	private AdminUserService adminUserService;

	@RequestMapping(value = "/adminUserLogin", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean AdminUserLogin(@RequestBody AdminUserBean adminUserBean) {
		MsgBean msg = new MsgBean();

		if (adminUserBean.getUsername().trim().length() == 0 || adminUserBean.getUsername() == null) {
			msg.setMessage("格式錯誤，Username不可為空值");
			msg.setSuccess("false");
			return msg;
		} else if (adminUserBean.getPassword().trim().length() == 0 || adminUserBean.getPassword() == null) {
			msg.setMessage("格式錯誤，password不可為空值");
			msg.setSuccess("false");
			return msg;
		} else {
			AdminUserBean ab = adminUserService.login(adminUserBean.getUsername(), adminUserBean.getPassword());
			if (ab != null) {
				msg.setMessage("登入成功");
				msg.setSuccess("true");
				return msg;
			} else {
				msg.setMessage("登入失敗，帳號密碼不符");
				msg.setSuccess("false");
				return msg;
			}
		}
	}
//有問題回頭再測
	@RequestMapping(value = "/adminUser", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean AdminUserInsert(@RequestBody AdminUserBean adminUserBean) {
		System.out.println("into AdminUserInsert"+adminUserBean.toString());
		MsgBean msg = new MsgBean();

		if (adminUserBean.getUsername().trim().length() == 0 || adminUserBean.getUsername() == null) {
			msg.setMessage("格式錯誤，Username不可為空值");
			msg.setSuccess("false");
			return msg;
		} else if (adminUserBean.getPassword().trim().length() == 0 || adminUserBean.getPassword() == null) {
			msg.setMessage("格式錯誤，Password不可為空值");
			msg.setSuccess("false");
			return msg;
		} else {
			AdminUserBean ab = adminUserService.insert(adminUserBean);
			if (ab != null) {
				msg.setMessage("Insert成功");
				msg.setSuccess("true");
				return msg;
			} else {
				msg.setMessage("有重複Username，Insert失敗");
				msg.setSuccess("false");
				return msg;
			}
		}
	}

	@RequestMapping(value = "/adminUser", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean AdminUserUpdate(@RequestBody AdminUserBean adminUserBean) {
		MsgBean msg = new MsgBean();

		if (adminUserBean.getUsername().trim().length() == 0 || adminUserBean.getUsername() == null) {
			msg.setMessage("格式錯誤，Username不可為空值");
			msg.setSuccess("false");
			return msg;
		} else {
			AdminUserBean ab = adminUserService.update(adminUserBean);
			if (ab != null) {
				msg.setMessage("Update成功");
				msg.setSuccess("true");
				return msg;
			} else {
				msg.setMessage("有重複Username，Update失敗");
				msg.setSuccess("false");
				return msg;
			}
		}
	}

}
