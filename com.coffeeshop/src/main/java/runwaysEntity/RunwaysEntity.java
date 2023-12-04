package runwaysEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="runways")
public class RunwaysEntity {
	@Id
	@Column(name="runways_code")
	private int runways_code;
	
	@Column(name="runways_length")
	private int runways_length;
	
	@Column(name="runways_width")
	private int runways_width;
	
	@Column(name="runways_suit")
	private String runways_suit;
	
	@Column(name="runways_direction")
	private String runways_direction;
	
	
	public RunwaysEntity() {
		System.out.println("runwaysEntity ()");
		
	}
	
	public RunwaysEntity(int runways_length, int runways_width, String runways_suit,
			String runways_direction) {
		this.runways_length = runways_length;
		this.runways_width = runways_width;
		this.runways_suit = runways_suit;
		this.runways_direction = runways_direction;
	}

	public RunwaysEntity(int runways_code, int runways_length, int runways_width, String runways_suit,
			String runways_direction) {
		this.runways_code = runways_code;
		this.runways_length = runways_length;
		this.runways_width = runways_width;
		this.runways_suit = runways_suit;
		this.runways_direction = runways_direction;
	}

	public int getRunways_code() {
		return runways_code;
	}

	public void setRunways_code(int runways_code) {
		this.runways_code = runways_code;
	}

	public int getRunways_length() {
		return runways_length;
	}

	public void setRunways_length(int runways_length) {
		this.runways_length = runways_length;
	}

	public int getRunways_width() {
		return runways_width;
	}

	public void setRunways_width(int runways_width) {
		this.runways_width = runways_width;
	}

	public String getRunways_suit() {
		return runways_suit;
	}

	public void setRunways_suit(String runways_suit) {
		this.runways_suit = runways_suit;
	}

	public String getRunways_direction() {
		return runways_direction;
	}

	public void setRunways_direction(String runways_direction) {
		this.runways_direction = runways_direction;
	}

	@Override
	public String toString() {
		return "runwaysEntity [runways_code=" + runways_code + ", runways_length=" + runways_length + ", runways_width="
				+ runways_width + ", runways_suit=" + runways_suit + ", runways_direction=" + runways_direction + "]";
	}

}
