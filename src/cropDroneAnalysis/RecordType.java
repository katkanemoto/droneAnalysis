package cropDroneAnalysis;

public interface RecordType {
	
		public String getStation();
		public void setStation(String station);
		public String getDate();		
		public int getMonth() ;		
		public int getDay() ;
		public int getYear() ;		
		public int getHour();
		public void setDate(String date);
		public double getTemp() ;
		public void setTemp(double temp) ;
		public double getHumidity() ;
		public void setHumidity(double humidity) ;
		public double getWindSpeed() ;
		public void setWindSpeed(double windSpeed) ;
		public double getWindDirection() ;
		public void setWindDirection(double windDirection) ;
		public void setRecordAsString(String recordAsString) ;
		@Override
		public String toString() ;

}
