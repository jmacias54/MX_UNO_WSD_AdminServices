package mx.com.amx.unotv.adminservice.model.resquest;

public class ItemsRequestByTitle {
	
	
	 private String type; 
	 private String id; 
	 private String status; 
	 private String title; 
	 private int limit; 
	 private int page;
	 
	 
	 
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	 
	 
	 

}
