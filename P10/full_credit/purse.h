#ifndef __PURSE_H
#define __PURSE_H

#include <iostream>

class Purse {
	public:
		Purse(int pounds = 0, int shillings = 0, int pence = 0);
		friend std::ostream& operator<<(std::ostream& ost, const Purse& purse);
		auto operator<=>(const Purse&) const = default;
		Purse& operator++();
		Purse operator++(int);
		Purse operator+(const Purse&);
		Purse operator-(const Purse&);
		Purse& operator+=(const Purse&);
		Purse& operator-=(const Purse&);
		void rationalize();

	private:
		int _pounds;
		int _shillings;
		int _pence;
};

#endif
