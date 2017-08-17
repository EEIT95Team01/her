package com.eeit95.her.model.font;

import java.util.List;

public interface WriterDAOInterface {
	public WriterBean insert(WriterBean writerBean);
    public WriterBean update(WriterBean writerBean);
    public boolean delete(int id);
    public WriterBean selectById(int id);
    public List<WriterBean> selectByIdOrName(int id, String name);
    public List<WriterBean> selectAll();
}
