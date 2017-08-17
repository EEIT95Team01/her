package com.eeit95.her.controller.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.eeit95.her.model.member.MemberBean;
import com.eeit95.her.model.member.MsgBean;
import com.eeit95.her.model.member.RecipientBean;
import com.eeit95.her.model.service.MemberService;
import com.eeit95.her.model.service.RecipientService;

@Controller
@RequestMapping("/api")
public class RecipientController {

	@Autowired
	private RecipientService recipientService;
	
	@RequestMapping(value = "/recipient", method = RequestMethod.GET
			, produces = "application/json")
	public @ResponseBody MsgBean RecipientQuery(@RequestParam(value="memberId",required=false) String memberId
			,@RequestParam(value="id",required=false) String id) {
		MsgBean msg = new MsgBean();
		
		if(memberId.trim().length()==0 || memberId.trim()==null){
			msg.setMessage("格式錯誤，不可不給recipientId");
			msg.setSuccess("false");
			return msg;
		}else if(id.trim().length()==0 || id.trim()==null){
			List<RecipientBean> list = recipientService.findByMemberId(memberId);
			if(list!=null){
				List<Object> listObj = new ArrayList<Object>();
				for(RecipientBean rb:list){
					listObj.add(rb);
				}
				msg.setMessage("Query成功");
				msg.setSuccess("true");
				msg.setData(listObj);
				return msg;
			}else{
				msg.setMessage("無此資料");
				msg.setSuccess("false");
				return msg;
			}
		}else{
			RecipientBean rb = recipientService.findByRecipientId(id);
			
			if(rb!=null){
				List<Object> listObj = new ArrayList<Object>();
				listObj.add(rb);
				msg.setMessage("Query成功");
				msg.setSuccess("true");
				msg.setData(listObj);
				return msg;
			}else{
				msg.setMessage("無此資料");
				msg.setSuccess("false");
				return msg;
			}
		}
	}

	
	

	@RequestMapping(value = "/recipient", method = RequestMethod.POST,
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean RecipientInsert(@RequestBody RecipientBean recipientBean) {
		System.out.println("recipientBean = "+recipientBean.toString());
		MsgBean msg = new MsgBean();
		if(recipientBean!=null){
			RecipientBean rb = recipientService.insert(recipientBean);
			if (rb != null) {
				msg.setMessage("Insert成功");
				msg.setSuccess("true");
				return msg;
			}else{
				msg.setMessage("Insert失敗");
				msg.setSuccess("false");
				return msg;
			}
		}else{
			msg.setMessage("請給值");
			msg.setSuccess("false");
			return msg;
		}
	}
	
	@RequestMapping(value = "/recipient", method = RequestMethod.PUT,
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean RecipientUpdate(@RequestBody RecipientBean recipientBean) {
		MsgBean msg = new MsgBean();

		if (recipientBean.getId().trim().length() == 0 || recipientBean.getId() == null) {
			msg.setMessage("格式錯誤，沒有給recipientId");
			msg.setSuccess("false");
			return msg;
		} else {
			RecipientBean rb = recipientService.update(recipientBean);
			if (rb != null) {
				msg.setMessage("Update成功");
				msg.setSuccess("true");
				return msg;
			}else{
				msg.setMessage("無此資料，Update失敗");
				msg.setSuccess("false");
				return msg;
			}
		}

	}
	
	
	@RequestMapping(value = "/recipient", method = RequestMethod.DELETE,
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean RecipientDelete(@RequestBody RecipientBean recipientBean) {
		MsgBean msg = new MsgBean();
			
		if (recipientBean.getId().trim().length() == 0 || recipientBean.getId() == null) {
			msg.setMessage("格式錯誤，沒有給recipientId");
			msg.setSuccess("false");
			return msg;
		}else{
			boolean x= recipientService.delete(recipientBean);
			if(x){
				msg.setMessage("Delete成功");
				msg.setSuccess("true");
				return msg;
			}else{
				msg.setMessage("無此資料，Delete失敗");
				msg.setSuccess("false");
				return msg;
			}
		}
	}
	

}
