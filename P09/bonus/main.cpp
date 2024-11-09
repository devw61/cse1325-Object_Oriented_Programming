#include <iostream>
#include <array>

#include "timer.h"

int main(int argc, char *argv[]){

    if (argc != 4){
        std::cerr << "Usage: <hours> <minutes> <seconds>" << std::endl;
        exit(-1);
    }

    try {
        Timer timer(std::stoi(argv[1]), std::stoi(argv[2]), std::stoi(argv[3]));
        timer.print();
        while (std::cin.get() != 'q') {
            timer.tick();
            timer.print();
        }
    } catch (std::runtime_error& e) {
        std::cerr << e.what() << std::endl;
        exit(-1);
    }

}
