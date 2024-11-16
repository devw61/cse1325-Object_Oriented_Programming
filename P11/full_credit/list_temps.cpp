#include "date.h"

#include <fstream>
#include <map>

typedef double Temp; 
typedef std::map<Date, Temp> temps;

int main(int argc, char* argv[]){
    	if (argc != 2) {
		std::cerr << "Usage: <program name> <data file>" << std::endl;
        return -1;
    	}
	
	std::ifstream ifs {std::string{argv[1]}};
	if (!ifs) {
        	throw std::runtime_error{"Can't open input file " + std::string{argv[1]}};
	        return -2;
    	}

	while (ifs){
		std::string val;
        int year, month, day;

		for (int i = 0; i < 7; i++){
            if (i == 4){
                std::getline(ifs, val, ',');
                month = std::stoi(val);
            } else if (i == 5){
                std::getline(ifs, val, ',');
                day = std::stoi(val);
            } else if (i == 6){
                std::getline(ifs, val, ',');
                year = std::stoi(val);
            } else {
                std::getline(ifs, val, ',');
            } 
        }
        Date date{year, month, day};
    }
        
}
