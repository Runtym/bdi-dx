package com.bdi.sp.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.bdi.sp.service.NaverService;
import com.bdi.sp.vo.Naver;
import com.bdi.sp.vo.TransParam;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class NaverServiceImpl implements NaverService {
	private ObjectMapper om = new ObjectMapper();
	@Override
	public Naver getTrans(String msg) {
		HttpURLConnection con = null;
		BufferedReader br = null;
		String url = "https://openapi.naver.com/v1/language/translate";
		try {
			URL u = new URL(url);
			msg = URLEncoder.encode(msg, "utf-8");
			con = (HttpURLConnection)u.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			con.setRequestProperty("X-Naver-Client-Id", "PPzE6AulijIdSvRmJ1Mg");
			con.setRequestProperty("X-Naver-Client-Secret", "gPB08e6FBr");
			String param = "source=ko&target=en&text=" + msg;
			con.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(con.getOutputStream());
			dos.writeBytes(param);
			dos.flush();
			dos.close();
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String line = null;
			String text = "";
			while((line = br.readLine())!=null){
				text += line;
			}
			return om.readValue(text,Naver.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	@Override
	public Naver getTrans(TransParam tp) {
		HttpURLConnection con = null;
		BufferedReader br = null;
		String url = "https://openapi.naver.com/v1/language/translate";
		try {
			URL u = new URL(url);
			tp.setText(URLEncoder.encode(tp.getText(), "utf-8"));
			con = (HttpURLConnection)u.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			con.setRequestProperty("X-Naver-Client-Id", "PPzE6AulijIdSvRmJ1Mg");
			con.setRequestProperty("X-Naver-Client-Secret", "gPB08e6FBr");
			String param = "source=" + tp.getSource() + "&target=" + tp.getTarget() + "&text=" + tp.getText();
			con.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(con.getOutputStream());
			dos.writeBytes(param);
			dos.flush();
			dos.close();
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String line = null;
			String text = "";
			while((line = br.readLine())!=null){
				text += line;
			}
			return om.readValue(text,Naver.class);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
