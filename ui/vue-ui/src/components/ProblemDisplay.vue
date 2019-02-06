<template>
  <div class="problem-display">
    <v-card>
<v-card-text >
  <v-badge> {{timer}} </v-badge>
<div class="display-4 text-xs-right">{{response.firstNumber}}</div>
<div class="display-4 text-xs-right">{{response.operator}} {{response.secondNumber}}</div>
</v-card-text>
  <v-card-actions>
    <v-text-field id="styled-input" height="120" type="number" name="answer" v-model="response.result"  autocomplete="off"/>
  </v-card-actions>
</v-card>
  </div>
</template>

<script>
export default {
  name: 'ProblemDisplay',
  props: {
    response: {
      firstNumber: Number,
      secondNumber: Number,
      answer: Number,
      result: Number,
      operator: String
    },
    timer: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

#styled-input {
    font-size: 112px !important;
    font-weight: 300;
}

.problem {
  display: inline-block;
  height:300px;
  background-color: #aaa;
  padding: 20px;
  text-align: right;
  font-size: 70px;
  margin-right: 10%;
  border: 2px solid #908b85;
  border-radius: 20px;
  box-shadow:
    7px 10px 34px 1px
    rgba(0, 0, 0, 0.68),
    inset -1px -6px 12px 0.1px
    #89847e;
}
input {
    font-size: 70px;
    text-align: right;
    width: 100%;
}
</style>
