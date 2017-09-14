package entity;

public class BqueryRun {
	private int userId;
    private int month;
    private int day;
    private int stepCount;
    private String mileages;//公里
	private String mileage;//距离
    private String weekDay;
    private String timeLength;
    private String calories;
    private String velocity;

	public BqueryRun(int userId, int month, int day, int stepCount, String mileages, String mileage, String weekDay, String timeLength, String calories, String velocity) {
		this.userId = userId;
		this.month = month;
		this.day = day;
		this.stepCount = stepCount;
		this.mileages = mileages;
		this.mileage = mileage;
		this.weekDay = weekDay;
		this.timeLength = timeLength;
		this.calories = calories;
		this.velocity = velocity;
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

	public int getStepCount() {
		return stepCount;
	}

	public void setStepCount(int stepCount) {
		this.stepCount = stepCount;
	}

	public String getMileages() {
		return mileages;
	}

	public void setMileages(String mileages) {
		this.mileages = mileages;
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
}
