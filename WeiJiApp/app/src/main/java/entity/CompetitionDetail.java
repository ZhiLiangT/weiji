package entity;

import android.os.Parcel;
import android.os.Parcelable;

public class CompetitionDetail implements Parcelable {
	
	private int cometitionDetailId;
	private int competitionId;
	private int userId;
	
	public CompetitionDetail() {
		super();
	}

	public CompetitionDetail(int cometitionDetailId, int competitionId, int userId) {
		super();
		this.cometitionDetailId = cometitionDetailId;
		this.competitionId = competitionId;
		this.userId = userId;
	}

	public int getCometitionDetailId() {
		return cometitionDetailId;
	}

	public void setCometitionDetailId(int cometitionDetailId) {
		this.cometitionDetailId = cometitionDetailId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cometitionDetailId;
		result = prime * result + competitionId;
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
		CompetitionDetail other = (CompetitionDetail) obj;
		if (cometitionDetailId != other.cometitionDetailId)
			return false;
		if (competitionId != other.competitionId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CompetitionDetail [cometitionDetailId=" + cometitionDetailId + ", competitionId=" + competitionId
				+ ", userId=" + userId + "]";
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.cometitionDetailId);
		dest.writeInt(this.competitionId);
		dest.writeInt(this.userId);
	}

	protected CompetitionDetail(Parcel in) {
		this.cometitionDetailId = in.readInt();
		this.competitionId = in.readInt();
		this.userId = in.readInt();
	}

	public static final Parcelable.Creator<CompetitionDetail> CREATOR = new Parcelable.Creator<CompetitionDetail>() {
		@Override
		public CompetitionDetail createFromParcel(Parcel source) {
			return new CompetitionDetail(source);
		}

		@Override
		public CompetitionDetail[] newArray(int size) {
			return new CompetitionDetail[size];
		}
	};
}
