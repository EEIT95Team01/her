package com.eeit95.her.controller.front;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eeit95.her.model.font.FontBean;
import com.eeit95.her.model.font.FontIUBean;
import com.eeit95.her.model.font.FontSBean;
import com.eeit95.her.model.font.MsgSelectFontBean;
import com.eeit95.her.model.misc.PrimitiveNumberEditor;
import com.eeit95.her.model.service.FontService;

@Controller
@RequestMapping("/user")
public class FontController {

	@Autowired
	private FontService fontService;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@InitBinder
	public void initializePropertyEditor(WebDataBinder webDataBinder) {
		webDataBinder.registerCustomEditor(java.util.Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
		webDataBinder.registerCustomEditor(double.class, new PrimitiveNumberEditor(Double.class, true));
		webDataBinder.registerCustomEditor(int.class, new PrimitiveNumberEditor(Integer.class, true));
	}
	
	
	
	@RequestMapping(value = "/font", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody MsgSelectFontBean select(FontSBean fontSBean) {
		MsgSelectFontBean msg = new MsgSelectFontBean();
		System.out.println("FontSBean = "+fontSBean.toString());
		String fontId = fontSBean.getId();
		String fontnName = fontSBean.getName();
		String option = fontSBean.getOption();
		int tagId = fontSBean.getTagId();
		StringBuffer sqlText = new StringBuffer();
		sqlText.append("select f.id, f.name, f.price, f.cover from font as f");
		if (fontId == null) {
			if (tagId != 0) {
				sqlText.append(" join font_tag t on f.id  = t.fontId where t.tagId = " + tagId);
				if (fontnName!=null) {
					sqlText.append(" and");
				}
			}
//			}else {
//				sqlText.append(" where");
//			}
			
			if (fontnName!=null) {
				if(tagId == 0) {
					sqlText.append(" where");
				}
				sqlText.append(" f.name like '%" + fontnName + "%'");
			}
			if(option!=null) {
			switch (option) {
			case "ID_ASC":
				sqlText.append(" order by f.id");
				break;
			case "SALES_DESC":
				sqlText.append(" order by f.salesCount");
				break;
			case "PRICE_ASC":
				sqlText.append(" order by f.price");
				break;
			case "PRICE_DESC":
				sqlText.append(" order by f.price desc");
				break;
			default:
				sqlText.append(" order by f.id");
				break;
			}}else {
				sqlText.append(" order by f.id");
			}
		
		} else {
			sqlText.append(" where f.id = '" + fontId+"'");
		}
		System.out.println("sqlText = "+sqlText.toString());
		FontIUBean fIUBean = new FontIUBean();
		List<FontBean> fontBeans = new ArrayList<FontBean>();
		List<Map<String, Object>> results = jdbcTemplate.queryForList(sqlText.toString());
		if (!results.isEmpty()) {
			for (Map<String, Object> result : results) {
				FontBean fontBean = new FontBean();
				fontBean.setId((String) result.get("id"));
				fontBean.setCover((String) result.get("cover"));
				fontBean.setName((String) result.get("name"));
				fontBean.setPrice(((BigDecimal) result.get("price")).doubleValue());
				fontBeans.add(fontBean);
			}

			if (fontId == null) {
				fIUBean.setFont(fontBeans);
			} else {
				fIUBean.setFont(fontBeans);
				fIUBean.setTagIds(fontService.selectTagById(fontSBean));
				fIUBean.setDescriptions(fontService.selectDescById(fontSBean));
			}
			msg.setMessage("success");
			msg.setSuccess("true");
			msg.setData(fIUBean);
		}else {
			msg.setMessage("fail");
			msg.setSuccess("false");
			msg.setData(fIUBean);
		}
		return msg;
	}



}
