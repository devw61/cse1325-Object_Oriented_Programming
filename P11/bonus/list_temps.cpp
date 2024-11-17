#include "date.h"

#include <fstream>
#include <map>

typedef double Temp; 
typedef std::map<Date, Temp> Temps;

int main(int argc, char* argv[]){
    int start_year, start_month, start_day, end_year, end_month, end_day;
    Temps temps;

    if (argc != 2)
    {
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

        std::getline(ifs, val, ',');
        temps[date] = std::stod(val);

        std::getline(ifs, val, '\n'); // ignore new line char
    }

    while (true){
        std::cout << "Enter start date (year month day): ";
        std::cin >> start_year >> start_month >> start_day;
        if (!std::cin) break;
        Date start_date{start_year, start_month, start_day};

        std::cout << "Enter end date (year month day): ";
        std::cin >> end_year >> end_month >> end_day;
        if (!std::cin) break;
        Date end_date{end_year, end_month, end_day};

        std::cout << std::endl << "Temperatures between " << start_date << " and " << end_date << ":" << std::endl << std::endl;

        auto it = temps.find(start_date);
        while (it != temps.find(end_date)){
            Date current_date = it->first;
            int current_temp = it->second;
            if (current_date >= start_date && current_date <= end_date){
                std::cout << it->first << " " << it->second << std::endl;
            }
            it++;
        }
    }
        
}
