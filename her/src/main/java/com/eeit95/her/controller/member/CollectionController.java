package com.eeit95.her.controller.member;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.eeit95.her.model.member.CollectionBean;
import com.eeit95.her.model.member.MsgBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.service.CollectionService;

import sun.dc.pr.PRError;

@Controller
@RequestMapping("/api")
public class CollectionController {
	@InitBinder
	 public void initializePropertyEditor(WebDataBinder webDataBinder) {
	  webDataBinder.registerCustomEditor(java.sql.Timestamp.class,
	     new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	 }
	
	@Autowired
	private CollectionService collectionService;
	
	@RequestMapping(value = "/collection", method=RequestMethod.GET
			, produces = "application/json")
	public @ResponseBody MsgBean CollectionQuery(
			@RequestParam (value="memberId",required=false)String memberId , 
			@RequestParam (value="select",required=false)String select ,
			@RequestParam (value="offset",required=false)String offset , 
			@RequestParam (value="limit",required=false)String limit) {
		
		MsgBean msg = new MsgBean();
		List<Object> listObj = new ArrayList<Object>();
		
		if(memberId.trim().length()==0 || memberId.trim()==null){
			msg.setMessage("格式錯誤，memberId不可為空值");
			msg.setSuccess("false");
			return msg;
		}else if (select.trim().length()==0 || select.trim()==null){
			msg.setMessage("格式錯誤，select不可為空值");
			msg.setSuccess("false");
			return msg;
		}else{
			if(select.trim().equals("all")){
				List<CollectionBean> list = collectionService.allCollection(memberId);
				if(list == null ){
					msg.setMessage("collection內沒有資料");
					msg.setSuccess("false");
					return msg;
				}
				for(CollectionBean cb : list){
					listObj.add(cb.getProductId());
				}
				msg.setMessage("查詢成功");
				msg.setSuccess("true");
				msg.setData(listObj);
				return msg;
				
			}else if (select.trim().equals("card")){
				List<CollectionBean> list = collectionService.allCardCollection(memberId);
				if(list == null ){
					msg.setMessage("Collection內沒有card資料");
					msg.setSuccess("false");
					return msg;
				}
				for(CollectionBean cb : list){
					listObj.add(cb.getProductId());
				}
				msg.setMessage("查詢成功");
				msg.setSuccess("true");
				msg.setData(listObj);
				return msg;
			}else if (select.trim().equals("font")){
				List<CollectionBean> list = collectionService.allFontCollection(memberId);
				if(list == null ){
					msg.setMessage("Collection內沒有font資料");
					msg.setSuccess("false");
					return msg;
				}
				for(CollectionBean cb : list){
					listObj.add(cb.getProductId());
				}
				msg.setMessage("查詢成功");
				msg.setSuccess("true");
				msg.setData(listObj);
				return msg;
			}else if (select.trim().equals("gift")){
				List<CollectionBean> list = collectionService.allGiftCollection(memberId);
				if(list == null ){
					msg.setMessage("Collection內沒有gift資料");
					msg.setSuccess("false");
					return msg;
				}
				for(CollectionBean cb : list){
					listObj.add(cb.getProductId());
				}
				msg.setMessage("查詢成功");
				msg.setSuccess("true");
				msg.setData(listObj);
				return msg;	
			}
		}
		return msg;
	}//collectionQuery end
	
	@RequestMapping(value = "/collection", method = RequestMethod.POST
			,consumes="application/json", produces = "application/json")
	public @ResponseBody MsgBean CollectionInsert(
			@RequestBody CollectionBean cb){
		MsgBean msg = new MsgBean();
		System.out.println("memberId = "+cb.getMemberId()+" , productId = "+ cb.getProductId());
		if(cb.getMemberId().trim().length()==0||cb.getMemberId() == null){
			msg.setMessage("格式錯誤，memberId不可為空值");
			msg.setSuccess("false");
			return msg;	
		}else if (cb.getProductId().trim().length()==0||cb.getProductId()==null){
			msg.setMessage("格式錯誤，productId不可為空值");
			msg.setSuccess("false");
			return msg;	
		}else{
			CollectionBean cb2 = collectionService.insert(cb.getMemberId(),cb.getProductId());
			if (cb != null) {
				msg.setMessage("Insert成功");
				msg.setSuccess("true");
				return msg;
			} else {
				msg.setMessage("有重複productId，Insert失敗");
				msg.setSuccess("false");
				return msg;
			}
		}
		
	}//CollectionInsert end
	
	
	@RequestMapping(value = "/collection", method = RequestMethod.DELETE
			,consumes="application/json", produces = "application/json")
	public @ResponseBody MsgBean CollectionDelete(
			@RequestBody CollectionBean cb){
		MsgBean msg = new MsgBean();
		
		if(cb.getMemberId().trim().length()==0||cb.getMemberId() == null){
			msg.setMessage("格式錯誤，memberId不可為空值");
			msg.setSuccess("false");
			return msg;	
		}else if (cb.getProductId().trim().length()==0||cb.getProductId()==null){
			msg.setMessage("格式錯誤，productId不可為空值");
			msg.setSuccess("false");
			return msg;	
		}else{
			Boolean x = collectionService.delete(cb.getMemberId(),cb.getProductId());
			if (x) {
				msg.setMessage("Delete成功");
				msg.setSuccess("true");
				return msg;
			} else {
				msg.setMessage("沒有該值，Delete失敗");
				msg.setSuccess("false");
				return msg;
			}
		}
		
	}//CollectionDelete end
	
	
}
