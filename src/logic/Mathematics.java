package logic;

public class Mathematics {
	
	public double getSqrt(double value) {
		value = Math.sqrt(value);
		return Math.floor(value * 100) / 100;
	}
	
	public String getSqrt(String value) {
		var doubleValue = Double.parseDouble(value);
		
		var result = getSqrt(doubleValue);
		
		return Double.toString(result);
	}
	
	public double gerPow(double base, double power) {
		var value = Math.pow(base, power);
		return Math.floor(value * 100) / 100;
	}
	
	public String gerPow(String base, String power) {
		var doubleBase = Double.parseDouble(base);
		var doublePower = Double.parseDouble(power);
		
		var result = gerPow(doubleBase, doublePower);
		
		return Double.toString(result);
	}
	
	private static Mathematics _instance;
	
	public static Mathematics getInstance() {
		if(_instance == null)
			_instance = new Mathematics();
		return _instance;
	}
}
