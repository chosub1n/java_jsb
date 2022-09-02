package kr.green.lg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.lg.dao.MemberDao;

@Service
public class MemberServiceImp implements MemberService{
	
	@Autowired
	MemberDao memberDao;

}
