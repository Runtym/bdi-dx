package com.bdi.sp.service;

import java.util.List;

import com.bdi.sp.vo.DI;

public interface DIService {
	public List<DI> getDIList(DI d);
	public DI getDI(int dino);
	public int insertDI(DI d);
	public int updateDI(DI d);
	public int deleteDI(int dino);
}
