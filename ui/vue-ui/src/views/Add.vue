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
    <section class="result" v-if="computedResult.total &gt; 0">
      <table border="1" class="results">
        <tr>
            <th>Total Questions </th>
            <td>{{ computedResult.total }}</td>
        </tr>
        <tr>
            <th>Correct Answers </th>
            <td>{{ computedResult.correctAnswers }}</td>
        </tr>
        <tr>
            <th>Your Score</th>
            <td>{{ computedResult.score }}</td>
        </tr>
      </table>
    </section>
    <div v-for="r in responses" :key="r.$index" class="main">
      <ProblemDisplay :response="r" />
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
      computedResult: {
        total: 0,
        correctAnswers: 0,
        score: 0
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
          this.responsesBackup = [];
          this.responses = data;
          this.initTimer();
        });
    },
    finish: function() {
        this.result();
    },
    result: function () {
      var handler = [];
      if (this.responses && this.responses.length) {
        handler = this.responses;
      } else if (this.responsesBackup && this.responsesBackup.length) {
        handler = this.responsesBackup;
      } else {
        console.log('No Test in progress');
      }
      if (handler && handler.length) {
        //console.log('Response: ', handler);
        this.computedResult.total = handler.length;
        this.computedResult.correctAnswers = 0;
        handler.forEach(r => {
          if (r.answer == r.result) {
              this.computedResult.correctAnswers++;
              this.computedResult.score = (100.0 * this.computedResult.correctAnswers/handler.length);
          }
        });
      }
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
.results {
    margin-left:auto;
    margin-right:auto;
}
table.results {
  border: 3px solid #000000;
  text-align: left;
  border-collapse: collapse;
}
table.results td, table.results th {
  border: 1px solid #000000;
  padding: 5px 10px;
}
table.results tbody td {
  font-size: 13px;
}
table.results th {
  background: #CFCFCF;
  background: -moz-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  background: -webkit-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  background: linear-gradient(to bottom, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  border-right: 3px solid #000000;
}
table.results th {
  font-size: 15px;
  font-weight: bold;
  color: #000000;
  text-align: left;
}
table.results  td {
  font-size: 14px;
}
</style>
