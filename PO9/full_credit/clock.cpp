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

		void print() {
			std::cout << std::setfill('0') << std::setw(2) << _hours << ":"
        	          << std::setfill('0') << std::setw(2) << _minutes << ":"
	                  << std::setfill('0') << std::setw(2) << _seconds << std::endl;
		}

		void _tick() {
			_seconds++; 
			if (_seconds == 60) {
				_seconds = 0;
				_minutes++;
			}
			if (_minutes == 60) {
				_minutes = 0;
				_hours++;
			}
			if (_hours == 24) {
				_hours = 0;
			}
		}
	

	protected:
		int _hours, _minutes, _seconds;
};

int main (){

}
