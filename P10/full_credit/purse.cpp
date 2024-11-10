#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence)
	: _pounds{pounds}, _shillings{shillings}, _pence{pence} {
		// rationalize();
}

// std::ostream &operator<<(std::ostream &ost, const Purse &purse){
// 	ost << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
// 	return ost;
// }

Purse& Purse::operator++(){
	++_pence;
	// rationalize();
	return *this;
}

Purse Purse::operator++(int){
	Purse purse{*this};
	++_pence;
	// rationalize();
	return purse;
}

Purse Purse::operator+(const Purse& other) {
    return Purse(_pounds + other._pounds, _shillings + other._shillings, _pence + other._pence);
}

Purse Purse::operator-(const Purse& other) {
    return Purse(_pounds - other._pounds, _shillings - other._shillings, _pence - other._pence);
}

Purse& Purse::operator+=(const Purse& other) {
	_pounds += other._pounds;
	_shillings += other._shillings;
	_pence += other._pence;
	return *this;
}

Purse& Purse::operator-=(const Purse& other) {
	_pounds -= other._pounds;
	_shillings -= other._shillings;
	_pence -= other._pence;
	return *this;
}

void Purse::rationalize() {
	if (_pence >= 20){
		_shillings += _pence / 20;
		_pence %= 20;
	}
	if (_shillings >= 12){
		_pounds += _shillings / 12;
		_shillings %= 12;
	}
}

