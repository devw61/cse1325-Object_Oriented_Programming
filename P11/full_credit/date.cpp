#include "date.h"
#include <iomanip>

Date::Date(int year, int month, int day)
	: _year(year), _month(month), _day(day) {
		if (_year < 1970 || _year > 2024) throw std::out_of_range{"Error - year must be between 1970 and 2024"};
		if (_month < 1 || _month > 12) throw std::out_of_range{"Error - month must be between 1 and 12"};
		if (_day < 1 || _day > 31) throw std::out_of_range{"Error - day must be between 1 and 31"};
}

std::ostream& operator<<(std::ostream& ost, const Date& date) {
    ost << date._year << "/"
        << std::setfill('0') << std::setw(2) << date._month << "/"
        << std::setfill('0') << std::setw(2) << date._day;
    return ost;
}
