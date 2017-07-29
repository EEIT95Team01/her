package com.eeit95.her.model.font;

import java.util.List;

public interface FontDAOInterface {
	public void insert(FontBean fontBean);
    public void update(FontBean fontBean);
    public void delete(String id);
    public FontBean selectById(String id);
    public List<FontBean> selectAll();
}
