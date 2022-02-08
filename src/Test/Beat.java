package Test;

public class Beat {// storing Notes' Time and note name
private int time;
private String noteName;

public int getTime() {
	return time;
}

public void setTime(int time) {
	this.time = time;
}
public String getNoteName() {
	return noteName;
}
public void setNoteName(String noteName) {
	this.noteName = noteName;
}

public Beat(int time, String noteName) {
	super();
	this.time = time;
	this.noteName = noteName;
}
}
