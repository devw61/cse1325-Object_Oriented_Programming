#ifndef __DATE_H
#define __DATE_H

#include <iostream>

class Date {
	public:
		Date(int year, int month, int day);
		friend std::ostream& operator<<(std::ostream& ost, const Date& date);
		auto operator<=>(const Date&);
	private:
		int _year;
		int _month;
		int _day;
};

#endif