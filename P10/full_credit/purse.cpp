#include "purse.h"

Purse::Purse(int pounds, int shillings, int pence)
	: _pounds{pounds}, _shillings{shillings}, _pence{pence} {
		// rationalize();
}

std::ostream& operator<<(std::ostream& ost, const Purse& purse) {
}
