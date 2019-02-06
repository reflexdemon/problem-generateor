<template>
  <div class="problem-display">
    <div class="problem" style="width: 200px;">

        {{response.firstNumber}}
      <br>{{response.operator}} {{response.secondNumber}}

      <br>
      <input type="number" name="answer" v-model="response.result"  autocomplete="off">
    </div>
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
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

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
