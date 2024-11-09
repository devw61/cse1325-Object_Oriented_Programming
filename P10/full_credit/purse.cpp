#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence)
	: _pounds{pounds}, _shillings{shillings}, _pence{pence} {
		// rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse) {
	ost << "£" << purse._pounds << " " << purse._shillings << "s" << purse._pence << "d";
	return ost;
}


