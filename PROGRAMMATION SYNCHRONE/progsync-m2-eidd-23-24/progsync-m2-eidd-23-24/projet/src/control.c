/* --- Generated the 6/12/2023 at 11:35 --- */
/* --- heptagon compiler, version 1.05.00 (compiled wed. oct. 4 11:30:52 CET 2023) --- */
/* --- Command line: /home/karolsamir/.opam/default/bin/heptc -c -target c control.ept --- */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "control.h"

void Control__ecart_step(Globals__sensors sens, Control__ecart_out* _out) {
  Mathext__float_out Mathext__float_out_st;
  
  int v;
  v = (sens.s_road.red-sens.s_road.green);
  Mathext__float_step(v, &Mathext__float_out_st);
  _out->e = Mathext__float_out_st.o;;
}

void Control__controller_reset(Control__controller_mem* self) {
  Utilities__derivative_reset(&self->derivative_1);
  Utilities__integrator_reset(&self->integrator_1);
  Utilities__derivative_reset(&self->derivative);
  Utilities__integrator_reset(&self->integrator);
}

void Control__controller_step(Globals__sensors sens, Globals__itielts iti,
                              Control__controller_out* _out,
                              Control__controller_mem* self) {
  Control__ecart_out Control__ecart_out_st;
  Utilities__integrator_out Utilities__integrator_out_st;
  Utilities__derivative_out Utilities__derivative_out_st;
  
  float v_16;
  float v_15;
  float v_14;
  float v_13;
  float v_12;
  float v_11;
  float v_10;
  float v_9;
  float v_8;
  float v_7;
  float v_6;
  float v_5;
  float v_4;
  float v_3;
  float v_2;
  float v_1;
  float v;
  float k;
  float e;
  float ki;
  float kd;
  Control__ecart_step(sens, &Control__ecart_out_st);
  e = Control__ecart_out_st.e;
  _out->arriving = false;
  Utilities__derivative_step(e, Globals__timestep,
                             &Utilities__derivative_out_st,
                             &self->derivative_1);
  v_14 = Utilities__derivative_out_st.y;
  Utilities__integrator_step(e, Globals__timestep, 0.000000,
                             &Utilities__integrator_out_st,
                             &self->integrator_1);
  v_11 = Utilities__integrator_out_st.o;
  Utilities__derivative_step(e, Globals__timestep,
                             &Utilities__derivative_out_st, &self->derivative);
  v_6 = Utilities__derivative_out_st.y;
  Utilities__integrator_step(e, Globals__timestep, 0.000000,
                             &Utilities__integrator_out_st, &self->integrator);
  v_3 = Utilities__integrator_out_st.o;
  k = 0.500000;
  v_9 = (k*e);
  v_1 = (k*e);
  kd = (0.125000*k);
  v_15 = (kd*v_14);
  v_7 = (kd*v_6);
  ki = (0.250000*k);
  v_12 = (ki*v_11);
  v_4 = (ki*v_3);
  v = 500.000000;
  v_10 = (v+v_9);
  v_13 = (v_10+v_12);
  v_16 = (v_13+v_15);
  v_2 = (v-v_1);
  v_5 = (v_2-v_4);
  v_8 = (v_5-v_7);
  _out->rspeed.left = v_8;
  _out->rspeed.right = v_16;;
}

