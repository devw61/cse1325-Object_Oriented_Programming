#include <iostream>
#include <string>
#include <stdexcept>
#include <iomanip>
class Clock {
	public:
		Clock(int hours, int minutes, int seconds): 
			_hours(hours), _minutes(minutes), _seconds(seconds) {
				std::string error;
				if (hours > 24 || hours < 0) {
        	            throw std::out_of_range("ERROR - hours out of range: " + std::to_string(hours));
                	} else if (minutes > 60 || minutes < 0) {
                    	throw std::out_of_range("ERROR - hours out of range: " + std::to_string(hours));
                	} else if (seconds > 60 || seconds < 0 ){
                    	throw std::out_of_range("ERROR - hours out of range: " + std::to_string(hours));
                	}
		}	

		virtual ~Clock ();

		

	protected:
		int _hours, _minutes, _seconds;
};

int main (){

}
