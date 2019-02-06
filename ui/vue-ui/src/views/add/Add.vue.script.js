// @ is an alias to /src
import ProblemDisplay from '@/components/ProblemDisplay.vue'
import UserInput from '@/components/UserInput.vue'
import {
  clearTimeout
} from 'timers'

export default {
  name: 'add',
  components: {
    UserInput,
    ProblemDisplay
  },
  data: function () {
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
        min: 100,
        max: 999,
        duration: 2
      }
    }
  },
  methods: {
    activate: function (size, min, max) {
      console.log(`calling activete(${size}, ${min}, ${max} )`)
      this.input.size = size
      this.input.min = min
      this.input.max = max
      fetch('https://math.vpv.io/api/add?size=' + this.input.size + '&min=' + this.input.min + '&max=' + this.input.max + '')
        .then(response => response.json())
        .then(data => {
          this.responsesBackup = []
          this.responses = data
          this.initTimer()
        })
    },
    finish: function () {
      this.result()
    },
    result: function () {
      var handler = []
      if (this.responses && this.responses.length) {
        handler = this.responses
      } else if (this.responsesBackup && this.responsesBackup.length) {
        handler = this.responsesBackup
      } else {
        console.log('No Test in progress')
      }
      if (handler && handler.length) {
        // console.log('Response: ', handler);
        this.computedResult.total = handler.length
        this.computedResult.correctAnswers = 0
        handler.forEach(r => {
          if (r.answer === r.result) {
            this.computedResult.correctAnswers++
            this.computedResult.score = (100.0 * this.computedResult.correctAnswers / handler.length)
          }
        })
      }
    },
    initTimer: function () {
      this.clearTimer()
      this.internal.mins = this.input.duration
      this.internal.seconds = this.internal.mins * 60
      this.internal.timeout = setTimeout(this.timerFunction, 60)
    },
    clearTimer: function () {
      this.minutes = this.pad(0, 2)
      this.seconds = this.pad(0, 2)
      if (this.internal.timeout && this.internal.timeout.close) {
        clearTimeout(this.internal.timeout)
      }
    },
    pad: function (n, width, z) {
      z = z || '0'
      n = n + ''
      return n.length >= width ? n : new Array(width - n.length + 1).join(z) + n
    },
    getminutes: function () {
      // minutes is seconds divided by 60, rounded down
      this.internal.mins = Math.floor(this.internal.seconds / 60)
      return this.pad(this.internal.mins, 2)
    },

    getseconds: function () {
      // take minutes remaining (as seconds) away
      // from total seconds remaining
      return this.pad(this.internal.seconds - Math.round(this.internal.mins * 60), 2)
    },
    timerFunction: function () {
      // this.minutes = this.internal.mins;
      // this.seconds = this.internal.seconds;

      // if less than a minute remaining
      // Display only seconds value.
      if (this.internal.seconds < 59) {
        this.seconds = this.internal.seconds
      } else {
        // Display both minutes and seconds
        // getminutes and getseconds is used to
        // get minutes and seconds
        this.minutes = this.getminutes()
        this.seconds = this.getseconds()
      }
      // //when less than a minute remaining
      // //colour of the minutes and seconds
      // //changes to red
      // if (this.internal.mins < 1) {
      //   minutes.style.color = "red";
      //   seconds.style.color = "red";
      // }

      // if seconds becomes zero,
      // then page alert time up
      if (this.internal.seconds < 0) {
        this.responsesBackup = this.responses
        this.responses = []
        this.clearTimer()
      } else {
        // if seconds > 0 then seconds is decremented
        this.internal.seconds--
        this.internal.timeout = setTimeout(this.timerFunction, 1000)
      }
      this.timer = '' + this.minutes + ':' + this.seconds
    }
  },
  created: function () {
    this.clearTimer()
  }
}
