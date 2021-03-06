package day13;

public class RadioController implements Controller{
	private double frequency;
	private int volume;
	private boolean power;
	
	@Override
	public void run() {
		power = true;
		System.out.println("라디오 전원이 켜집니다.");
	}

	@Override
	public void stop() {
		power = false;
		System.out.println("라디오 전원이 꺼집니다.");
		
	}

	@Override
	public void print() {
		System.out.println("전원 : " + (power?"켜짐":"꺼짐"));
		System.out.println("주파수 : " + frequency);
		System.out.println("음량 : " + volume);
	}
	public void frequencyUP(){
		frequency = power ? frequency+0.1 : frequency;
	}
	public void frequencyDOWN(){
		frequency = power ? frequency-0.1 : frequency;
	}
	public void volumeUP(){
		volume = power ? volume+1 : volume;
	}
	public void volumeDOWN(){
		volume = power ? volume-1 : volume;
	}
}
