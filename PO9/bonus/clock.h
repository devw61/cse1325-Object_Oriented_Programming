#ifndef _CLOCK_H
#define _CLOCK_H

class Clock
{
public:
    Clock(int hours, int minutes, int seconds);
    virtual ~Clock();
    void print();
    void tick();

private:
    int _hours, _minutes, _seconds;
};

#endif