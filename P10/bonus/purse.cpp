#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence)
	: _pounds{pounds}, _shillings{shillings}, _pence{pence} {
		rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse){
	ost << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
	return ost;
}

std::istream &operator>>(std::istream& ist, Purse& purse){
	char pound_sign, s, d;
	ist >> pound_sign >> purse._pounds >> purse._shillings >> s >> purse._pence >> d;
	if (pound_sign != '#' || s != 's' || d != 'd') {
		ist.setstate(std::ios::failbit);
	}
	return ist;
}

Purse& Purse::operator++(){
	++_pence;
	rationalize();
	return *this;
}

Purse Purse::operator++(int){
	Purse old_purse{*this};
	++_pence;
	rationalize();
	return old_purse;
}

Purse Purse::operator+(const Purse& other) {
    Purse result{_pounds + other._pounds, _shillings + other._shillings, _pence + other._pence};
    result.rationalize();
    return result;
}

Purse Purse::operator-(const Purse& other) {
    Purse result{_pounds - other._pounds, _shillings - other._shillings, _pence - other._pence};
    result.rationalize();
    return result;
}

Purse& Purse::operator+=(const Purse& other) {
	_pounds += other._pounds;
	_shillings += other._shillings;
	_pence += other._pence;
	rationalize();
	return *this;
}

Purse& Purse::operator-=(const Purse& other) {
	_pounds -= other._pounds;
	_shillings -= other._shillings;
	_pence -= other._pence;
	rationalize();
	return *this;
}

void Purse::rationalize() {
	if (_pence < 0) {
		int borrow_shillings = (-_pence + 11) / 12;
		_shillings -= borrow_shillings;
		_pence += borrow_shillings * 12;
	}
	if (_pence >= 12) {
		_shillings += _pence / 12;
		_pence %= 12;
	}

	if (_shillings < 0) {
		int borrow_pounds = (-_shillings + 19) / 20;
		_pounds -= borrow_pounds;
		_shillings += borrow_pounds * 20;
	}
	if (_shillings >= 20) {
		_pounds += _shillings / 20;
		_shillings %= 20;
	}
}

