/***************************************************************************
 * Copyright 2016 by HomeDirect - All rights reserved.                *    
 **************************************************************************/
package com.homedirect.template.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.homedirect.template.request.UserLoginRequest;
import com.homedirect.template.request.UserRegistryRequest;
import com.homedirect.template.response.TemplateResponse;

/**
 *  Author : Duy Kien Ngo
 *          Email:kien.ngoduy@homedirect.com.vn
 * Feb 9, 2017
 */

@RestController
@RequestMapping("/")
@PropertySource("classpath:application.properties")
public class HomeController extends AbstractController {

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	public HomeController() {
	}

	@GetMapping(value = "/")
	public ModelAndView home() {
		return new ModelAndView("redirect:/dang-ky");
	}

	@GetMapping(value = "/dang-ky")
	public ModelAndView registry() {
		ModelAndView mv = new ModelAndView("public.register");
		mv.addObject("title","Template - Đăng ký");
		return mv;
	}

	@GetMapping(value = "/dang-nhap")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("public.login");
		mv.addObject("title","Template - Đăng nhập");
		return mv;
	}

	@PostMapping(value = "/luu-tai-khoan")
	public ModelAndView success(HttpServletRequest httpRequest, @ModelAttribute UserRegistryRequest request) {
		String url = apiExchangeService.createURL("/user/registry");
		ResponseEntity<TemplateResponse<Object>> resp = apiExchangeService.post(httpRequest, url, request);
		ModelAndView mv = new ModelAndView("public.success");
		mv.addObject("title","Template - Đăng ký");

		if(apiExchangeService.isUnSuccessResponse(resp.getBody())) {
			mv.addObject("message", resp.getBody().getDescription());
		} else {
			mv.addObject("message", "CHÚC MỪNG BẠN ĐĂNG KÝ THÀNH CÔNG");
		}

		return mv;
	}
	
//	logger.info("===>>> resp: {}", resp.toString());
//	logger.info("===>>> resp - body: {}", resp.getBody().toString());
//	logger.info("===>>> resp - body-data: {}", resp.getBody().getData().toString());

	@PostMapping(value = "/xu-ly-dang-nhap")
	public ModelAndView successLogin(HttpServletRequest httpRequest, @ModelAttribute UserLoginRequest request){
		String url = apiExchangeService.createURL("/user/login");
		ResponseEntity<TemplateResponse<Object>> resp = apiExchangeService.post(httpRequest, url, request);
		ModelAndView mv = new ModelAndView("public.success");
		mv.addObject("title","Template - Đăng nhập");

		if(apiExchangeService.isUnSuccessResponse(resp.getBody())) {
			mv.addObject("message", resp.getBody().getDescription());
		} else {
			mv.addObject("message", "CHÚC MỪNG BẠN ĐĂNG NHẬP THÀNH CÔNG");
		}

		return mv;
	}

}
