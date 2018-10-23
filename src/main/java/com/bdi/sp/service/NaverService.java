package com.bdi.sp.service;

import com.bdi.sp.vo.Naver;
import com.bdi.sp.vo.TransParam;

public interface NaverService {
	public Naver getTrans(String text);
	public Naver getTrans(TransParam tp);
}
