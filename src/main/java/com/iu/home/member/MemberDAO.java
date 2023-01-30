package com.iu.home.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.iu.home.util.DBConnection;

public class MemberDAO {
	//setAddMember
	public int setAddMebmeber(MemberDTO memberDTO) throws Exception {
		Connection con = DBConnection.getConnection();
		
		String sql = "INSERT INTO MEMBER01 VALUES(?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getMember_id());
		st.setString(2, memberDTO.getMember_pw());
		st.setString(3, memberDTO.getMember_name());
		st.setString(4, memberDTO.getMember_phone());
		st.setString(5, memberDTO.getMember_email());
		st.setString(6, memberDTO.getMember_jumin());
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	public static void main(String[] args) {
		MemberDAO memberDAO = new MemberDAO();
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMember_id("id1");
		memberDTO.setMember_pw("pw1");
		memberDTO.setMember_name("name1");
		memberDTO.setMember_phone("pnhoe1");
		memberDTO.setMember_email("email1");
		memberDTO.setMember_jumin("jumin1");
		try {
			int result =  memberDAO.setAddMebmeber(memberDTO);
			System.out.println(result !=0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
