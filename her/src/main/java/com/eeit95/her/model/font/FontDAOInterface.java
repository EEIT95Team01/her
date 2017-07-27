package com.eeit95.her.model.font;

import java.util.List;

public interface FontDAOInterface {
	public void insert(FontBean fontBean);
    public void update(FontBean fontBean);
    public void delete(String id);
    public FontBean findByPrimaryKey(String id);
    public List<FontBean> getAll();
}
