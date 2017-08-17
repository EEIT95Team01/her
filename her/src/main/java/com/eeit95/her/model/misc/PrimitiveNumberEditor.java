package com.eeit95.her.model.misc;

import java.text.NumberFormat;

import org.springframework.beans.propertyeditors.CustomNumberEditor;

public class PrimitiveNumberEditor extends CustomNumberEditor {
	//轉型的原始類別(轉型)
	
	public PrimitiveNumberEditor(Class<? extends Number> numberClass, boolean allowEmpty) {
		this(numberClass, null, allowEmpty);
	}
	public PrimitiveNumberEditor(Class<? extends Number> numberClass, NumberFormat numberFormat, boolean allowEmpty) {
		super(numberClass, numberFormat, allowEmpty);
		this.allowEmpty = allowEmpty;
	}
	private boolean allowEmpty;
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(allowEmpty && (text==null || text.length()==0)) {
			setValue(0);
		} else {
			super.setAsText(text);
		}
	}
}
