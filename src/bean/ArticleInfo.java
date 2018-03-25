package bean;

//web_url;main;document_type;pub_date

public class ArticleInfo {
	private String web_url;
	private String main;
	private String document_type;
	private String pub_date;
	
	public String getWeb_url() {
		return web_url;
	}
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDocument_type() {
		return document_type;
	}
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}
	public String getPub_date() {
		return pub_date;
	}
	public void setPub_date(String pub_date) {
		this.pub_date = pub_date;
	}
}
