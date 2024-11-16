#include "date.h"

#include <fstream>
#include <map>

typedef double Temp; 
typedef std::map<Date, Temp> temps;

int main(int argc, char* argv[]){
    	if (argc != 2) {
		std::cerr << "Usage: <program name> <data file>" << std::endl;
    	}
	
	std::ifstream ifs {std::string{argv[1]}};
	if (!ifs) {
        	throw std::runtime_error{"Can't open input file " + std::string{argv[1]}};
	        return -1;
    	}

	while (ifs){
		for (int i = 0; i < 4; i++) ifs.ignore();
	}
	
}
