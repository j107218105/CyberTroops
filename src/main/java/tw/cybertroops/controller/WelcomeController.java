package tw.cybertroops.controller;

//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.jackson2.JacksonFactory;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import tw.cybertroops.repository.SoldierRepository;

/**
 * 根
 *
 * @author P-C Lin (a.k.a 高科技黑手)
 */
@Controller
@RequestMapping(value = "/")
public class WelcomeController {

	@Autowired
	SoldierRepository soldierRepository;

	private final static String CLIENT_ID = "924360823817-nr6d6llapvse0odj392t6kotsshpvuj1.apps.googleusercontent.com";

	/**
	 * 首頁
	 *
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
	@SuppressWarnings("UseSpecificCatch")
	public ModelAndView index(HttpSession session) {
		ModelAndView modelAndView;
		Document document;
		Element documentElement;
		try {
			document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getClass().getResourceAsStream("/tw/cybertroops/skeleton.xml"));
			documentElement = document.getDocumentElement();
		} catch (Exception exception) {
			modelAndView = new ModelAndView();
//			modelAndView.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			return modelAndView;
		}

		String id = (String) session.getAttribute("id");
		if (id != null) {
			Element elementMe = document.createElement("me");
			elementMe.setAttribute("id", id);
			elementMe.setTextContent("登入者的名字");
			documentElement.appendChild(elementMe);
		}

		modelAndView = new ModelAndView("index");
		modelAndView.getModelMap().addAttribute(new DOMSource(document));
		return modelAndView;
	}

	/**
	 *
	 * @param response
	 * @param session
	 * @throws Exception
	 */
	@RequestMapping(value = "/default.aspx", produces = "text/xml;charset=UTF-8")
	public void index(HttpServletResponse response, HttpSession session) throws Exception {
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(getClass().getResourceAsStream("/tw/cybertroops/skeleton.xml"));
		Element documentElement = document.getDocumentElement();

		String id = (String) session.getAttribute("id");
		if (id != null) {
			Element elementMe = document.createElement("me");
			elementMe.setAttribute("id", id);
			elementMe.setTextContent("登入者的名字");
			documentElement.appendChild(elementMe);
		}

		TransformerFactory.newInstance().newTransformer().transform(new DOMSource(document), new StreamResult(response.getOutputStream()));
	}

	/**
	 * 登入
	 *
	 * @param idToken
	 * @param session
	 * @return
	 * @throws Exception
	 */
//	@RequestMapping(path = "/signIn.json", produces = "application/json;charset=UTF-8")
//	@ResponseBody
//	public String signIn(@RequestParam(name = "idToken") String idToken, HttpSession session) throws Exception {
//		JSONObject jsonObject = new JSONObject();
//
//		GoogleIdTokenVerifier googleIdTokenVerifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance()).setAudience(Collections.singletonList(CLIENT_ID)).build();
//		GoogleIdToken googleIdToken = googleIdTokenVerifier.verify(idToken);
//		if (googleIdToken != null) {
//			Payload payload = googleIdToken.getPayload();
//			jsonObject.put("subject", payload.getSubject());//user identifier
//			jsonObject.put("email", payload.getEmail());
//			jsonObject.put("emailVerified", payload.getEmailVerified());
//			jsonObject.put("name", payload.get("name"));
//			jsonObject.put("picture", payload.get("picture"));
//			jsonObject.put("locale", payload.get("locale"));
//			jsonObject.put("familyName", payload.get("family_name"));
//			jsonObject.put("givenName", payload.get("given_name"));
//			String googleId = payload.getSubject();
//
//			session.setAttribute("id", payload.getSubject());
//		} else {
//			jsonObject.put("reason", "登入時發生錯誤！");
//		}
//
//		return jsonObject.toString();
//	}

	/**
	 * 登出
	 *
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/signOut.json", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String signOut(HttpSession session) throws Exception {
		JSONObject jsonObject = new JSONObject();

		String id = (String) session.getAttribute("id");
		if (id == null) {
			jsonObject.put("reason", "您尚未登入或已逾時登出！");
		} else {
			session.invalidate();
		}

		return jsonObject.toString();
	}
}
