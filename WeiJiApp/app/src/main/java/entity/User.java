package entity;

import java.sql.Timestamp;

public class User {
	
	private int userId;
	private String userName;
	private String realName;
	private String passWord;
	private String sex;
	private int age;
	private int score;
	float height;
	float weight;
	String imageUrl;
	String address;
	int phone;
	Timestamp createTime;
	

	public User() {
		super();
	}

	public User(int userId) {
		super();
		this.userId = userId;
	}

	public User(String userName, String realName, String passWord, String sex, int age, int score, float height,
			float weight, String imageUrl, String address, int phone, Timestamp createTime) {
		super();
		this.userName = userName;
		this.realName = realName;
		this.passWord = passWord;
		this.sex = sex;
		this.age = age;
		this.score = score;
		this.height = height;
		this.weight = weight;
		this.imageUrl = imageUrl;
		this.address = address;
		this.phone = phone;
		this.createTime = createTime;
	}


	public User(int userId, String userName, String realName, String passWord, String sex, int age, int score,
			float height, float weight, String imageUrl, String address, int phone, Timestamp createTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.realName = realName;
		this.passWord = passWord;
		this.sex = sex;
		this.age = age;
		this.score = score;
		this.height = height;
		this.weight = weight;
		this.imageUrl = imageUrl;
		this.address = address;
		this.phone = phone;
		this.createTime = createTime;
	}


	


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public float getHeight() {
		return height;
	}


	public void setHeight(float height) {
		this.height = height;
	}


	public float getWeight() {
		return weight;
	}


	public void setWeight(float weight) {
		this.weight = weight;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}


	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + Float.floatToIntBits(height);
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result + phone;
		result = prime * result + ((realName == null) ? 0 : realName.hashCode());
		result = prime * result + score;
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		result = prime * result + userId;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + Float.floatToIntBits(weight);
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (Float.floatToIntBits(height) != Float.floatToIntBits(other.height))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (phone != other.phone)
			return false;
		if (realName == null) {
			if (other.realName != null)
				return false;
		} else if (!realName.equals(other.realName))
			return false;
		if (score != other.score)
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		if (userId != other.userId)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", realName=" + realName + ", passWord=" + passWord
				+ ", sex=" + sex + ", age=" + age + ", score=" + score + ", height=" + height + ", weight=" + weight
				+ ", imageUrl=" + imageUrl + ", address=" + address + ", phone=" + phone + ", createTime=" + createTime
				+ "]";
	}
	
	
	
	
	
	
	
	

}
