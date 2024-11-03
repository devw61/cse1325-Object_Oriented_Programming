#include <iostream>
#include <array>

#include "clock.h"

int main(int argc, char *argv[]){

    if (argc != 4){
        std::cerr << "Usage: <hours> <minutes> <seconds>" << std::endl;
        exit(-1);
    }

    try {
        Clock clock(std::stoi(argv[1]), std::stoi(argv[2]), std::stoi(argv[3]));
        while (std::cin.get() != 'q') {
            clock.tick();
            clock.print();
        }
    } catch (std::out_of_range& e) {
        std::cerr << e.what() << std::endl;
        exit(-1);
    }

}
