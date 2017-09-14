package entity;


import android.os.Parcel;
import android.os.Parcelable;

public class Run implements Parcelable {
	private int runId;
	private int userId;
	private int month;
	private int day;
	private String stepCount;
	private String mileage;//����
	private String weekDay;
	private String timeLength;
	private String calories;
	private String velocity;
	private String mileages;//����
	
	public Run(int month, int day, String stepCount, String mileage, String weekDay, String timeLength, String calories,
			String velocity, String mileages) {
		super();
		this.month = month;
		this.day = day;
		this.stepCount = stepCount;
		this.mileage = mileage;
		this.weekDay = weekDay;
		this.timeLength = timeLength;
		this.calories = calories;
		this.velocity = velocity;
		this.mileages = mileages;
	}
	public int getRunId() {
		return runId;
	}
	public void setRunId(int runId) {
		this.runId = runId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getStepCount() {
		return stepCount;
	}
	public void setStepCount(String stepCount) {
		this.stepCount = stepCount;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}
	public String getTimeLength() {
		return timeLength;
	}
	public void setTimeLength(String timeLength) {
		this.timeLength = timeLength;
	}
	public String getCalories() {
		return calories;
	}
	public void setCalories(String calories) {
		this.calories = calories;
	}
	public String getVelocity() {
		return velocity;
	}
	public void setVelocity(String velocity) {
		this.velocity = velocity;
	}
	public String getMileages() {
		return mileages;
	}
	public void setMileages(String mileages) {
		this.mileages = mileages;
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.runId);
		dest.writeInt(this.userId);
		dest.writeInt(this.month);
		dest.writeInt(this.day);
		dest.writeString(this.stepCount);
		dest.writeString(this.mileage);
		dest.writeString(this.weekDay);
		dest.writeString(this.timeLength);
		dest.writeString(this.calories);
		dest.writeString(this.velocity);
		dest.writeString(this.mileages);
	}

	protected Run(Parcel in) {
		this.runId = in.readInt();
		this.userId = in.readInt();
		this.month = in.readInt();
		this.day = in.readInt();
		this.stepCount = in.readString();
		this.mileage = in.readString();
		this.weekDay = in.readString();
		this.timeLength = in.readString();
		this.calories = in.readString();
		this.velocity = in.readString();
		this.mileages = in.readString();
	}

	public static final Creator<Run> CREATOR = new Creator<Run>() {
		@Override
		public Run createFromParcel(Parcel source) {
			return new Run(source);
		}

		@Override
		public Run[] newArray(int size) {
			return new Run[size];
		}
	};
}