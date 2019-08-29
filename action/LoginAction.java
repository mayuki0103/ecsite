package com.internousdev.ecsite.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
//	                        ↑struts2が持つActionSupportクラスを継承する
	private String loginUserId;
	private String loginPassword;
	public Map<String,Object>session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();

	public String execute(){
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId,loginPassword);
//		↑JSPから送られてきた引数で、DAOのメソッドを呼び出しDAOで取得した結果をDTOに代入する
		session.put("loginUser",loginDTO);

//		↓DTOから持ってきた値を一致するか確認する
		if(((LoginDTO)session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
//			ログインに成功

			session.put("login_user_id",loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name",buyItemDTO.getItemName());
			session.put("buyItem_price",buyItemDTO.getItemPrice());

//			商品情報が必要なので商品情報をDTOからgetしてる

			return result;
		}
		return result;
	}
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}
	@Override
	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}
