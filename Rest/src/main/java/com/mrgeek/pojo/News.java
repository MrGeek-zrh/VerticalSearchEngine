package com.mrgeek.pojo;


public class News {
    private Integer id;

    private String title;

    private String image;

    private String resource;

    private String createdAt;

    private String isValid;

    private String content;
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt == null ? null : createdAt.trim();
    }

    public String getIsValid() {
        return isValid;
    }

    public void setIsValid(String isValid) {
        this.isValid = isValid == null ? null : isValid.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", image=" + image + ", resource=" + resource + ", createdAt="
				+ createdAt + ", isValid=" + isValid + ", content=" + content + "]";
	}
    
}