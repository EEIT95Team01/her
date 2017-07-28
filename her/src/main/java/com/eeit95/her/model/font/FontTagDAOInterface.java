package com.eeit95.her.model.font;

import java.util.List;

public interface FontTagDAOInterface {
	public void insert(FontTagBean fontTagBean);
    public void update(FontTagBean fontTagBean);
    public void delete(String fontId,int tagId);
    public FontBean selectById(String fontId,int tagId);
    public List<FontBean> selectAll();
}
