package mx.com.amx.unotv.adminservice.model.response;

public class ItemsResponse {

	private String id;
	private String title;
	private String description;
	private String date;
	private String typeItem;
	private String image;
	private String idSection;
	private String idCategories;
	private String descCategories;
	private String descSection;
	private String urlItem;
	private int status;

	public ItemsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemsResponse(String id, String title, String description, String date, String typeItem, String image,
			String idSection, String idCategories, String descCategories, String descSection, String urlItem,
			int status) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.typeItem = typeItem;
		this.image = image;
		this.idSection = idSection;
		this.idCategories = idCategories;
		this.descCategories = descCategories;
		this.descSection = descSection;
		this.urlItem = urlItem;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTypeItem() {
		return typeItem;
	}

	public void setTypeItem(String typeItem) {
		this.typeItem = typeItem;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIdSection() {
		return idSection;
	}

	public void setIdSection(String idSection) {
		this.idSection = idSection;
	}

	public String getIdCategories() {
		return idCategories;
	}

	public void setIdCategories(String idCategories) {
		this.idCategories = idCategories;
	}

	public String getDescCategories() {
		return descCategories;
	}

	public void setDescCategories(String descCategories) {
		this.descCategories = descCategories;
	}

	public String getDescSection() {
		return descSection;
	}

	public void setDescSection(String descSection) {
		this.descSection = descSection;
	}

	public String getUrlItem() {
		return urlItem;
	}

	public void setUrlItem(String urlItem) {
		this.urlItem = urlItem;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
