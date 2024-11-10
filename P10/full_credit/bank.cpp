#include "purse.h"

#include <map>
#include <iomanip>

int main(){
    int num_accounts, pounds, shillings, pence;
    std::string name;

    std::map<std::string, Purse> vault;
    
    std::cout << "How many accounds do you want to create? ";
    std::cin >> num_accounts;
    std::cin.ignore(); 

    for (int i = 0; i < num_accounts; i++){
        std::cout << std::endl << "Enter name for account " << i + 1 << ": ";
        std::getline(std::cin, name);
        std::cout << "Enter Initial Deposite for account " << name << ": ";
        std::cin >> pounds >> shillings >> pence;
        std::cin.ignore(); 
        vault[name] = Purse(pounds, shillings, pence);
        std::cout << "Accound " << name << " created with " << vault[name] << std::endl ;
    }

    Purse total;

    std::cout << std::endl << "Account List:" << std::endl;
    for (auto& [name, purse] : vault){
        std::cout << std::setfill(' ') << std::setw(15) << name << " : " << purse << std::endl;
        total += purse;
    }

    std::cout << std::endl << "Total in vault: " << total << std::endl;

    return 0;
}