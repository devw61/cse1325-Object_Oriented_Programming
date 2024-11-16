#include "date.h"
#include <iomanip>
#include <compare> // Include this header for operator<=>

Date::Date(int year, int month, int day)
	: _year(year), _month(month), _day(day) {
		if (_year < 1970 || _year > 2024) throw std::out_of_range{"Error - year must be between 1970 and 2024: " + std::to_string(_year)};
		if (_month < 1 || _month > 12) throw std::out_of_range{"Error - month must be between 1 and 12: " + std::to_string(_month)};
		if (_day < 1 || _day > 31) throw std::out_of_range{"Error - day must be between 1 and 31: " + std::to_string(_day)};
}

std::ostream& operator<<(std::ostream& ost, const Date& date) {
    ost << date._year << "/"
        << std::setfill('0') << std::setw(2) << date._month << "/"
        << std::setfill('0') << std::setw(2) << date._day;
    return ost;
}
