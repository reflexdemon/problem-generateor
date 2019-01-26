<template>
  <div class="add">
    <h1>Addition Problem</h1>
    <p>
      <UserInput
            :size="input.size"
            :min="input.min"
            :max="input.max"
            @activate-timer="activate"
       />
    </p>
    
    <section id="stopWatch">
      <p id="timer">Time : {{ timer }}</p>
    </section>
    <div v-for="r in responses" :key="r.$index" class="main">
      <ProblemDisplay
        :firstNumber="r.firstNumber"
        :secondNumber="r.secondNumber"
        :answer="r.answer"
        :operator="r.operator"
      />
    </div>
    <button v-on:click="finish" v-if="responses.length">Finish</button>
  </div>
</template>

<script>
// @ is an alias to /src
import ProblemDisplay from "@/components/ProblemDisplay.vue";
import  UserInput from "@/components/UserInput.vue";
import { clearTimeout } from 'timers';


export default {
  name: "add",
  components: {
    UserInput,
    ProblemDisplay
  },
  data: function() {
    return {
      responses: [],
      responsesBackup: [],
      timer: '00:00',
      minutes: 0,
      seconds: 0,
      internal: {
        mins: 2,
        seconds: 0,
        timeout: function () {}
      },
      input: {
        size: 10,
        min:100,
        max:999
      }
    };
  },
  methods: {
    activate: function(size, min, max) {
      this.input.size = size;
      this.input.min = min;
      this.input.max = max;
      fetch('https://math.vpv.io/api/add?size='+ this.input.size + '&min='+ this.input.min + '&max='+ this.input.max + '')
        .then(response => response.json())
        .then(data => {
          this.responses = data;
          this.initTimer();
        });
    },
    finish: function() {
      
    },
    result: function () {

    },
    initTimer: function() {
          this.clearTimer();
          this.internal.mins = 1;
          this.internal.seconds = this.internal.mins * 60;
          this.internal.timeout = setTimeout(this.timerFunction, 60);
    },
    clearTimer: function () {
      this.minutes = this.pad(0,2);
      this.seconds = this.pad(0,2);
      if (this.internal.timeout && this.internal.timeout.close) {
        clearTimeout(this.internal.timeout);
      }
    },
    pad: function(n, width, z) {
          z = z || '0';
          n = n + '';
          return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n;
    },
    getminutes: function() {
      //minutes is seconds divided by 60, rounded down
      this.internal.mins = Math.floor(this.internal.seconds / 60);
      return this.pad(this.internal.mins, 2);
    },

    getseconds: function() {
      //take minutes remaining (as seconds) away
      //from total seconds remaining
      return this.pad(this.internal.seconds - Math.round(this.internal.mins * 60), 2);
    },
    timerFunction: function() {
      // this.minutes = this.internal.mins;
      // this.seconds = this.internal.seconds;

      //if less than a minute remaining
      //Display only seconds value.
      if (this.internal.seconds < 59) {
        this.seconds = this.internal.seconds;
      }

      //Display both minutes and seconds
      //getminutes and getseconds is used to
      //get minutes and seconds
      else {
        this.minutes = this.getminutes();
        this.seconds = this.getseconds();
      }
      // //when less than a minute remaining
      // //colour of the minutes and seconds
      // //changes to red
      // if (this.internal.mins < 1) {
      //   minutes.style.color = "red";
      //   seconds.style.color = "red";
      // }

      //if seconds becomes zero,
      //then page alert time up
      if (this.internal.seconds < 0) {
        this.responsesBackup = this.responses;
        this.responses = [];
        this.clearTimer();
      }
      //if seconds > 0 then seconds is decremented
      else {
        this.internal.seconds--;
        this.internal.timeout = setTimeout(this.timerFunction, 1000);
      }
      this.timer = '' + this.minutes + ':' + this.seconds;
    }
  },
  created: function() {
    this.clearTimer();
  }
};
</script>
<style scoped>
/* Main column */
.main {
  flex: 30%;
  background-color: #f1f1f1;
  padding: 20px;
  flex-direction: row;
}
/* Responsive layout - when the screen is less than 700px wide, make the two columns stack
   on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
  .main {
    flex-direction: columns;
  }
}
#stopWatch {
  width: 280px;
  height: auto;
  text-align: center;
  display: block;
  padding: 5px;
  margin: 0 auto;
}
#timer,
#fulltime {
  width: auto;
  height: auto;
  padding: 10px;
  font-weight: bold;
  font-family: tahoma;
  display: block;
  border: 1px solid #eee;
  text-align: center;
  box-shadow: 0 0 5px #ccc;
  background: #fbfbf0;
  color: darkblue;
  border-bottom: 4px solid darkgrey;
}
button {
  cursor: pointer;
  font-weight: 700;
}
#fulltime {
  display: none;
  font-size: 16px;
  font-weight: bold;
}
</style>
