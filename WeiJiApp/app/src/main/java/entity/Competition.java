package entity;


import android.os.Parcel;
import android.os.Parcelable;

public class Competition implements Parcelable {
	
	private int competitionId;
	private int userId;
	private String type;
	private String createTime;
	private String beginTime;
	private String endTime;
	private int score;
	private String detail;
	private String title;
	private int num;
	private String imageUrl;
	

	public Competition() {
		super();
	}








	public Competition(int userId, String type, String createTime, String beginTime, String endTime, int score,
			String detail, String title, int num, String imageUrl) {
		super();
		this.userId = userId;
		this.type = type;
		this.createTime = createTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.score = score;
		this.detail = detail;
		this.title = title;
		this.num = num;
		this.imageUrl = imageUrl;
	}




	public Competition(int userId, String type, String beginTime, String endTime, int score, String detail,
			String title, int num) {
		super();
		this.userId = userId;
		this.type = type;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.score = score;
		this.detail = detail;
		this.title = title;
		this.num = num;
	}




	public Competition(int competitionId, int userId, String type, String createTime, String beginTime,
			String endTime, int score, String detail, String title, int num, String imageUrl) {
		super();
		this.competitionId = competitionId;
		this.userId = userId;
		this.type = type;
		this.createTime = createTime;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.score = score;
		this.detail = detail;
		this.title = title;
		this.num = num;
		this.imageUrl = imageUrl;
	}



	public int getCompetitionId() {
		return competitionId;
	}




	public void setCompetitionId(int competitionId) {
		this.competitionId = competitionId;
	}




	public int getUserId() {
		return userId;
	}




	public void setUserId(int userId) {
		this.userId = userId;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getCreateTime() {
		return createTime;
	}




	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}




	public String getBeginTime() {
		return beginTime;
	}




	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}




	public String getEndTime() {
		return endTime;
	}




	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}




	public int getScore() {
		return score;
	}




	public void setScore(int score) {
		this.score = score;
	}




	public String getDetail() {
		return detail;
	}




	public void setDetail(String detail) {
		this.detail = detail;
	}




	public String getTitle() {
		return title;
	}




	public void setTitle(String title) {
		this.title = title;
	}




	public int getNum() {
		return num;
	}




	public void setNum(int num) {
		this.num = num;
	}




	public String getImageUrl() {
		return imageUrl;
	}




	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginTime == null) ? 0 : beginTime.hashCode());
		result = prime * result + competitionId;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + num;
		result = prime * result + score;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + userId;
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
		Competition other = (Competition) obj;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (competitionId != other.competitionId)
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (num != other.num)
			return false;
		if (score != other.score)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Competition [competitionId=" + competitionId + ", userId=" + userId + ", type=" + type + ", createTime="
				+ createTime + ", beginTime=" + beginTime + ", endTime=" + endTime + ", score=" + score + ", detail="
				+ detail + ", title=" + title + ", num=" + num + ", imageUrl=" + imageUrl + "]";
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.competitionId);
		dest.writeInt(this.userId);
		dest.writeString(this.type);
		dest.writeString(this.createTime);
		dest.writeString(this.beginTime);
		dest.writeString(this.endTime);
		dest.writeInt(this.score);
		dest.writeString(this.detail);
		dest.writeString(this.title);
		dest.writeInt(this.num);
		dest.writeString(this.imageUrl);
	}

	protected Competition(Parcel in) {
		this.competitionId = in.readInt();
		this.userId = in.readInt();
		this.type = in.readString();
		this.createTime = in.readString();
		this.beginTime = in.readString();
		this.endTime = in.readString();
		this.score = in.readInt();
		this.detail = in.readString();
		this.title = in.readString();
		this.num = in.readInt();
		this.imageUrl = in.readString();
	}

	public static final Creator<Competition> CREATOR = new Creator<Competition>() {
		@Override
		public Competition createFromParcel(Parcel source) {
			return new Competition(source);
		}

		@Override
		public Competition[] newArray(int size) {
			return new Competition[size];
		}
	};
}
