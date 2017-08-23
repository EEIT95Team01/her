package com.eeit95.her.controller.front;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eeit95.her.model.card.MsgBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.orderform.OrderformBean;
import com.eeit95.her.model.pack.MsgSelectPackBean;
import com.eeit95.her.model.pack.MsgSelectPackGiftBean;
import com.eeit95.her.model.pack.PackBean;
import com.eeit95.her.model.pack.PackGiftBean;
import com.eeit95.her.model.pack.PackInsertBean;
import com.eeit95.her.model.service.PackService;

@Controller
@RequestMapping("/user")
public class PackController {

	@Autowired
	private PackService PS;

	@InitBinder
	public void initializePropertyEditor(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(
				java.util.Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		webDataBinder.registerCustomEditor(
				int.class, new PrimitiveNumberEditor(Integer.class, true));
		webDataBinder.registerCustomEditor(
				double.class, new PrimitiveNumberEditor(Double.class, true));

	}

	
	
	//Pack
	 //selectByMidAndStatus (0822)
	 @RequestMapping(value = "/pack", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody MsgSelectPackBean selectMidAndStatus(PackBean bean) {
	  MsgSelectPackBean msg = new MsgSelectPackBean();
	  List<PackBean> result = PS.selectByMIdnStatusnPId(bean);
	  if(result != null) {
	   msg.setMessage("success");
	   msg.setSuccess("true");
	   msg.setData(result);
	   System.out.println("PackController - select");
	  } else {
	   msg.setMessage("查無訂單");
	   msg.setSuccess("false");
	  }
	  return msg;
	 }
	 
	//selectByPid (0822)
	 @RequestMapping(value = "/packId", method = RequestMethod.GET, produces = "application/json")
	 public @ResponseBody MsgSelectPackBean selectId(PackBean bean) {
	  MsgSelectPackBean msg = new MsgSelectPackBean();
	  PackBean result = PS.selectById(bean);
	  List<PackBean> list= new ArrayList<PackBean>();
	  list.add(result);
	  if(result != null) {
	   msg.setMessage("success");
	   msg.setSuccess("true");
	   msg.setData(list);
	   System.out.println("PackController - select");
	  } else {
	   msg.setMessage("查無訂單");
	   msg.setSuccess("false");
	  }
	  return msg;
	 }
	 
	// PackGiftSelect 0823
		@RequestMapping(value = "/packgift", method = RequestMethod.GET, produces = "application/json")
		public @ResponseBody MsgSelectPackGiftBean selectById(PackBean bean) {
			MsgSelectPackGiftBean msg = new MsgSelectPackGiftBean();
			List<PackGiftBean> result = PS.selectByPackId(bean);

			msg.setMessage("success");
			msg.setSuccess("true");
			msg.setData(result);

			return msg;
		}	 
	 
	//Pack
	//新增 - insert (POST-0816 TEST OK)
	@RequestMapping(value = "/pack", method = RequestMethod.POST, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean packinsert(@RequestBody PackInsertBean pibean) {
		MsgBean msg = new MsgBean();
		PackBean result = PS.insert(pibean);
		if (result != null) {
			msg.setMessage("success");
			msg.setSuccess("true");
		} else {
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}
	
	
	
	//Pack
		//新增 - update (PUT-0816 TEST OK)
	@RequestMapping(value = "/pack", method = RequestMethod.PUT, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean packupdate(@RequestBody PackBean packBean) {
		MsgBean msg = new MsgBean();
		
		PackBean result = PS.update(packBean);
		
		if (result != null) {
			msg.setMessage("success");
			msg.setSuccess("true");
		} else {
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}
	
	// delete (0817-NG)
	@RequestMapping(value = "/pack/{id}", method = RequestMethod.DELETE, 
			 produces = "application/json")
	public @ResponseBody MsgBean packdelete(@PathVariable(value="id") String id) {
		System.out.println("do delete --1");
		MsgBean msg = new MsgBean();
		boolean result = PS.delete(id);
		if (result) {
			System.out.println("do delete --2");
			msg.setMessage("success");
			msg.setSuccess("true");
		} else {
			System.out.println("do delete --3");
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}
	
/*------------------------------------------------------------------*/
	
	//orderform
	//insert (0817 - POST-OK)
	@RequestMapping(value = "/orderform", method = RequestMethod.POST, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody MsgBean orderforminsert(@RequestBody OrderformBean orderformBean) {
		MsgBean msg = new MsgBean();
		OrderformBean result = PS.insert(orderformBean);
		if (result != null) {
			msg.setMessage("success");
			msg.setSuccess("true");
		} else {
			msg.setMessage("error");
			msg.setSuccess("false");
		}
		return msg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}