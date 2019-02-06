<template>
  <div class="user-input">
    <v-card>
      <v-card-title primary-title>
        <div>
          <h3 class="headline mb-0">{{title}}</h3>
          <div>Please enter the configuration to generate the puzzles</div>
        </div>
      </v-card-title>
      <v-container fill-height fluid pa-2>
        <v-layout fill-height>
          <v-flex xs12 lg4 md8 flexbox>
            <v-text-field label="Number of problems" type="number" v-model.number="input.size" name="size" />
            <v-text-field label="Starting Value" type="number" v-model.number="input.min" name="min" />
            <v-text-field label="Ending Value" type="number" v-model.number="input.max" name="max" />

            <v-slider
                v-model.number="input.duration"
                :thumb-size="24"
                hint="Please choose the test duration."
                min="1"
                max="15"
                label="Duration in minutes">
                </v-slider>
          </v-flex>
        </v-layout>
      </v-container>
      <v-card-actions class="justify-center">
        <v-btn color="green" v-on:click="activateTimer">Start Timer</v-btn>
      </v-card-actions>
    </v-card>
  </div>
</template>
<script>
export default {
  name: 'UserInput',
  data: function () {
    return {
      input: {
        size: this.size,
        min: this.min,
        max: this.max,
        duration: this.duration
      }
    }
  },
  props: {
    size: Number,
    min: Number,
    max: Number,
    duration: Number,
    title: String
  },
  methods: {
    activateTimer: function () {
      console.log('Emmiting activate-timer event')
      this.$emit(
        'activate-timer',
        this.input.size,
        this.input.min,
        this.input.max,
        this.input.duration
      )
    }
  }
}

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.inputForm {
  display: inline-block;
  height: 200px;
  background-color: #aaa;
  padding: 20px;
  text-align: left;
  /* font-size: 70px; */
  margin-right: 10%;
  border: 2px solid #908b85;
  border-radius: 20px;
  box-shadow: 7px 10px 34px 1px rgba(0, 0, 0, 0.68),
    inset -1px -6px 12px 0.1px #89847e;
}

</style>
