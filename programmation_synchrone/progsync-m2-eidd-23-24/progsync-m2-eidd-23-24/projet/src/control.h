/* --- Generated the 6/12/2023 at 11:35 --- */
/* --- heptagon compiler, version 1.05.00 (compiled wed. oct. 4 11:30:52 CET 2023) --- */
/* --- Command line: /home/karolsamir/.opam/default/bin/heptc -c -target c control.ept --- */

#ifndef CONTROL_H
#define CONTROL_H

#include "control_types.h"
#include "globals.h"
#include "mathext.h"
#include "utilities.h"
typedef struct Control__ecart_out {
  float e;
} Control__ecart_out;

void Control__ecart_step(Globals__sensors sens, Control__ecart_out* _out);

typedef struct Control__controller_mem {
  Utilities__integrator_mem integrator;
  Utilities__derivative_mem derivative;
  Utilities__integrator_mem integrator_1;
  Utilities__derivative_mem derivative_1;
} Control__controller_mem;

typedef struct Control__controller_out {
  Globals__wheels rspeed;
  int arriving;
} Control__controller_out;

void Control__controller_reset(Control__controller_mem* self);

void Control__controller_step(Globals__sensors sens, Globals__itielts iti,
                              Control__controller_out* _out,
                              Control__controller_mem* self);

#endif // CONTROL_H
