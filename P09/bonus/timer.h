#ifndef _TIMER_H
#define _TIMER_H

#include <iostream>
#include <stdexcept>

#include "clock.h"

class Timer : public Clock {
	public:
		Timer(int hours, int minutes, int seconds);
		virtual ~Timer();
		void tick();
};

#endif
